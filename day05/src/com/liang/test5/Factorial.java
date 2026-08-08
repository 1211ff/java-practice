package com.liang.test5;

/**
 * 阶乘计算（递归实现）
 *
 * 知识点：
 *   1. 递归 = 自己调用自己，必须有两个要素：
 *      - 终止条件：n <= 1 时返回 1（0! = 1! = 1）
 *      - 递归公式：n! = n * (n-1)!
 *   2. long 类型最大支持 20!，21! 会溢出，需要更大范围用 BigInteger
 */
public class Factorial {

    /**
     * 计算 n 的阶乘
     *
     * @param n 非负整数
     * @return n! 的结果
     * @throws IllegalArgumentException n 为负数时抛出
     */
    public long fact(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n 不能为负数");
        }
        // 终止条件：0! = 1，1! = 1，一个判断同时覆盖
        if (n <= 1) {
            return 1;
        }
        // 递归公式：n! = n * (n-1)!
        return n * fact(n - 1);
    }
}
