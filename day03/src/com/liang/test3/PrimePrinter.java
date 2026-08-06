package com.liang.test3;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印 2-limit 之间所有的质数
 *
 * 质数：只能被 1 和自身整除的数，1 不是质数
 */
public class PrimePrinter {

    private final int limit;

    public PrimePrinter(int limit) {
        this.limit = limit;
    }

    public void printPrimes() {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        for (Integer prime : primes) {
            System.out.print(prime + "\t");
        }
        System.out.println();
    }

    /**
     * 判断 n 是否为质数
     * 优化点：你原来用"统计约数个数"也能做对，
     * 但这里只需检查到 sqrt(n)，并且一发现能整除就提前返回 false，性能好得多
     */
    private boolean isPrime(int n) {
        for (int j = 2; j * j <= n; j++) {
            if (n % j == 0) {
                return false;
            }
        }
        return true;
    }
}
