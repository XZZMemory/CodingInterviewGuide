package other.强软弱虚引用;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
//继承SoftReference，使得每一个实例都具有可识别的标识
//并且该标识与其在hashMap中的key相同
public class EmployeeRef extends SoftReference<Employee> {
    private String key="";
    public EmployeeRef(Employee em, ReferenceQueue<Employee> q)
    {
        super(em,q);
        key=em.getId();
    }
}


