package cn.emptyspirit.global;

import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

/**
 * 文件相关的操作
 */
public class FileUtil {

    /**
     * 获取文件后缀
     * @param file
     * @return
     */
    public static String getFileSuffix(MultipartFile file) {
        return getFileSuffix(file.getOriginalFilename());
    }
    public static String getFileSuffix(String file) {
        return file.substring(file.lastIndexOf(".") + 1);
    }


    /**
     * 随机生成文件名称
     * @param file
     * @return
     */
    public static String randomFileName(MultipartFile file) {
        String uuid = UUID.randomUUID().toString();
        String fileSuffix = getFileSuffix(file);
        return uuid + "." + fileSuffix;
    }


    public static void main(String[] args) {
        String fileSuffix = getFileSuffix("aaa.gif");
        System.out.println(fileSuffix);
    }
}
