package com.liang.test9;

/**
 * 自定义受检异常（继承 Exception）
 * 特点：编译期强制处理 —— 调用方必须 try-catch 或在方法上 throws，否则编译不过
 * 和 RuntimeException 最大的区别就在这里
 */
public class UnderAgeException extends Exception {

    public UnderAgeException() {
    }

    public UnderAgeException(String message) {
        super(message);
    }

    public UnderAgeException(String message, Throwable cause) {
        super(message, cause);
    }
}
