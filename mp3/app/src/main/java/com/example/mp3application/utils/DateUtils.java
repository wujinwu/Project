package com.example.mp3application.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/6/6.
 */
public class DateUtils {

    public static String minutesdd(String day1) {
        DateFormat dfhm = new SimpleDateFormat("mm:ss");
        long diff = Float.valueOf(day1).longValue() * 1000;
        return dfhm.format(diff);
    }

    public static String minutesdd(long day1) {
        DateFormat dfhm = new SimpleDateFormat("mm:ss");
        return dfhm.format(day1);
    }

    public static String minutesdd_1000(long day1) {
        DateFormat dfhm = new SimpleDateFormat("mm:ss");
        return dfhm.format(day1 * 1000);
    }


    public static int getSecond(long day1) {
        int second = Math.abs((int) (day1 / 1000));
        return second;
    }

    public static String time(String day1) {
        DateFormat dfhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        long diff = Float.valueOf(day1).longValue();
        return dfhm.format(diff);
    }


    public static String time(long day1) {
        DateFormat dfhm = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return dfhm.format(day1);
    }

    public static String timess(long day1) {
        DateFormat dfhm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dfhm.format(day1);
    }

    public static String timehmCha(String day1, String day2) {

        DateFormat dfhm = new SimpleDateFormat("HH:mm");

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
        String time = "";
        try {

            long d1 = Long.parseLong(day1);
            long d2 = Long.parseLong(day2);
            long diff = d2 - d1;
            //这样得到的差值是微秒级别
            int days = Math.abs((int) (diff / (1000 * 60 * 60 * 24)));
            int hours = Math.abs((int) (diff / (1000 * 60 * 60)));
            int minutes = Math.abs((int) (diff / (1000 * 60)));
            if (minutes < 10 && hours == 0 && days == 0) {
                time = dfhm.format(d1);
                return time;
            } else if (minutes > 10 && hours < 1 && days < 1) {
                time = dfhm.format(d1);
                return time;
            } else {
                time = df.format(d1);
                return time;
            }
        } catch (Exception e) {
        }
        return time;
    }

    public static String timehmCha(long day1, long day2) {

        DateFormat dfhm = new SimpleDateFormat("HH:mm");

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
        String time = "";
        try {
            long d1 = day1;
            long d2 = day2;
            long diff = d2 - d1;
            //这样得到的差值是微秒级别
            int days = Math.abs((int) (diff / (1000 * 60 * 60 * 24)));
            int hours = Math.abs((int) (diff / (1000 * 60 * 60)));
            int minutes = Math.abs((int) (diff / (1000 * 60)));
            if (minutes < 10 && hours == 0 && days == 0) {
                time = dfhm.format(d1);
                return time;
            } else if (minutes > 10 && hours < 1 && days < 1) {
                time = dfhm.format(d1);
                return time;
            } else {
                time = df.format(d1);
                return time;
            }
        } catch (Exception e) {
        }
        return time;
    }


    public static String timehmCha2(long day1, long day2) {

        DateFormat dfhm = new SimpleDateFormat("HH:mm");

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd ");
        String time = "";
        try {
            long d1 = day1;
            long d2 = day2;
            long diff = d2 - d1;
            //这样得到的差值是微秒级别
            int days = Math.abs((int) (diff / (1000 * 60 * 60 * 24)));
            int hours = Math.abs((int) (diff / (1000 * 60 * 60)));
            int minutes = Math.abs((int) (diff / (1000 * 60)));
            if (minutes < 10 && hours == 0 && days == 0) {
                time = dfhm.format(d1);
                return time;
            } else if (minutes > 10 && hours < 1 && days < 1) {
                time = dfhm.format(d1);
                return time;
            } else {
                DateFormat d3 = new SimpleDateFormat("MM月dd日");
                DateFormat d4 = new SimpleDateFormat("M月dd日");
                DateFormat dfy1 = new SimpleDateFormat("yyyy");
                DateFormat dfy2 = new SimpleDateFormat("yyyy");
                String time1 = dfy1.format(new Date(day1));
                String time2 = dfy2.format(new Date(day1));
                if (time1.equals(time2)) {
                    time = d3.format(new Date(day2));
                    if (time.startsWith("0")) {
                        time = d4.format(new Date(day2));
                    }
                } else {
                    time = df.format(new Date(day2));
                }
                return time;
            }
        } catch (Exception e) {
        }
        return time;
    }

    public static String timeCha(String day1, String day2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = "";
        try {
            long d1 = Long.parseLong(day1);
            long d2 = Long.parseLong(day2);

            long diff = d2 - d1;//这样得到的差值是微秒级别
            int days = Math.abs((int) (diff / (1000 * 60 * 60 * 24)));
            int hours = Math.abs((int) (diff / (1000 * 60 * 60)));
            int minutes = Math.abs((int) (diff / (1000 * 60)));
            if (minutes < 10 && hours == 0 && days == 0) {
                time = "刚刚";
                return time;
            } else if (minutes > 10 && hours < 1 && days < 1) {
                time = minutes + "分钟前";
                return time;
            } else if (hours >= 1 && days < 1) {
                time = hours + "小时前";
                return time;
            } else if (days >= 1 && days < 3) {
                time = "1天前";
                return time;
            } else if (days >= 3 && days < 7) {
                time = "3天前";
                return time;
            } else if (days >= 7) {
                time = df.format(d1);
                return time;
            } else {
                time = df.format(d1);
                return time;
            }
        } catch (Exception e) {
        }
        return time;
    }

