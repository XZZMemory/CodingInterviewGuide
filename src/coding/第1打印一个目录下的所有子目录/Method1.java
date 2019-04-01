package coding.第1打印一个目录下的所有子目录;

import java.io.File;

/**
 * file有自己的方法，当成树的深度/广度遍历即可
 * master1
 */
public class Method1 {
    public static void main(String[] args)
    {
        File currentFile=new File("D:\\");
        Method1 method1=new Method1();
        method1.getAllFiles(currentFile,0);

    }
    public void  getAllFiles(File dir,int level)
    {
        System.out.println(getLevel(level)+dir.getName());
        File[] files=dir.listFiles();
        for (int i = 0; i <files.length ; i++) {
            if (files[i].isDirectory())
                getAllFiles(files[i],level+1);
            else
                System.out.println(getLevel(level+1)+files[i].getName());
        }

    }
    public String getLevel(int level)
    {
        if (level<=0)
            return null;
        StringBuffer sb=new StringBuffer("");
        for (int i = 0; i <level ; i++) {
            sb.append("|- -");
        }
        return sb.toString();
    }
}
