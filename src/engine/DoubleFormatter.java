package engine;

import java.text.DecimalFormat;

public class DoubleFormatter {

    public static String getFormattedString (double value,String pattern) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(value);
    }

}
