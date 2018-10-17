package 第一章栈和队列;

/**
 * created by memory
 * on 2018/10/16 下午4:49
 */

import java.util.Stack;

/**
 * 给定一个整型矩阵，其中的值只有0和1，求其中全是1的所有矩阵区域中，最大的矩形区域中，1的数量
 * 如：矩阵  1 0 1 1
 *          1 1 1 1
 *          1 1 1 0
 *          最大的矩形区域中有6个1，所以返回6
 *          矩阵大小是N*M，时间复杂度是O(M*N)
 */
public class 问题9求最大子矩阵的大小 {
    public static void main(String[] args)
    {
        int[][] height={{1,0,1,1},{1,1,1,1},{1,1,1,0}};
        int maxArea=getMaxRecSize(height);
    }
    public static int getMaxRecSize(int[][] map)
    {
        if(map==null||map.length==0||map[0].length==0)
            return 0;
        int maxArea=0;
        int[] height=new int[map[0].length];
        for (int i=0;i<map.length;++i)
        {
            for (int j=0;j<map[i].length;++j)
                height[j]=map[i][j]==0?0:height[j]+1;
            maxArea=getMaxRecFromBottom(height);
        }
        return maxArea;

    }
    public static int getMaxRecFromBottom(int[] height){
        if (height==null||height.length==0)
            return 0;
        int maxArea=0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<height.length;++i)
        {
            while((!stack.isEmpty())&&height[stack.peek()]>=height[i])//i当前值
            {
                int j=stack.pop();
                int peek_num= stack.isEmpty()? -1:stack.peek();
                int curArea=height[j]*(i-peek_num-1);
                maxArea=Math.max(maxArea,curArea);
            }
            stack.push(i);
        }
        while (!stack.isEmpty())
        {
            int j=stack.pop();
            int peek_num=stack.isEmpty()? -1:stack.peek();
            int curArea=height[j]*(height.length-peek_num-1);
            maxArea=Math.max(curArea,maxArea);
        }
        return maxArea;
    }

}
