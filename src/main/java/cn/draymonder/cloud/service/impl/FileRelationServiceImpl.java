package cn.draymonder.cloud.service.impl;

import cn.draymonder.cloud.dao.FileRelationDao;
import cn.draymonder.cloud.entity.Files;
import cn.draymonder.cloud.service.FileRelationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 文件关系Service实现类
 * @auther draymonder
 */
public class FileRelationServiceImpl implements FileRelationService {

    @Autowired
    private FileRelationDao fileRelationDao;

    @Override
    public boolean createFileRelation(Files files, int parentId) {
        if(files == null)
            return false;
        return fileRelationDao.insertFileRelation(files, parentId) > 0;
    }

    @Override
    public List<Files> getFileListsByUser(int userId, int parentId) {
        return fileRelationDao.selectFileByUser(userId, parentId);
    }

    @Override
    public boolean modifyFileFolder(int userId, int fileId, int oldParentId, int parentId) {
        int nums = fileRelationDao.updateFileFolder(userId, fileId, oldParentId, parentId);
        return nums > 0;
    }

    @Override
    public List<Integer> deleteFilesById(int parent_id) {
        // 此时删除 已经放到tmpList表中了
        fileRelationDao.getTableOfDelete(parent_id);
        List<Integer> lists = fileRelationDao.selectNeedDeleteId();
        // 暂时先不删  以后可能还有用？
        return lists;
    }
}
