package dp;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 */
public class BuyStock {

    public static void main(String[] args) {

        int[] prices = {7,1,5,3,6,4};
        //int[] prices = {7,5,3,2,1};

        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }

        // 记录下最小的值【关键点】 和 最大的收益
        // 最小值初始化为第一个元素，直接从第二个元素遍历
        int minValue = prices[0];

        // 最大值初始化为0，找不到发挥0
        int maxPrice = 0;

        for (int i = 1; i < prices.length; i++) {

            int temp =  prices[i] - minValue;

            // 更新最大收益
            if(temp > 0 && temp > maxPrice){
                maxPrice = temp;
            }

            // 更新最小值
            if(prices[i] < minValue){
                minValue = prices[i];
            }
        }

        return maxPrice;
    }
}
