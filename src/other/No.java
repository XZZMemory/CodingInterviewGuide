package other;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class No {
    private static final AtomicInteger SERIAL = new AtomicInteger(Integer.MAX_VALUE);

    private static final int SHIFTS_FOR_TIMESTAMP = 17;
    private static final int SHIFTS_FOR_UNION = 14;

    public static void next(long userId, long type) {
        long time = System.currentTimeMillis();
        long unionShift = userId << (64 - 1 - SHIFTS_FOR_TIMESTAMP - SHIFTS_FOR_UNION);
        long serial = SERIAL.incrementAndGet();
        long number = unionShift | (serial);

        System.out.println(time);
        System.out.println(number);
        System.out.println(serial);
    }

    public static void main(String[] args) {
        next(2, 3);
        Date date=new Date();
        System.out.println("date: "+date);
        long currentTime=System.currentTimeMillis();
        long after=currentTime+3600*60*24*69;
        System.out.println(after);
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd- HH:mm:ss");
        System.out.println(df.format(new Date(1555420701324L)));

    }
}