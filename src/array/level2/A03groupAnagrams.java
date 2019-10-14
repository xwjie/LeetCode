package array.level2;

import java.util.*;

public class A03groupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams( new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            byte[] key = strs[i].getBytes();
            Arrays.sort(key);

            String newKey = new String(key);
            List<String> list = map.get(newKey);
            if ( list == null) {
                list = new LinkedList<>();
                map.put(newKey, list);
            }

            list.add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
