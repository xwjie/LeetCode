package array.level1;

public class A06singleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 3, 3}));
    }

    public static int singleNumber(int[] nums){
        int value = 0;
        for (int i = 0; i < nums.length; i++) {
            value = value ^ nums[i];
        }
        return value;
    }
}
