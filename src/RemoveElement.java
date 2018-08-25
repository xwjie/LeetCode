/**
 * 给定一个数组和一个值，原地删除该值的所有实例并返回新的长度
 *
 * 在上面的例子中，我们使用两个指针，一个快指针 i 和一个慢指针 k 。i 每次移动一步，而 k 只在添加新的被需要的值时才移动一步。
 *
 *
 *
 * 总结
 * 这是你需要使用双指针技巧的一种非常常见的情况：
 *
 * 同时有一个慢指针和一个快指针。
 *
 * 解决这类问题的关键是
 *
 * 确定两个指针的移动策略。
 */
public class RemoveElement {
    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{4,2,3,4,4,5,4}, 4));
    }

    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
