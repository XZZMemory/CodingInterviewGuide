package 第一章栈和队列.问题2由两个栈组成的队列;

import java.util.Stack;
/**
 * created by memory
 * on 2018/9/27 上午10:34
 */
public class TwoStacksQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public TwoStacksQueue()
    {
        stackPush=new Stack<>();
        stackPop=new Stack<>();

    }
    public void add(int pushData){
        this.stackPush.push(pushData);
    }
    public int poll(){
        if (this.stackPush.isEmpty()&&this.stackPop.isEmpty())
            throw new RuntimeException("Queue is empty！");
        else if (stackPop.isEmpty())
        {
            while (!stackPush.isEmpty())
                stackPop.push(stackPush.pop());
        }
        return stackPop.pop();
    }
    public int peek(){
        if (stackPop.isEmpty()&&stackPush.isEmpty())
            throw new RuntimeException("Queue is empty!");
        else if (stackPop.isEmpty())
            while (!stackPush.isEmpty())
                stackPop.push(stackPush.pop());
        return stackPop.peek();
    }
}
