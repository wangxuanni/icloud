package cn.draymonder.cloud.dao;

import cn.draymonder.cloud.entity.Files;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 文件关系表
 * 增加文件信息 解除文件信息(比较难) 查询某个用户的某个目录√ 更新文件的目录位置√
 *
 * @auther draymonder
 */
@Mapper
public interface FileRelationDao {

    /**
     * 获取User的文件的信息，parentId为0 代表首目录
     *
     * @return
     */
//    @Select("select f.file_id, f.file_name, owner_id, file_size, file_type,file_path, MD5, create_time,last_edit_time\n" +
    @Select("select f.*\n" +
            "from file_relation as fr , file as f\n" +
            "where file_relation_id > 0 and user_id = #{user_id} and parent_id = #{parent_id} and fr.file_id = f.file_id;")
    /*
    @Results( {
            @Result(property = "fileId", column = "file_id", javaType = Integer.class),
            @Result(property = "fileName", column = "file_name", javaType = String.class),
            @Result(property = "ownerId", column = "owner_id", javaType = Integer.class),
            @Result(property = "fileSize", column = "file_size", javaType = Integer.class),
            @Result(property = "fileType", column = "file_type", javaType = Integer.class),
            @Result(property = "filePath", column = "file_path",javaType = String.class),
            @Result(property = "MD5", column = "MD5",javaType = String.class),
            @Result(property = "createTime", column = "create_time",javaType = Date.class),
            @Result(property = "lastEditTime", column = "last_edit_time",javaType = Date.class)
    })*/
    public List<Files> selectFileByUser(@Param("user_id") int userId, @Param("parent_id") int parentId);

    /**
     * 改变文件的目录，单纯在fileRelation表中改就行
     * @param userId
     * @param fileId
     * @param oldParentId
     * @param parentId
     * @return
     */
    @Update("update file_relation\n" +
            "set parent_id = #{parent_id}\n" +
            "where user_id = #{user_id} and file_id = #{file_id} and parent_id = #{old_parent_id}; ")
    public int updateFileFolder(@Param("user_id") int userId, @Param("file_id") int fileId,
                                @Param("old_parent_id")int oldParentId,@Param("parent_id") int parentId);

    @Insert("insert into file_relation(file_id,user_id,\n" +
            "file_name,file_type,parent_id,create_time, last_edit_time)\n" +
            "values(#{files.fileId},#{files.ownerId},#{files.fileName},#{files.fileType},#{parent_id},#{files.createTime}," +
            "#{files.lastEditTime})")
    public int insertFileRelation(@Param("files")Files files, @Param("parent_id")int parentId);
}
