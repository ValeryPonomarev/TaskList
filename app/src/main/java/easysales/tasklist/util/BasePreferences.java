package easysales.tasklist.util;

import android.content.Context;
import android.content.SharedPreferences;

import easysales.tasklist.ApplicationWrapper;

/**
 * Created by lordp on 31.10.2017.
 */

public class BasePreferences {

    public static final String UNDEFINED_STRING = "";
    public static final int UNDEFINED_INTEGER = -1;
    public static final long UNDEFINED_LONG = -1;

    private static SharedPreferences getPrefs() {
        return ApplicationWrapper.getInstance().getApplicationContext().getSharedPreferences(ApplicationWrapper.APP_KEY, Context.MODE_PRIVATE);
    }

    protected static void put(String key, String value) {
        getPrefs().edit().putString(key, value).apply();
    }

    protected static void put(String key, int value) {
        getPrefs().edit().putInt(key, value).apply();
    }

    protected static void put(String key, long value) {
        getPrefs().edit().putLong(key, value);
    }

    protected static void put(String key, double value) {
        getPrefs().edit().putLong(key, Double.doubleToLongBits(value));
    }

    protected static String getString(String key) {
        return getString(key, UNDEFINED_STRING);
    }

    protected static String getString(String key, String defaultValue) {
        return getPrefs().getString(key, defaultValue);
    }

    protected static int getInt(String key) {
        return getInt(key, UNDEFINED_INTEGER);
    }

    protected static int getInt(String key, int defaultValue) {
        return getPrefs().getInt(key, defaultValue);
    }

    protected static long getLong(String key) {
        return getPrefs().getLong(key, UNDEFINED_LONG);
    }

    protected static long getLong(String key, long defaultValue) {
        return getPrefs().getLong(key, defaultValue);
    }

    protected static double getDouble(String key) {
        return Double.longBitsToDouble(getLong(key));
    }

    protected static double getDouble(String key, double defaultValue) {
        long value = getLong(key);
        if(value == UNDEFINED_LONG) {
            return defaultValue;
        }

        return Double.longBitsToDouble(value);
    }
}