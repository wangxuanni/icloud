package cn.draymonder.cloud.service.impl;

import cn.draymonder.cloud.dao.FileDao;
import cn.draymonder.cloud.entity.Files;
import cn.draymonder.cloud.entity.User;
import cn.draymonder.cloud.service.FileService;
import cn.draymonder.cloud.utils.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * @auther draymonder
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;

    @Override
    public boolean createFile(CommonsMultipartFile file, User user, String md5) {
        int userId = user.getUserId();
        Files files = new Files();
        files.setOwnerId(userId);
        // 实际存放的文件信息
        File store = null;
        try {
            String realFolderStr = PathUtil.getBasePath() + PathUtil.getRelativePath(userId);
            File folder = new File(realFolderStr);
            // 如若目录不存在, 创建之
            if (!folder.exists()) {
                folder.mkdirs();
            }
            // String realPath = PathUtil.getRelativePath(userId) + file.getOriginalFilename() + (Math.random() * 100);
            String realPath  = realFolderStr + file.getOriginalFilename();
            store = new File(PathUtil.getRelativePath(userId), file.getOriginalFilename());
            if(file.isEmpty())
                files.setFileType(0);
            else
                files.setFileType(1);
            files.setFilePath(realPath);
            files.setFileSize((int) file.getSize());
            files.setFileName(file.getName());
            files.setMd5(md5);

            Date now = new Date(System.currentTimeMillis());
            files.setCreateTime(now);
            files.setLastEditTime(now);

            // 写文件
            file.transferTo(store);

            int effectedNum = fileDao.insertFile(files);
            if(effectedNum >= 1)
                return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteFile(int userId, int fileId) {
        // 我还需要删除文件目录下的文件
        String realFileStr = PathUtil.getBasePath() + fileDao.selectFilePath(userId, fileId);
        File nowfile = new File(realFileStr);
        // 先删除具体的文件
        boolean deleteFile = nowfile.delete();
        if(deleteFile == true) {
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


}
