package other.Java语法糖;

public class SwitchDemoString {
    public static void main(String[] args) {
        String str = "world";
        switch (str) {
            case "hello":
                System.out.println("hello");
                break;
            case "world":
                System.out.println("world");
                break;
            default:
                System.out.println("default");break;
        }
    }
}
