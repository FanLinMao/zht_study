package cn.edu.cuit.study.utils;


import cn.edu.cuit.study.constant.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DateUtils {

    /**
     * 日期字符串（yyyy-MM-dd 格式）转化为日期
     *
     * @param dateTime yyyy-MM-dd格式时间串
     * @return 时间对象
     * @throws ParseException
     */
    public static Date converToDate(String dateTime) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(DateFormat.DATE_FORMAT);
        return df.parse(dateTime);
    }

    /**
     * 日期字符串转化为日期
     *
     * @param dateTime 时间串
     * @param format   格式
     * @return 时间对象
     * @throws ParseException
     */
    public static Date converToDate(String dateTime, String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);
        return df.parse(dateTime);
    }

    /**
     * 将日期格式化为字符串（yyyy-MM-dd格式）
     *
     * @param date 日期
     * @return 格式化结果
     */
    public static String formatDate(Date date) {
        return formatDate(date, DateFormat.DATE_FORMAT);
    }

    /**
     * 将日期格式化为字符串，自定义格式
     *
     * @param date       日期
     * @param dateFormat 格式
     * @return 格式化后的日期
     */
    public static String formatDate(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 将日期格式化为字符串，自定义格式
     *
     * @param date       日期
     * @param dateFormat 格式
     * @return 格式化后的日期
     */
    public static String formatDate(Long date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return sdf.format(date);
    }

    /**
     * 将当前日期格式化为字符串（yyyy-MM-dd格式）
     *
     * @return 格式化结果
     */
    public static String formatCurrentDate() {
        return formatCurrentDate(DateFormat.DATE_FORMAT);
    }

    /**
     * 使用自定义格式格式化当前日期
     *
     * @param dateFormat 输出显示的时间格式
     * @return 格式化结果
     */
    public static String formatCurrentDate(String dateFormat) {
        return formatDate(new Date(), dateFormat);
    }

    /**
     * 截取某一时间戳 为yyyy-mm-dd
     *
     * @param dateTime 时间
     * @return
     * @throws ParseException
     */
    public static Date cutTimestampToDate(String dateTime) throws ParseException {
        Date date = converToDate(dateTime, DateFormat.DATE24_FORMAT);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        return calendar.getTime();

    }

    /**
     * 获取当前日期前一天
     *
     * @return 前一天的日期
     */
    public static String lastDay() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        date = calendar.getTime();
        return formatDate(date);
    }

    /**
     * 获取当前日期前n天的日期
     *
     * @param n 前n天
     * @return 前n天的日期
     */
    public static String prevDay(int n) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -n);
        date = calendar.getTime();
        return formatDate(date);
    }

    /**
     * 获取当前日期前一周
     *
     * @return 前一周的日期
     */
    public static String lastWeek() {
        return prevDay(7);
    }

    /**
     * 获取当前年
     */
    public static String getCurrentYear() {
        Date date = new Date();
        return new SimpleDateFormat(DateFormat.YEAR_FORMAT).format(date);
    }

    /**
     * 是否在今天
     *
     * @param date 时间
     * @return 返回true代表在今天, 返回false不在今天
     */
    public static Boolean isToday(Date date) {
        SimpleDateFormat fmt = new SimpleDateFormat(DateFormat.DATE_FORMAT);
        return fmt.format(date).equals(fmt.format(new Date()));
    }

    /**
     * 是否在今天
     *
     * @param dateTime 时间
     * @return 返回true代表在今天, 返回false不在今天
     * @throws ParseException
     */
    public static Boolean isToday(String dateTime) throws ParseException {
        Date date = converToDate(dateTime);
        return isToday(date);
    }


    /**
     * 获取当前日期月份
     *
     * @param nowDate
     * @return
     * @throws ParseException
     */
    public static int getNowMonth(Date nowDate) throws ParseException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        return calendar.get(Calendar.MONTH);
    }

    /**
     * 获得当前的年份和季度
     *
     * @param nowDate
     * @return
     * @throws ParseException
     */
    public static Map<String, Object> getNowQuarter(Date nowDate) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);

        String quarter = "1";
        int firstMonth = 3;
        if (month >= 3 && month <= 5) {
        } else if (month >= 6 && month <= 8) {
            quarter = "2";
            firstMonth = 6;
        } else if (month >= 9 && month <= 11) {
            quarter = "3";
            firstMonth = 9;
        } else {
            quarter = "4";
            firstMonth = 12;
            if (month >= 1 && month <= 2)
                year = year - 1;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("year", year + "");
        map.put("quarter", quarter);
        map.put("month", month);
        map.put("date", date);
        map.put("firstMonth", firstMonth);
        return map;
    }

    /**
     * 将字符串的时间解析，获取解析后的年份,月份，日期；最后通过map取值。
     *
     * @param dateTime
     * @return
     */
    public static Map getYearAndMonthAndDate(String dateTime) {
        Calendar instance = Calendar.getInstance();
        Map map = new ConcurrentHashMap();

        try {
            //将字符串转换成日期格式
            Date date = converToDate(dateTime);
            instance.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        int date = instance.get(Calendar.DATE);
        map.put("year", year);
        map.put("month", month);
        map.put("date", date);

        return map;
    }

    /**
     * 日期字符串格式改变（yyyy年MM月dd日转为yyyy-MM-dd）
     *
     * @param dateStr
     * @return
     */
    public static String dateStrFormat(String dateStr) {
        String years = dateStr.substring(0, 4);
        String months = dateStr.substring(dateStr.indexOf("年") + 1, dateStr.indexOf("月"));
        String days = dateStr.substring(dateStr.indexOf("月") + 1, dateStr.indexOf("日"));
        String result = years + "-" + months + "-" + days;
        return result;
    }

    /**
     * 判断是否满18岁
     * @param dateStr
     * @param dateEnd
     * @return
     */
    public static boolean isCN(String dateStr, String dateEnd) {
        int yearsStr = Integer.parseInt(dateStr.substring(0, 4));
        int monthsStr = Integer.parseInt(dateStr.substring(dateStr.indexOf("年") + 1, dateStr.indexOf("月")));
        int daysStr = Integer.parseInt(dateStr.substring(dateStr.indexOf("月") + 1, dateStr.indexOf("日")));
        int yearsEnd = Integer.parseInt(dateEnd.substring(0, 4));
        int monthsEnd = Integer.parseInt(dateEnd.substring(dateStr.indexOf("年") + 1, dateStr.indexOf("月")));
        int daysEnd = Integer.parseInt(dateEnd.substring(dateStr.indexOf("月") + 1, dateStr.indexOf("日")));
        if ((yearsEnd - yearsStr > 18)
                || ((yearsEnd - yearsStr == 18) && (monthsEnd - monthsStr > 0))
                || ((yearsEnd - yearsStr == 18) && (monthsEnd - monthsStr == 0) && (daysEnd - daysStr) >= 0)) {
            return true;
        }
        return false;
    }

    /**
     * 日期区间类
     */
    public static class DateInterval {

        private String start;

        private String end;

        private Date startDate;

        private Date endDate;

        public String getStart() {
            return start;
        }

        public void setStart(String start) {
            this.start = start;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }
    }

}
