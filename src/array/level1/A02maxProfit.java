package array.level1;

public class A02maxProfit {
    public static void main(String[] args) {
        int[] nums = {7,1,5,3,6};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices) {
        // 买卖的标志，deal表示上次买的index
        int deal = -1;
        int result = 0;

        for (int i = 0; i < prices.length; i++) {
            // 最后一天
            if(i == prices.length - 1){
                if (deal > -1) {
                    result += prices[i] - prices[deal];
                    deal = -1;
                }
            }

            // 选择买的时机
            if (deal == -1) {
                // 如果后面比较大，买
                if (i < prices.length - 1 && prices[i + 1] > prices[i]) {
                    deal = i;
                }
            }
            // 选择卖的时机
            else {
                // 后面比较小，卖出
                if (prices[i + 1] < prices[i]) {
                    result += prices[i] - prices[deal];
                    deal = -1;
                }
            }
        }

        return result;
    }
}
