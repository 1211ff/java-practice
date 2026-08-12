package com.liang.test9;

/**
 * 自定义运行时异常（继承 RuntimeException）
 * 不带错误码的简单版 —— 和带 code 的 AgeException 对比，
 * 两种设计都合法，根据需求选择
 */
public class ScoreException extends RuntimeException {

    public ScoreException() {
    }

    public ScoreException(String message) {
        super(message);
    }

    public ScoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
