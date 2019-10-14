package array.level2;

public class A04lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        String str = "";

        byte[] bytes = s.getBytes();

        for (int i = 0; i < bytes.length; i++) {
            char c = (char) bytes[i];

            int index = str.indexOf(c);

            if(index >= 0){
                // 记得加1
                str = str.substring(index+1);
                // System.out.println(index);
                // System.out.println("s="+str);
            }

            str += c;
            // System.out.println(str);
            max = Math.max(max, str.length());
        }

        return max;
    }
}
