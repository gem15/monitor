package com.sevtrans.monitor;

/**
 * https://www.baeldung.com/java-new-custom-exception
 */
public class MonitorCommonException extends Exception {
    public MonitorCommonException(String message) {
        super(message);
    }
}
