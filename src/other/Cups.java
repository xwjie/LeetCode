package other;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * [字节跳动面试题 —— 水壶问题 - 知乎](https://zhuanlan.zhihu.com/p/79938638)
 * 给你一个装满水的 8 升满壶和两个分别是 5 升、3 升的空壶，
 * 请想个优雅的办法，使得其中一个水壶恰好装 4 升水，每一步的操作只能是倒空或倒满。
 */
public class Cups {
    public static void main(String[] args) {
        cups(4, new int[]{8, 5, 3});
    }

    static class Step {
        int[] nums;

        List<Step> childs;

        public Step(int... nums) {
            this.nums = nums;
        }
    }

    private static void cups(int target, int[] cups) {
        // 当前状态
        int[] nodes = new int[cups.length];

        // 第一个杯子满的。
        nodes[0] = cups[0];

        // 存放已经走过的步骤
        List<String> doneList = new LinkedList<>();

        // 根节点
        Step root = new Step(nodes);
        doneList.add(toStatus(nodes));

        System.out.println(tryNode(doneList, root, cups, target));

        // 找到成功的步骤
        List<String> successStatus = new LinkedList<>();
        successStatus.add(toStatus(root.nums));

        findSuccessPath(successStatus, root, target);
        System.out.println(successStatus);
    }

    /**
     * 回溯法找到成功的哪条路径
     *
     * @param status
     * @param root
     * @param target
     * @return
     */
    private static boolean findSuccessPath(List<String> status, Step root, int target) {
        for (Step step : root.childs) {

            status.add(toStatus(step.nums));

            if (success(target, step.nums)) {
                return true;
            }

            if (findSuccessPath(status, step, target)) {
                return true;
            }

            status.remove(status.size() - 1);
        }

        return false;
    }

    private static boolean tryNode(List<String> doneList, Step step, int[] cups, int target) {
        int[] nodes = step.nums;
        step.childs = new LinkedList<>();

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length; j++) {

                if (i == j) {
                    continue;
                }

                //
                if (nodes[i] > 0 && nodes[j] < cups[j]) {

                    int[] nums2 = Arrays.copyOf(nodes, cups.length);

                    // 全倒了还是有剩下
                    if (nodes[i] >= cups[j] - nodes[j]) {
                        nums2[i] = nodes[i] - cups[j] + nodes[j];
                        nums2[j] = cups[j];
                    } else {
                        nums2[j] = nodes[j] + nodes[i];
                        nums2[i] = 0;
                    }

                    String status = toStatus(nums2);

                    // 判断是否出现过了
                    if (doneList.contains(status)) {
                        continue;
                    }

                    // System.out.println("step:" + status);

                    doneList.add(status);

                    // 往下遍历
                    Step step1 = new Step(nums2);
                    step.childs.add(step1);

                    // 是否找到
                    if (success(target, nums2)) {
                        return true;
                    }

                    // 找子节点
                    if (tryNode(doneList, step1, cups, target)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean success(int target, int[] nums2) {
        for (int i1 = 0; i1 < nums2.length; i1++) {
            if (nums2[i1] == target) {
                return true;
            }
        }
        return false;
    }

    private static String toStatus(int[] nodes) {
        String str = "";
        for (int node : nodes) {
            str += node + "-";
        }
        return str;
    }


}
