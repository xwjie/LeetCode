package array.level1;

import java.util.Collections;

public class A01DelelteSame {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+",");
        }
    }

    public static int removeDuplicates(int[] nums) {

        if(nums.length <=1){
            return nums.length;
        }

        int start = 0,end = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[start] != nums[end]){
                start++;
                nums[start] = nums[end];
            }

            end++;
        }

        // 记得加1
        return start+1;
    }
}
