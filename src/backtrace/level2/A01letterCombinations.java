package backtrace.level2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class A01letterCombinations {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();

        // 居然犯了一个低级错误，用 == ""
        if (digits == null || digits.equals("")) {
            return result;
        }

        Map<Character, String> map = new HashMap<>();

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        String str = "";

        dfs(result, str, 0, digits, map);

        return result;
    }

    private static void dfs(List<String> result, String str, int pos, String digits, Map<Character, String> map) {
        if (pos == digits.length()) {
            result.add(str);

            // 记得return
            return;
        }

        String letters = map.get(digits.charAt(pos));

        for (int j = 0; j < letters.length(); j++) {
            str += letters.charAt(j);
            dfs(result, str, pos + 1, digits, map);
            str = str.substring(0, str.length() - 1);
        }
    }
}
