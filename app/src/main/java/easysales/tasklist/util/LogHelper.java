package easysales.tasklist.util;

import android.util.Log;

/**
 * Created by lordp on 31.10.2017.
 */

public final class LogHelper {

    public static void d(String tag, String message, String... userTags) {
        Log.d(tag, getFullMessage(message, userTags));
    }

    public static void v(String tag, String message, String... userTags) {
        Log.v(tag, getFullMessage(message, userTags));
    }

    public static void i(String tag, String message, String... userTags) {
        Log.i(tag, getFullMessage(message, userTags));
    }

    public static void w(String tag, String message, String... userTags) {
        Log.w(tag, getFullMessage(message, userTags));
    }

    public static void e(String tag, String message, Throwable t, String... userTags) {
        Log.e(tag, getFullMessage(message, userTags), t);
    }

    private static String getFullMessage(String message, String... userTags) {
        if(message == null) {
            message = "";
        }
        StringBuilder msgBuilder = new StringBuilder(message.length());
        msgBuilder.append(message).append(" ");

        for (String userTag: userTags) {
            msgBuilder.append(String.format("[%s]", userTag));
        }
        return msgBuilder.toString();
    }

    private static void wirteLongMessage(String message) {

    }
}
