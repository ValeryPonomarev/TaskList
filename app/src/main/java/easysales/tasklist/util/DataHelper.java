package easysales.tasklist.util;

/**
 * Created by lordp on 28.07.2017.
 */

public class DataHelper {
    public static int parseInteger(String integerValue, int defaultValue){
        try {
            int result = Integer.parseInt(integerValue);
            return result;
        }catch (NumberFormatException e){
            return defaultValue;
        }
    }
}
