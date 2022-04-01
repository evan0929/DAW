package com.popper.daw.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class LogHelper {
    /**
     * 转换异常栈
     * @param throwable
     * @return
     */
    public static String getStackTraceAsString(Throwable throwable) {
        StringWriter writer = new StringWriter();
        throwable.printStackTrace(new PrintWriter(writer));
        return writer.toString();
    }

}
