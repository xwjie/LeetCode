package array;

import java.util.Arrays;

import static java.lang.Math.max;

/**
 * 给定一个含有 M x N 个元素的矩阵（M行，N列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/774/
 */
public class FindDiagonalOrder {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        System.out.println(Arrays.toString(findDiagonalOrder(matrix)));
    }

    public static int[] findDiagonalOrder(int[][] matrix) {

        final  int m = matrix.length;
        final  int n = matrix[0].length;

        int[] num = new int[m * n];


        return num;
    }
}
