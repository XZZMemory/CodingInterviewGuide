import java.text.SimpleDateFormat;
import java.util.Date;

public class 打印日期 {
    public static void main(String[] args)
    {
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
        System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
    }
}
