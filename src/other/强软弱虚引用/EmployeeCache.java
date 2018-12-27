package other.强软弱虚引用;

import java.util.Hashtable;

public class EmployeeCache {
    static private EmployeeCache cache;//一个擦车实例
    private Hashtable<String,EmployeeRef> employeeRefs;
    private EmployeeCache()
    {
        employeeRefs=new Hashtable<>();
    }
    public static EmployeeCache getInstance()
    {
        if (cache==null)
            cache=new EmployeeCache();
        return cache;
    }
    private  void cacheEmployee(Employee em)
    {
        //cleanCache();//清除垃圾引用
        //EmployeeRef ref=new EmployeeRef(em,q);
    }
    public Employee getEmployee(String id)
    {
        Employee em=null;
        //缓存中是否有Employee实例的引用，如果有，从软引用中获得
        if (employeeRefs.contains(id))
        {
            EmployeeRef ref=(EmployeeRef)employeeRefs.get(id);
            em=(Employee) ref.get();
        }
        //如果没有软引用，或者软引用中得到的是null，重新构建一个实例并保存对这个新建实例的引用
        if (em==null)
        {
            em=new Employee(id);
           // this.
        }
        return null;

    }

}
