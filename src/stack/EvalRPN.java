package stack;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 * 根据逆波兰表示法，求表达式的值。
 * <p>
 * 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * <p>
 * 输入: ["2", "1", "+", "3", "*"]
 * 输出: 9
 * 解释: ((2 + 1) * 3) = 9
 */
public class EvalRPN {
    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            if ("+-*/".contains(tokens[i])) {
                int result = calc(nums.pop(), tokens[i], nums.pop());
                nums.push(result);
            }else{
                nums.push(Integer.parseInt(tokens[i]));
            }
        }

        return nums.pop();
    }

    private static int calc(Integer n1, String token, Integer n2) {
        // System.out.println(n2 + " " + token + " " + n1);

        if (token.equals("+")) {
            return n1 + n2;
        } else if (token.equals("-")) {
            return n2 - n1;
        } else if (token.equals("*")) {
            return n1 * n2;
        } else {
            return n2 / n1;
        }
    }
}
