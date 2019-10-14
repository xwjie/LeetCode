package backtrace.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A04subsets {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        dfs(result, list, 0, nums);
        return  result;
    }

    private static void dfs(List<List<Integer>> result, List<Integer> list, int pos, int[] nums) {
        result.add(new LinkedList<>(list));

        if(pos == nums.length){
            return;
        }

        for (int j = pos; j < nums.length; j++) {
            //if(list.contains(nums[j]) ) continue;
            list.add(nums[j]);

            // 这里不能存入pos+1, 不能重复
            dfs(result,list,j+1,nums);

            list.remove(list.size()-1);
        }
    }
}
