package backtrace.level2;

import java.util.LinkedList;
import java.util.List;

public class A03permute {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        List<Integer> list = new LinkedList<>();
        dfs(result, list, 0, nums);

        return result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> list, int pos, int[] nums) {
        if(pos == nums.length){
            result.add(new LinkedList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(list.contains(nums[i])){
                continue;
            }

            list.add(nums[i]);
            dfs(result, list, pos+1, nums);
            list.remove(list.size()-1);
        }
    }
}
