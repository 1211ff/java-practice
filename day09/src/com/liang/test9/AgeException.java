package com.liang.test9;

/**
 * 自定义运行时异常（继承 RuntimeException）
 * 特点：编译时不强制处理，运行到 throw 才抛出
 * 带业务错误码，方便调用方根据 code 做不同处理
 */
public class AgeException extends RuntimeException {

    private int code;   // 业务错误码：400 表示客户端参数错误

    public AgeException() {
    }

    public AgeException(String message) {
        super(message);
    }

    public AgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public AgeException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
