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
 */
public class A01ladderLength {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(ladderLength("hit", "cog", words));

        List<String> words2 = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(ladderLength("hit", "cog", words2));

        List<String> words3 = Arrays.asList("a","b","c");
        System.out.println(ladderLength("a", "c", words3));
    }

    static class TreeNode {
        String val;
        int level;
        List<TreeNode> child;

        public TreeNode(String val, int level) {
            this.val = val;
            this.level = level;
            this.child = new ArrayList<>();
        }
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        // 外面传入的不一定能删除
        wordList = new ArrayList<>(wordList);

        if(!wordList.contains(beginWord)) {
            wordList.add(beginWord);
        }

        // 构建树
        TreeNode root = buildTree(endWord, 0, wordList);

        System.out.println("构建成功");

        // 层遍历
        Queue<TreeNode> nodes = new LinkedList<>();
        // 入队列
        nodes.offer(root);

        while (!nodes.isEmpty()) {
            // 出队列
            TreeNode n = nodes.poll();
            System.out.println(n.val + ":" + n.level);

            // 这里是begin
            if (beginWord.equals(n.val)) {
                return n.level + 1;
            }

            nodes.addAll(n.child);
        }

        return 0;
    }

    private static TreeNode buildTree(String endWord, int level, List<String> wordList) {
        final int treeNodeSize = endWord.length();

        final TreeNode root = new TreeNode(endWord, level);

        // 外面传入的不一定能删除
        wordList = new ArrayList<>(wordList);
        wordList.remove(endWord);

        for (int i = 0; i < wordList.size(); i++) {
            String key = wordList.get(i);

            // 如果只有1个不同
            if (only1char(endWord, key)) {
                wordList.remove(key);
                // System.out.println("构建，key:" + key + ",level:" + (level + 1));

                // 记得++
                root.child.add(buildTree(key, level + 1, wordList));
            }
        }

        return root;
    }

    /**
     * 只有1个字符不同
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean only1char(String s1, String s2) {
        int count = 0, i = 0;
        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (count > 1) {
                    return false;
                }
            }
            i++;
        }

        return count == 1;
    }
}
