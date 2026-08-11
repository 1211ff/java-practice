package com.liang.test8;

/**
 * Day 8：异常体系 + try-catch-finally
 * 演示数组越界异常如何被捕获、异常信息怎么打印、finally 的执行时机
 */
public class TestDemo8 {
    public static void main(String[] args) {
        System.out.println("===== 1. 基本 try-catch-finally 执行顺序 =====");
        demoArrayIndexOutOfBounds();
        System.out.println();

        System.out.println("===== 2. 异常信息获取 + 捕获后程序继续执行 =====");
        demoExceptionInfo();
        System.out.println();

        System.out.println("===== 3. finally 在 return 之前执行（经典面试题） =====");
        System.out.println("方法返回结果：" + demoReturnWithFinally());
    }

    /**
     * 故意让下标越界，演示 try -> catch -> finally 的执行顺序
     */
    private static void demoArrayIndexOutOfBounds() {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            for (int i = 0; i <= arr.length; i++) {
                System.out.println(arr[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("catch：捕获到异常 -> " + e);
        } finally {
            System.out.println("finally：无论是否异常，我都会执行（在 try/catch 之后）");
        }
    }

    /**
     * 演示怎么从异常对象里拿信息，以及异常被"接住"后程序不会崩
     */
    private static void demoExceptionInfo() {
        try {
            int a = 10;
            int b = 0;
            int result = a / b;   // 运行期抛 ArithmeticException
            System.out.println("结果：" + result);
        } catch (ArithmeticException e) {
            System.out.println("e.getMessage() = " + e.getMessage());   // / by zero
            System.out.println("e.toString()   = " + e);                // 异常类型 + 信息
            e.printStackTrace();                                       // 完整错误栈，真实开发最常用
        }
        System.out.println("异常被接住了，这行还能继续执行 ✅");
    }

    /**
     * 面试经典题：try 里有 return，finally 还会执行吗？—— 会！而且先于 return
     */
    private static int demoReturnWithFinally() {
        try {
            return 100;
        } finally {
            System.out.println("finally 先执行，然后才返回 100");
        }
    }
}
