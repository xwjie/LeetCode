/**
 * 编写一个函数，其作用是将输入的字符串反转过来。
 */
public class ReverseString {


    public static void main(String[] args) {
        ReverseString rs = new ReverseString();

        System.out.println(rs.reverseString("1"));
        System.out.println(rs.reverseString("1234"));
        System.out.println(rs.reverseString("12345"));
    }

    public String reverseString(String s) {
        if(s.length() <=1){
            return s;
        }

        char[] chars = s.toCharArray();

        int start = 0;
        int end = s.length()-1;

        while(start < end){
            char ch =chars[end];

            chars[end] = chars[start] ;
            chars[start] = ch;

            start++;
            end--;
        }

        return new String(chars);
    }
}
