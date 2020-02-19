package cc.xpbootcamp.warmup.cashier.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtil {

    public static String getFormattedDate(){
        return new SimpleDateFormat("y年M月d日").format(new Date());
    }

    public static String getWeedDay(){
        return new SimpleDateFormat("EEEE").format(new Date());
    }

}
