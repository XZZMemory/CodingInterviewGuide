package 第一章栈和队列.问题2由两个栈组成的队列;

import java.util.Scanner;

/**
 * created by memory
 * on 2018/9/27 下午12:12
 */
public class 问题2由两个栈组成的队列 {
    public static void main(String[] args)
    {
        TwoStacksQueue queue=new TwoStacksQueue();
        System.out.println("请输入操作：1-进队列，2-出队列，3-查看当前队列头元素,0-退出程序");
        Scanner scanner;
        scanner=new Scanner(System.in);
        int operation;
        operation=scanner.nextInt();
        while(operation!=0)
        {
            switch (operation)
            {
                case 1:
                    System.out.println("请输入进队列元素");
                    Scanner sc=new Scanner(System.in);
                    int data=sc.nextInt();
                    queue.add(data);
                    break;
                case 2:
                    int num=queue.poll();
                    System.out.println("当前出对列元素是："+num);
                    break;
                case 3:
                    System.out.println("当前队列头元素是："+queue.peek());
                    break;
                default:
                    System.out.println("操作数输入错误，请重新输入！");
            }
            System.out.println("请输入操作：1-进队列，2-出队列，3-查看当前队列头元素,0-退出程序");
            scanner=new Scanner(System.in);
            operation=scanner.nextInt();
        }
    }
}
