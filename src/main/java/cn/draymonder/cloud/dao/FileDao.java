package cn.draymonder.cloud.dao;

import cn.draymonder.cloud.entity.Files;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 文件上传和下载 重命名  另外还有删除吧
 * @auther draymonder
 */
@Mapper
public interface FileDao {
    /**
     * 插入file到数据库中
     * @param file
     * @return
     */
    @Insert("insert into file(owner_id, file_name, file_size, file_type, file_path, \n" +
            "\tMD5, create_time, last_edit_time)\n" +
            "values(#{ownerId}, #{fileName}, #{fileSize}, #{fileType}, #{filePath}, #{MD5}, #{createTime}, #{lastEditTime})")
    public int insertFile(Files file);

    /**
     * 文件改名
     * @param file_id
     * @param nowName
     * @return
     */
    @Update("update `file` set file_name = #{nowName} where file_id = #{id}")
    public int updateFileName(@Param("id") int file_id, @Param("nowName") String nowName);

    /**
     * 在数据中删除文件记录
     * @param file_id
     * @return
     */
    @Delete("delete from file where file_id = #{id}")
    public int deleteFile(@Param("id") int file_id);

    /**
     * 根据用户id和相应的file_id查询文件的路径，供下载
     * @param file_id
     * @param user_id
     * @return
     */
    @Select("select file_path from file where file_id = #{file_id} and owner_id = #{user_id}")
    public String selectFilePath( @Param("user_id")int user_id, @Param("file_id")int file_id);

    /**
     * 查询user_id下的所有文件
     * @param user_id
     * @return
     */
    @Select("select * from file where owner_id = #{user_id}")
    public List<Files> selectFileByOwner(@Param("user_id")int user_id);
}
