package 第一章栈和队列.问题1设计一个有GetMin功能的栈;

import java.util.Stack;

public class MyStack1 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack1() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int newNum) {
        if (this.stackMin.isEmpty())
            this.stackMin.push(newNum);
        else if (newNum <= this.getmin())
            this.stackMin.push(newNum);
        this.stackData.push(newNum);
        System.out.println("The current push data is" + newNum);
    }
    public int pop()
    {
        if (this.stackData.isEmpty())
            throw new RuntimeException("Your stack is empty!");
        Integer data=this.stackData.pop();
        if (data==this.stackMin.peek())
            this.stackMin.pop();
        return data;
    }
    public Integer getmin()
    {
        if (this.stackMin.isEmpty())
            throw new RuntimeException("Your stack is empty1");
        return this.stackMin.peek();
    }
}
