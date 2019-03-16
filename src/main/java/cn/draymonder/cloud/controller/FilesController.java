package cn.draymonder.cloud.controller;

import cn.draymonder.cloud.entity.Files;
import cn.draymonder.cloud.entity.User;
import cn.draymonder.cloud.enums.FileEnum;
import cn.draymonder.cloud.service.FileRelationService;
import cn.draymonder.cloud.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件 上传 下载  获取信息
 *
 * @auther draymonder
 */
@RequestMapping("/file")
@RestController
public class FilesController {
    Logger log = LoggerFactory.getLogger(FilesController.class);

    @Autowired
    private FileService fileService;
    @Autowired
    private FileRelationService fileRelationService;

    @RequestMapping("/upload")
    public Map<String, Object> upload(HttpServletRequest req) {
        Map<String, Object> modelMap = new HashMap<>();
        User user = (User) req.getSession().getAttribute("user");

        // 判断user是否存在
        if (user == null || user.getUserId() <= 0) {
            modelMap.put("success", false);
            modelMap.put("state", FileEnum.NOT_LOGIN.getState());
            modelMap.put("stateInfo", FileEnum.NOT_LOGIN.getStateInfo());
            log.info(FileEnum.NOT_LOGIN.toString());
            return modelMap;
        }
        // 获取标签 <input name="file"/> 上传的所有文件
        List<MultipartFile> files = ((MultipartHttpServletRequest) req).getFiles("file");
        MultipartFile file = null;
        BufferedOutputStream stream = null;
        for (int i = 0; i < files.size(); ++i) {
            file = files.get(i);
            // now get the file
            // md5 have not calculate...
            int fileId = fileService.createFile(file, user, "xxxxxx");
            if (fileId > 0) {
                log.info(file.getOriginalFilename());
                Files filesInTable = fileService.getFileByFileId(fileId);
                boolean fileRelation = fileRelationService.createFileRelation(filesInTable, 0);
                if (fileRelation == true) {
                    modelMap.put("success", true);
                    modelMap.put("state", FileEnum.SUCCESS.getState());
                    modelMap.put("stateInfo", FileEnum.SUCCESS.getStateInfo());
                    log.info(FileEnum.SUCCESS.toString());
                    return modelMap;
                } else {
                    modelMap.put("success", false);
                    modelMap.put("state", FileEnum.FILE_RELATION_INSERT_ERROR.getStateInfo());
                    modelMap.put("stateInfo", FileEnum.FILE_RELATION_INSERT_ERROR.getStateInfo());
                    log.info(FileEnum.FILE_RELATION_INSERT_ERROR.toString());
                    return modelMap;
                }
            } else {
                modelMap.put("success", false);
                modelMap.put("state", FileEnum.FILE_UPLOAD_ERROR.getState());
                modelMap.put("stateInfo", FileEnum.FILE_UPLOAD_ERROR.getState());
                return modelMap;
            }
        }
        return modelMap;
    }
}
