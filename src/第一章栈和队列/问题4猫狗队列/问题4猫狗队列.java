package 第一章栈和队列.问题4猫狗队列;

import java.util.Scanner;

/**
 * created by memory
 * on 2018/9/27 下午1:23
 */
public class 问题4猫狗队列 {
    public static void main(String[] args)
    {
        DogCatQueue dogCatQueue=new DogCatQueue();
        Dog dog=new Dog();
        Cat cat=new Cat();
        System.out.println("请输入操作：0-退出程序，1-进队列，2-出队列，3-狗出队列,4-猫出队列，5-队列是否空，6-狗队列是否空，7-猫对列是否空");
        Scanner scanner;
        scanner=new Scanner(System.in);
        int operation;
        operation=scanner.nextInt();
        while(operation!=0)
        {
            switch (operation)
            {
                case 1:
                    System.out.println("请输入进对列元素，1-狗进队列，2-猫队列");
                    Scanner sc=new Scanner(System.in);
                    int type=sc.nextInt();
                    if(type==1)
                        dogCatQueue.add(dog);
                    else if (type==2)
                        dogCatQueue.add(cat);
                    System.out.println("进队列成功");
                    break;
                case 2:
                    dogCatQueue.pollAll();
                    break;
                case 3:
                    Dog dog1=dogCatQueue.pollDog();
                    System.out.println(dog1.getPetType());
                    break;
                case 4:
                    Cat cat1=dogCatQueue.pollCat();
                    System.out.println(cat1.getPetType());
                    break;
                case 5:
                    System.out.println(dogCatQueue.isEmpty()+"大小是："+dogCatQueue.size());
                    break;
                case 6:
                    System.out.println(dogCatQueue.isDogEmpty()+"大小是："+dogCatQueue.dogSize());
                    break;
                case 7:
                    System.out.println(dogCatQueue.isCatEmpty()+"大小是："+dogCatQueue.catSize());
                    break;
                default:
                    System.out.println("操作数输入错误，请重新输入！");
            }
            System.out.println("请输入操作：0-退出程序，1-进队列，2-出队列，3-狗出队列,4-猫出队列，5-队列是否空，6-狗队列是否空，7-猫对列是否空");
            scanner=new Scanner(System.in);
            operation=scanner.nextInt();
        }

    }
}
