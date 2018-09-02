package memory;

/**
 * 而jdk1.7中的intern()实现不会再复制实例，只是在常量池中记录首次出现的实例引用，
 * 因此intern()返回的引用和由StringBuilder创建的那个字符串实例是同一个。
 *
 * 对str3比较返回false是因为“java”这个字符串在执行StringBuilder.toString()之前已经出现过，
 * 字符串常量池中已经有它的引用了，不符合首次出现的原则，
 * 而“ni hao”这个字符串则是首次出现的，因此返回true。
 *
 *
 * https://www.cnblogs.com/paddix/p/5326863.html
 */
public class StringTest {
    public static void main(String[] args) {
        String str1 = new StringBuilder("ni ").append("hao").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ni ").append("hao").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new StringBuilder("ja").append("va").toString();
        System.out.println(str3.intern() == str3);

        System.out.println("-------------------顺序不一样-----------");
        test1();
        test2();
    }

    public static void test1(){
        String str1 = "str01";

        String str2 = new String("str")+new String("01");
        str2.intern();

        System.out.println(str2 == str1);//#8
    }

    public static  void test2(){
        String str2 = new String("str")+new String("02");
        str2.intern();

        String str1 = "str02";
        System.out.println(str2 == str1);//#8
    }
}
