package array.level2;

public class A07increasingTriplet {
    public static void main(String[] args) {

    }

    public boolean increasingTriplet(int[] nums) {
        // 使用两个变量 first 和 second 维护一个二元组,表示当前数字前的最小的两个有序变量
        // 如果有比first小的数字就更新 first, 如果数字介于first 和 second 之间
        // 就更新second, second一旦更新就表示一定有一个有序二元组
        // 因为已经有了一个有序的二元组
        // 大于second 的数字,有就返回true,否则继续
        int first = Integer.MAX_VALUE, second= Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i]<first)
                first = nums[i];
            else if(nums[i]>first && nums[i]<second){
                second = nums[i];
            }
            if(nums[i]>second)
                return true;
        }
        return false;
    }
}
