package dynamic.level3;

import java.util.*;

/**
 * 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 */
public class A04wordBreak {
    public static void main(String[] args) {

        System.out.println(wordBreak("applenpenapple", Arrays.asList("apple", "len",  "pen", "app")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;

        for(int i = 0 ; i <= s.length(); i++){
            for(int j = 0; j != i; j++){
                if(wordDict.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
