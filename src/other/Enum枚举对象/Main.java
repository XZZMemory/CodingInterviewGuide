package other.Enum枚举对象;

public class Main {
    public static void main(String[] args)
    {
       int i=0;
       i++;
        for (;  i<10 ; i++) {
            System.out.println(i);
            WeekDay.printDay(i);
        }
    }
}
