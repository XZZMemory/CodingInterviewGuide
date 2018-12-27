package 第一章栈和队列.问题1设计一个有GetMin功能的栈;
import java.util.Stack;
public class MyStack2 {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public MyStack2()
    {
        this.stackData=new Stack<>();
        this.stackMin=new Stack<>();
    }
    public void push(int newNum)
    {
        this.stackData.push(newNum);
        if (this.stackMin.isEmpty())
            this.stackMin.push(newNum);
        else if (newNum>this.getmin())
            this.stackMin.push(this.getmin());
        else
            this.stackMin.push(newNum);
    }
    public int pop()
    {
        if (this.stackData.isEmpty())
            throw new RuntimeException("Your stack is empty");
        this.stackMin.pop();
        return this.stackData.pop();
    }
    public int getmin()
    {
        if (this.stackMin.isEmpty())
            throw new RuntimeException("Your stack is empty!");
        return this.stackMin.peek();
    }
}
