package utils;

import org.apache.commons.lang3.time.FastDateFormat;
import org.joda.time.DateTime;
import org.apache.commons.lang3.StringUtils;

import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM-dd HH", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM/dd HH", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM.dd HH", "yyyy.MM",
            "yyyy年MM月dd日", "yyyy年MM月dd日 HH时mm分ss秒", "yyyy年MM月dd日 HH时mm分", "yyyy年MM月dd日 HH时", "yyyy年MM月",
            "yyyy"};


    /**
     * Date 可以很方便的用来表示时间，并进行时间格式化等操作
     * 1、Date.getTime()返回的默认值是一个13位毫秒数
     * 2、Date.getTime() 和System.currentTimeMillis() 都可以获得当前时间戳（毫秒值），用哪个？
     *   如果不需要格式化、获取具体年月日等信息，仅是获取一个时间戳，优先 System.currentTimeMillis()，性能高于 date.getTime()
     *
     * 3、java.util.Calendar --无法进行时间格式化， 可以获取并设置日历字段值、解析日历字段值
     *
     * @param args
     * @throws ParseException
     */

    public static void main(String[] args) throws Exception {
        Date now = new Date(); //调用了System.currentTimeMillis()
        System.out.println("获得当前距离1970.1.1以来的long类型的毫秒值：" + now.getTime());
        System.out.println("获取当前系统时间的毫秒值：" + System.currentTimeMillis());


        //getTimestamp_1970
        System.out.println(getTimestamp_1970());

        //格式化输出当前时间
        System.out.println(formatDate(new java.util.Date()));

    }

    /**
     * Date.getTime() 与程序真实运行的容器（服务器）所在的时区相关。如果程序运行在东八区，它返回北京时间1970年01月01日08时00分00秒起至现在东八区时间的总毫秒数。
     * 如果运行在UTC时区则返回1970年01月01日00时00分00秒起至当前UTC时间的总毫秒数。
     *
     * @return 0
     * @throws Exception
     */
    public static long getTimestamp_1970() throws Exception {
        java.text.SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date date = formater.parse("1970-01-01 08:00:00");
        return date.getTime(); //东八区，返回0
    }

    public static String formatDate(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatDateStr = format.format(date);
        return formatDateStr;
    }


}