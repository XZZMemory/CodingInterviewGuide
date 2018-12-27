package other.对象创建的方法.clone;

import java.util.Date;

/**
 * 1 继承Cloneable方法
 * 2 实现clone接口
 */
public class Obj implements Cloneable
{
    private Date birth=new Date();

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
    public void chanegBirth()
    {
        this.birth.setTime(89l);
    }

    @Override
    public Object clone()
    {
        Obj o=null;
        try {
            o=(Obj)super.clone();
        }catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
        }
        o.setBirth((Date)this.getBirth().clone());
        return o;
    }
}
