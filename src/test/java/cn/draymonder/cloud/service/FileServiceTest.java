package cn.draymonder.cloud.service;

import cn.draymonder.cloud.dao.FileDao;
import cn.draymonder.cloud.entity.Files;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @auther draymonder
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileServiceTest {
    @Autowired
    private FileDao fileDao;

    @Autowired
    private FileService fileService;

    @Test
    @Ignore
    public void TestFileName() {
        // System.out.println("yes");
        List<Files> lists = fileService.getFileByFilename("虚拟");
        for(Files file : lists) {
            System.out.println(file);
        }
    }
}
