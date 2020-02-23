package cc.xpbootcamp.warmup.cashier.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

    DateUtil() {
    }

    public static String getFormattedDate(Date date) {
        return new SimpleDateFormat("y年M月d日").format(date);
    }

    public static String getWeekDay(Date date) {
        return new SimpleDateFormat("EEEE").format(date);
    }

}
