package memory;

import java.util.ArrayList;
import java.util.List;

public class StringOOMMock {
    static String  base = "string";
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<String>();
        for (int i=0;i< Integer.MAX_VALUE;i++){
            String str = base + base;
            base = str;
            str.intern();
            Thread.sleep(3000, 0);
        }
    }
}