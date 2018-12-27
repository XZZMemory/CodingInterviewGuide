package other.最常用的五大算法.动态规划;

/**
 * created by memory
 * on 2018/12/27 下午5:02
 */

import java.util.ArrayList;

/**
 * 问题描述：
 * 给定n种物品和一背包。物品i的重量是wi，其价值为vi，背包的容量为C。问应如何选择装入背包的物品，使得装入背包中物品的总价值最大?
 * 对于一种物品，要么装入背包，要么不装。所以对于一种物品的装入状态可以取0和1.我们设物品i的装入状态为xi,xi∈ (0,1)，
 * 此问题称为0-11背包问题。
 * 数据：物品个数n=5,物品重量w[n]={0，2，2，6，5，4},物品价值V[n]={0，6，3，5，4，6},
 * （第0位，置为0，不参与计算，只是便于与后面的下标进行统一，无特别用处，也可不这么处理。）总重量c=10。
 * 背包的最大容量为10，那么在设置数组m大小时，
 * 可以设行列值为6和11，那么，对于m(i,j)就表示可选物品为i…n背包容量为j(总重量)时背包中所放物品的最大价值。
 */

public class DynamicPlan {
    public static void main(String[] args) {
        //第一维下标i表示物品id,第二维下标j表示各个容量值,数组实际值代表价值,c[0][..]全部赋值为0,以便第一
        int c[][] = new int[4][11];
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        //物品1
        ArrayList<Integer> al1 = new ArrayList<Integer>();
        al1.add(3); //物品大小
        al1.add(4);  //物品价值
        al.add(al1);
        //物品2
        ArrayList<Integer> al2 = new ArrayList<Integer>();
        al2.add(4);
        al2.add(5);
        al.add(al2);
        //物品3
        ArrayList<Integer> al3 = new ArrayList<Integer>();
        al3.add(5);
        al3.add(6);
        al.add(al3);
        for (int a = 0; a <= 10; a++)
            c[0][a] = 0;
        int itemcount = al.size();
        for (int i = 0; i < itemcount; i++) {
            int index = i + 1; //物品id从1开始
            for (int j = 0; j <= 10; j++) {
                //如果当前物品的重量小于容量j,才考虑后续处理
                if (al.get(i).get(0) <= j) {
                    //加入物品i的情况,当前容量(j)减去i的容量即是前i-1种物品可使用的容量,容量下i-1种物品的价值+当前物品i的价值
                    //与不加物品i的价值对比
                    int temp = Math.max(c[index - 1][j - al.get(i).get(0)] + al.get(i).get(1), c[index - 1][j]);
                    c[index][j] = temp;
                } else {
                    c[index][j] = c[index - 1][j];
                }
            }
        }
        System.out.println(c[3][10]);
    }
}