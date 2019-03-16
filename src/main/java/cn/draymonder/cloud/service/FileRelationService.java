package cn.draymonder.cloud.service;

import cn.draymonder.cloud.entity.Files;

import java.util.List;

/**
 * 文件关系Service
 * @auther draymonder
 */
public interface FileRelationService {

    /**
     * 获取User的文件的信息，parentId为0 代表首目录
     * @param userId
     * @param parentId
     * @return
     */
    public List<Files> getFileListsByUser(int userId, int parentId);

    /**
     * 改变文件的目录，单纯在fileRelation表中改就行
     * @param userId
     * @param fileId
     * @param oldParentId
     * @param parentId
     * @return
     */
    public boolean modifyFileFolder(int userId, int fileId, int oldParentId, int parentId);

    /**
     * 将files具体文件，添加到FileRelation
     * @param files
     * @param parentId
     * @return
     */
    public boolean createFileRelation(Files files, int parentId);

    /**
     * 将parent_id下的目录文件全部删除
     * @param parent_id
     * @return
     */
    public List<Integer> deleteFilesById(int parent_id);
}
