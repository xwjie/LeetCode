package dynamic.level2;

/**
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 */
public class A03coinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 1));
        System.out.println(coinChange(new int[]{1}, 2));
        System.out.println(coinChange(new int[]{83,186,408,419}, 6249));
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }

        int[] result = new int[amount+1];

        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount){
                result[coins[i]] = 1;
            }
        }

        for (int i = 1; i <= amount; i++) {
            if (result[i] == 0) continue;

            for (int j = 0; j < coins.length; j++) {
                // 记得加1
                int next = i + coins[j];

                // 防止逸出
                if (next > 0 && next <= amount) {
                    if(result[next] == 0) {
                        result[next] = result[i] + 1;
                    }
                }
            }
        }

        return result[amount] > 0 ? result[amount] : -1;
    }
}
