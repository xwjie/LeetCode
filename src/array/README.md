# Level 1

## 01 删除排好顺序的数组的重复数

返回结果记得加1

## 02 买卖股票

和最牛逼的相差十万八千里

```java
    public int maxProfit(int[] prices) {
        int max = 0;
        int size = prices.length;
        for (int i = 0; i < size - 1; ++i)
            if (prices[i] < prices[i + 1])
                max += prices[i + 1] - prices[i];
        return max;
    }
```

## 03 旋转数组

一下子没有做出来！！