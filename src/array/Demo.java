package array;

import java.io.File;
import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {
        File f = new File("D:\\BaiduNetdiskDownload");
        doFile(f, "vvvv");
    }

    // 把文件名和目录里面包含指定关键字的改名
    private static void doFile(File f, String s) {

        Arrays.stream(f.listFiles()).forEach(file ->{
            if(file.getName().contains(s)){
                File dest = new File(file.getParentFile(), file.getName().replaceAll(s, ""));

                file.renameTo(dest);
                System.out.println("rename to:" + dest.getAbsolutePath());
            }

            if(file.isDirectory()){
                doFile(file, s);
            }
        });
    }
}