    public static String timeCha(String day1) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = "";
        long d1 = Long.parseLong(day1);
        time = df.format(d1);
        return time;
    }

    public static String timeYmd(long day1) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = df.format(day1);
        return time;
    }


    public static String timeYmdx(long day1) {
        DateFormat df = new SimpleDateFormat("yy/MM/dd");
        String time = df.format(day1);
        return time;
    }

    public static String timeDYmd(long day1) {
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        String time = df.format(day1);
        return time;
    }

    public static String timeCha(Long day1, Long day2) {
        //  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String time = "";
        try {
            long diff = day2 - day1;//这样得到的差值是微秒级别
            int days = Math.abs((int) (diff / (1000 * 60 * 60 * 24)));
            int hours = Math.abs((int) (diff / (1000 * 60 * 60)));
            int minutes = Math.abs((int) (diff / (1000 * 60)));
            if (minutes < 10 && hours == 0 && days == 0) {
                time = "刚刚";
                return time;
            } else if (minutes > 10 && hours < 1 && days < 1) {
                time = minutes + "分钟前";
                return time;
            } else if (hours >= 1 && days < 1) {
                time = hours + "小时前";
                return time;
            } else if (days >= 1 && days < 3) {
                time = "1天前";
                return time;
            } else if (days >= 3 && days < 7) {
                time = "3天前";
                return time;
            } else if (days >= 7 && days <= 30) {
                time = "7天前";
                return time;
            } else {
                time = df.format(new Date(day1));
                return time;
            }
        } catch (Exception e) {
        }
        return time;
    }

    public static String time_Cha(Long day1, Long day2) {
        //  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String time = "";
        try {
            long diff = day2 - day1;//这样得到的差值是微秒级别
            int days = Math.abs((int) (diff / (1000 * 60 * 60 * 24)));
            int hours = Math.abs((int) (diff / (1000 * 60 * 60)));
            int minutes = Math.abs((int) (diff / (1000 * 60)));
            if (minutes < 10 && hours == 0 && days == 0) {
                time = "刚刚";
                return time;
            } else if (minutes > 10 && hours < 1 && days < 1) {
                time = minutes + "分钟前";
                return time;
            } else if (hours >= 1 && days < 1) {
                time = hours + "小时前";
                return time;
            } else if (days >= 1 && days < 3) {
                time = "1天前";
                return time;
            } else if (days >= 3 && days < 7) {
                time = "3天前";
                return time;
            } else if (days >= 7 && days <= 30) {
                time = "7天前";
                return time;
            } else {
                time = df.format(new Date(day1));
                return time;
            }
        } catch (Exception e) {
        }
        return time;
    }

    public static String timeChar(Long day1, Long day2) {
        String time = "";
        //  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        DateFormat d1 = new SimpleDateFormat("MM月dd日");
        DateFormat d2 = new SimpleDateFormat("M月dd日");
        DateFormat dfy1 = new SimpleDateFormat("yyyy");
        DateFormat dfy2 = new SimpleDateFormat("yyyy");
        String time1 = dfy1.format(new Date(day1));
        String time2 = dfy2.format(new Date(day1));
        if (time1.equals(time2)) {
            time = d1.format(new Date(day2));
            if (time.startsWith("0")) {
                time = d2.format(new Date(day2));
            }
        } else {
            time = df.format(new Date(day2));
        }
        return time;
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000 * 3600 * 24));
        return days;
    }


    private static long lastClickTime;

    public synchronized static boolean isFastClick_() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 100) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /********防止按钮连续点击********/
    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }


    /********防止按钮连续点击********/
    public synchronized static boolean isFastClick3000() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 3000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }


    public synchronized static boolean isFastClick1() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 2000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }


    public static int getTianShu(Long day1) {
        //  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long day2 = System.currentTimeMillis();
        long diff = day1 - day2;//这样得到的差值是微秒级别
        int days = Math.abs((int) (diff / (1000 * 60 * 60 * 24)));
        return days;
    }

    public static String getHours(Long day1) {
        //  DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long day2 = System.currentTimeMillis();
        long diff = day1 - day2;//这样得到的差值是微秒级别
        int hours = Math.abs((int) (diff / (1000 * 60 * 60)) % 24);
        if (hours < 10) {
            return "0" + hours;
        }
        return hours + "";

    }

    public static String getminutes(Long day1) {
        long day2 = System.currentTimeMillis();
        long diff = day1 - day2;//这样得到的差值是微秒级别

        int minutes = Math.abs((int) (diff / (1000 * 60)) % 60);
        if (minutes < 10) {
            return "0" + minutes;
        }
        return minutes + "";

    }

    public static String getmiao(Long day1) {
        long day2 = System.currentTimeMillis();
        long diff = day1 - day2;//这样得到的差值是微秒级别
        int miao = Math.abs((int) (diff / (1000)) % 60);
        if (miao < 10) {
            return "0" + miao;
        }
        return miao + "";
    }
}
