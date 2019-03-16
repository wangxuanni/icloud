package cn.draymonder.cloud.service;

import cn.draymonder.cloud.entity.Files;
import cn.draymonder.cloud.entity.User;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

/**
 * @auther draymonder
 */
public interface FileService {
    /**
     * 存文件
     * @param file
     * @return
     */
    public boolean createFile(CommonsMultipartFile file, User user, String md5);

    /**
     * 删文件
     * @param fileId
     * @return
     */
    public boolean deleteFile(int userId,int fileId);

    /**
     * 相应的搜索管理  待拓展
     * @param filename
     * @return
     */
    public List<Files> getFileByFilename(String filename);
}
