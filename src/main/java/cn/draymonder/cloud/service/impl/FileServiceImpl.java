package cn.draymonder.cloud.service.impl;

import cn.draymonder.cloud.dao.FileDao;
import cn.draymonder.cloud.entity.Files;
import cn.draymonder.cloud.entity.User;
import cn.draymonder.cloud.service.FileService;
import cn.draymonder.cloud.utils.PathUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * @auther draymonder
 */
@Service
public class FileServiceImpl implements FileService {
    Logger log = LoggerFactory.getLogger(FileServiceImpl.class);
    @Autowired
    private FileDao fileDao;

    @Override
    @Transactional
    public int createFile(MultipartFile file, User user, String md5) {
        int userId = user.getUserId();
        Files files = new Files();
        files.setOwnerId(userId);
        // 实际存放的文件信息
        File store = null;
        try {
            String basePath = PathUtil.getBasePath();
            String userPath = PathUtil.getRelativePath(userId);
            String originName = file.getOriginalFilename();
            // 实际存放的目录
            String realFolderStr = basePath + userPath;
            File folder = new File(realFolderStr);
            // 如若目录不存在, 创建之
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String path = userPath + originName;
            store = new File(realFolderStr, (int)(Math.random()*1000) + originName);
            // 打印真实目录的路径
            log.info("存储路径:" + store.getAbsolutePath());

            if (file.isEmpty())
                files.setFileType(0);
            else
                files.setFileType(1);
            files.setFilePath(userPath + originName);

            files.setFileSize((int) file.getSize());
            files.setFileName(originName);

            files.setMd5(md5);

            Date now = new Date(System.currentTimeMillis());
            files.setCreateTime(now);
            files.setLastEditTime(now);

            // 写文件
            file.transferTo(store);
            int effectedNum = fileDao.insertFile(files);
            if (effectedNum >= 1) {
                log.info(file.getName());
                List<Files> filesList = fileDao.selectFileByNormalName(originName);
                if(filesList.size() <= 0)
                    return -1;
                return filesList.get(0).getFileId();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    @Transactional
    public boolean deleteFile(int userId, int fileId) {
        // 我还需要删除文件目录下的文件
        String realFileStr = PathUtil.getBasePath() + fileDao.selectFilePath(userId, fileId);
        File nowfile = new File(realFileStr);
        // 先删除具体的文件
        boolean deleteFile = nowfile.delete();
        if (deleteFile == true) {
            // 再删除表中的信息
            int nums = fileDao.deleteFile(fileId);
            return nums > 0;
        }
        return false;
    }

    @Override
    public List<Files> getFileByFilename(String filename) {
        return fileDao.selectFileByName(filename + "%");
    }

    @Override
    public Files getFileByFileId(int fileId) {
        if (fileId <= 0)
            return null;
        return fileDao.selectFileByFileId(fileId);
    }

}
