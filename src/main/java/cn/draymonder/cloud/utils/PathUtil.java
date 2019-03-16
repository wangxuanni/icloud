package cn.draymonder.cloud.utils;

/***
 * 路径处理类
 *
 * @author draymonder
 *
 */
public class PathUtil {
    private static String seperator = System.getProperty("file.separator");

    /***
     * 获取根目录
     * @return
     */
    public static String getBasePath() {
        String os = System.getProperty("os.name");
        String basePath = "";
        if (os.toLowerCase().startsWith("win")) {
            basePath = "D:/image/";
        } else {
            basePath = "/root/image/";
        }
        basePath = basePath.replace("/", seperator);
        return basePath;
    }

    /***
     * 获取存取相对路径
     * @param userId
     * @return
     */
    public static String getRelativePath(int userId) {
        String imagePath = "/user" + userId + "/";
        return imagePath.replace("/", seperator);
    }
}
