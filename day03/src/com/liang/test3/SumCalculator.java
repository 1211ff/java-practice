package com.liang.test3;

/**
 * 计算 1 到 limit 之间所有偶数和奇数之和
 */
public class SumCalculator {

    private final int limit;   // 求和范围的上限

    public SumCalculator(int limit) {
        this.limit = limit;
    }

    /** 1-limit 的偶数之和 */
    public int sumEvenNumbers() {
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }

    /** 1-limit 的奇数之和 */
    public int sumOddNumbers() {
        int sum = 0;
        for (int i = 1; i <= limit; i++) {
            if (i % 2 != 0) {
                sum += i;
            }
        }
        return sum;
    }
}
