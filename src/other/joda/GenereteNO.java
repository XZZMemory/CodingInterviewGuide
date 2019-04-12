package other.joda;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class GenereteNO {
    public static void genetate(NOEnum noEnum, long userId) {
        System.out.println("************************************");
        StringBuffer sb = new StringBuffer();
        sb.append(noEnum.getValue());
        sb.append(System.currentTimeMillis());

        String str = String.format("%06d", userId);
        System.out.println("id是： " + userId);
        System.out.println("格式化后的id是：" + str);
        Long currnetTime = System.currentTimeMillis();
        long oneHourAgo = currnetTime - 3600*60 ;
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = df.format(currnetTime);
        System.out.println("全格式时间：" + time);
//        int i1=Integer.valueOf(time);
//        System.out.println("全格式时间int："+i1);

        SimpleDateFormat df2 = new SimpleDateFormat("ddHHmmss");
        String time2 = df2.format(currnetTime);
        int i2 = Integer.valueOf(time2);
        String yester=df2.format(oneHourAgo);
        int i3=Integer.valueOf(yester);
        System.out.println("一小时之前："+i3);
        System.out.println("只有小时之后的时间时间：" + time2);
        System.out.println("只有小时之后的时间时间int ：" + i2);

        System.out.println("当前时间：" + currnetTime);
        int IO = (int) (long) i2;
        System.out.println("格式化后int的时间：" + IO);
        int currentId = ((int) userId) ^ IO;
        int afterId = ((Integer.valueOf(str)) ^ IO);
        int IO2 = (int) (long) i3;
        int oneHour=((int) userId) ^ IO2;
        System.out.println("格式化前的数据：  " + sb + ":" + String.format("%06d", currentId));
        System.out.println("格式化后的数据：  " + sb + ":" + String.format("%06d", afterId));
        System.out.println("格式化后的数据：  " + sb + ":" + String.format("%06d", oneHour));

    }
    public static String ge2(NOEnum noEnum, long userId)
    {
        StringBuffer sb = new StringBuffer();
        sb.append(noEnum.getValue());
        Long currnetTime = System.currentTimeMillis();

        SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");
        sb.append(df1.format(currnetTime)+" : ");

        SimpleDateFormat df2 = new SimpleDateFormat("ddHHmmss");
        String time2 = df2.format(currnetTime);
        int value = Integer.valueOf(time2);
        int data=((int) userId) ^ value;
        sb.append(data);
        return sb.toString();
    }

    public static void main(String[] args) {
        ge2(NOEnum.BALANCE, 8);
        ge2(NOEnum.BALANCE, 500);
        ge2(NOEnum.BALANCE, 89089000);
    }
}
