package com.liang.test3;

/**
 * 打印 99 乘法表（嵌套 for 循环）
 */
public class MultiplicationTable {

    public void print() {
        for (int i = 1; i <= 9; i++) {          // 外层：行
            for (int j = 1; j <= i; j++) {      // 内层：列（j 只到 i，保证左下三角）
                System.out.print(j + "*" + i + "=" + (j * i) + "\t");
            }
            System.out.println();               // 每行结束换行
        }
    }
}
