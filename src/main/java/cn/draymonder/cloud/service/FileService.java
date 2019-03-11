package cn.draymonder.cloud.service;

import cn.draymonder.cloud.entity.User;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

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
}
