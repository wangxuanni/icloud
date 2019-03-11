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
public class FileDaoTest {
    @Autowired
    private FileDao fileDao;

    @Test
    @Ignore
    public void testInsert() {
        long times = System.currentTimeMillis();
        Files files = new Files();
        files.setFileName("d.txt");
        files.setOwnerId(1);
        files.setFileSize(10000);
        files.setFileType(1);
        files.setFilePath(PathUtil.getRelativePath(1) + files.getFileName());
        files.setMd5(""+21803821);
        Date now = new Date(times);
        files.setCreateTime(now);
        files.setLastEditTime(now);
        int effectedNum = fileDao.insertFile(files);
        System.out.println(effectedNum);
    }

    @Test
    @Ignore
    public void testUpdate() {
        int id = 1;
        String nowName = "xx.txt";
        int num = fileDao.updateFileName(1,nowName);
        System.out.println(num);
    }

    @Test
    @Rollback
    @Ignore
    public void testDelete() {
        int id  = 3;
        int num = fileDao.deleteFile(id);
        System.out.println(num);
    }

    @Test
    @Ignore
    public void testSelect() {
        int file_id = 4;
        int user_id = 1;
        String num = fileDao.selectFilePath(file_id, user_id);
        System.out.println(num);
    }

    @Test
    @Ignore
    public void testSelectOwner() {
        List<Files> lists = fileDao.selectFileByOwner(1);
        for(Files file: lists) {
            System.out.println(file);
        }
        System.out.println(lists.size());
    }
}
