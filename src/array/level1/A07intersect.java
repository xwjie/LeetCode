package array.level1;

import java.util.*;

public class A07intersect {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = intersect(nums1, nums2);

        for (int i = 0; i < nums3.length; i++) {
            System.out.print(nums3[i] + ",");
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> result = new LinkedList<>();

        int i = 0, j = 0;

        while (!(i >= nums1.length || j >= nums2.length)) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] nums = new int[result.size()];
        for (int k = 0; k < nums.length; k++) {
            nums[k] = result.get(k);
        }

        return nums;
    }
}
