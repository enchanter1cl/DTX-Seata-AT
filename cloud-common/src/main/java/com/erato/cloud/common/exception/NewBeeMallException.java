package com.erato.cloud.common.exception;

public class EratoException extends RuntimeException {

    public EratoException() {

    }

    public EratoException(String message) {
        super(message);
    }

    /**
     * 丢出一个异常
     * @param message
     */
    public static void fail(String message) {
        throw new EratoException(message);
    }
}
