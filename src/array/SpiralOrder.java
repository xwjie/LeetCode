package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * <p>
 * https://leetcode-cn.com/explore/learn/card/array-and-string/199/introduction-to-2d-array/775/
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = {{1},{2},{3}
               // {1, 2, 3},
               // {4, 5, 6},
                //{7, 8, 9},
                //{10, 11, 12}
        };

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        if(row==0){
            return new ArrayList<>();
        }

        int col = matrix[0].length;

        List<Integer> list = new ArrayList<>(row * col);

        int x = 0, y = 0;

        // 是加还是减（上半圈还是下半圈）
        boolean shun = true;

        // 第几圈
        int time = 0;

        while (x >= 0 && y >= 0) {
            list.add(matrix[y][x]);
            System.out.println(matrix[y][x]);

            if (shun) {
                if (x == col - time - 1) {
                    y += 1;

                    if (y > row - time - 1) {
                        break;
                    }

                    //
                    if (y == row - time - 1) {
                        shun = false;
                    }
                } else {
                    x++;
                }
            } else {
                if (x == time) {
                    y--;

                    if (y < time + 1) {
                        break;
                    }
                    if (y == time + 1) {
                        time++;
                        shun = true;
                    }
                } else {
                    x--;
                }
            }
        }

        return list;
    }
}

