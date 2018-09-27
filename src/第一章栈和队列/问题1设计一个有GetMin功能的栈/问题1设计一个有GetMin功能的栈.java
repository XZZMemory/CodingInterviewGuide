package 第一章栈和队列.问题1设计一个有GetMin功能的栈;

import java.util.Scanner;

//设计一个特殊功能的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。设计的栈类型可以使用现成的栈结构
public class 问题1设计一个有GetMin功能的栈 {
    public static void main(String[] args)
    {
        Method1();
    }
    public static void Method1()
    {
        MyStack1 myStack1=new MyStack1();
        System.out.println("请输入操作：1-进栈，2-出栈，3-查看当前最小元素,0-退出程序");
        Scanner scanner;
        scanner=new Scanner(System.in);
        int operation;
        operation=scanner.nextInt();
        while(operation!=0)
        {
            switch (operation)
            {
                case 1:
                    System.out.println("请输入进栈元素");
                    Scanner sc=new Scanner(System.in);
                    int data=sc.nextInt();
                    myStack1.push(data);
                    break;
                case 2:
                    myStack1.pop();
                    break;
                case 3:
                    System.out.println("当前最小元素是："+myStack1.getmin());
                    break;
                default:
                    System.out.println("操作数输入错误，请重新输入！");
            }
            System.out.println("请输入操作：1-进栈，2-出栈，3-查看当前最小元素,0-退出程序");
            scanner=new Scanner(System.in);
            operation=scanner.nextInt();
        }
    }
}
