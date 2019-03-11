package cn.draymonder.cloud.entity;

/**
 * 用于存放临时的 需要删除的表单
 * @auther draymonder
 */
public class Tmplist {
    private Integer id;
    private Integer level;

    public Tmplist(Integer id, Integer level) {
        this.id = id;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Tmplist{" +
                "id=" + id +
                ", level=" + level +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public Integer getLevel() {
        return level;
    }
}
