package tree.level3;

import java.util.*;

/**
 * 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * 解法：
 * https://leetcode-cn.com/problems/word-ladder/solution/dan-ci-jie-long-by-leetcode/
 */
public class A01ladderLength {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit", "cog", words));

        List<String> words2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(ladderLength("hit", "cog", words2));

        List<String> words3 = Arrays.asList("a", "b", "c");
        System.out.println(ladderLength("a", "c", words3));

        // 应该是4
        List<String> words4 = Arrays.asList("ion", "rev", "che", "ind", "lie", "wis", "oct", "ham", "jag", "ray", "nun", "ref", "wig", "jul", "ken", "mit", "eel", "paw", "per", "ola", "pat", "old", "maj", "ell", "irk", "ivy", "beg", "fan", "rap", "sun", "yak", "sat", "fit", "tom", "fin", "bug", "can", "hes", "col", "pep", "tug", "ump", "arc", "fee", "lee", "ohs", "eli", "nay", "raw", "lot", "mat", "egg", "cat", "pol", "fat", "joe", "pis", "dot", "jaw", "hat", "roe", "ada", "mac");
        System.out.println(ladderLength("cat", "fin", words4));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // Since all words are of same length.
        int L = beginWord.length();

        // Dictionary to hold combination of words that can be formed,
        // from any given word. By changing one letter at a time.
        HashMap<String, ArrayList<String>> allComboDict = new HashMap<String, ArrayList<String>>();

        wordList.forEach(
                word -> {
                    for (int i = 0; i < L; i++) {
                        // Key is the generic word
                        // Value is a list of words which have the same intermediate generic word.
                        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                        // HASHMAP 有这个方法
                        ArrayList<String> transformations =
                                allComboDict.getOrDefault(newWord, new ArrayList<String>());

                        transformations.add(word);
                        allComboDict.put(newWord, transformations);
                    }
                });

        // Queue for BFS
        Queue<javafx.util.Pair<String, Integer>> Q = new LinkedList<javafx.util.Pair<String, Integer>>();
        Q.add(new javafx.util.Pair(beginWord, 1));

        // Visited to make sure we don't repeat processing same word.
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);

        while (!Q.isEmpty()) {
            javafx.util.Pair<String, Integer> node = Q.remove();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < L; i++) {
                // Intermediate words for current word
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

                // Next states are all the words which share the same intermediate state.
                for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<String>())) {

                    // If at any point if we find what we are looking for
                    // i.e. the end word - we can return with the answer.
                    if (adjacentWord.equals(endWord)) {
                        return level + 1;
                    }

                    // Otherwise, add it to the BFS Queue. Also mark it visited
                    if (!visited.contains(adjacentWord)) {
                        visited.add(adjacentWord);

                        Q.add(new javafx.util.Pair(adjacentWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
