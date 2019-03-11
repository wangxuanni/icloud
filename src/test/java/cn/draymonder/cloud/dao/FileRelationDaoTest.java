package cn.draymonder.cloud.dao;

import cn.draymonder.cloud.entity.Files;
import cn.draymonder.cloud.utils.PathUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.List;

/**
 * @auther draymonder
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FileRelationDaoTest {
    @Autowired
    private FileRelationDao fileRelationDao;

    @Autowired
    private FileDao fileDao;

    @Test
    @Ignore
    public void testSelectByUserIdAndParentId() {
        int userId = 1;
        int parentId = 1;
//        System.out.println(fileRelationDao.selectFileByUser(userId, parentId));
        List<Files> lists = fileRelationDao.selectFileByUser(userId, parentId);
        for (Files file : lists) {
            System.out.println(file);
        }
        System.out.println(lists.size());
    }

    @Test
    @Ignore
    public void testUpdate() {
        int userId = 1;
        int oldParentId = 1;
        int file_id = 5;
        int parent_id = 0;
        int nums = fileRelationDao.updateFileFolder(userId, file_id, oldParentId, parent_id);
        System.out.println(nums);
    }

    @Test
    @Ignore
    @Rollback
    public void testInsert() {
        long times = System.currentTimeMillis();
        Files files = new Files();
        files.setFileId(6);
        files.setFileName("f.txt");
        files.setOwnerId(5);
        files.setFileSize(10000);
        files.setFileType(1);
        files.setFilePath(PathUtil.getRelativePath(1) + files.getFileName());
        files.setMd5("" + 21803821);
        Date now = new Date(times);
        files.setCreateTime(now);
        files.setLastEditTime(now);
        int userId = 5;
        int parentId = 0;
        int nums = fileRelationDao.insertFileRelation(files, parentId);
        System.out.println(nums);
    }
}
