package cn.draymonder.cloud.enums;

/**
 * @auther draymonder
 */
public enum FileEnum {
    SUCCESS(0, "上传成功"),
    NOT_LOGIN(-1, "没有登陆"),
    FILE_UPLOAD_ERROR(-2, "文件上传失败,请联系管理员"),
    SYSTEM_ERROR(-3, "系统内部出错，请联系管理员"),
    FILE_RELATION_INSERT_ERROR(-4, "数据库插入失败，请联系管理员");

    private int state;
    private String stateInfo;


    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    private FileEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 返回FileEnum state
     *
     * @param state
     * @return
     */
    public static FileEnum stateOf(int state) {
        for (FileEnum stateEnum : values()) {
            if (stateEnum.getState() == state) {
                return stateEnum;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "FileEnum{" +
                "state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                '}';
    }}
