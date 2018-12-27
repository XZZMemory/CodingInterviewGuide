package other.设计模式.享元模式.享元模式1;

public class EmployeeReportManager  implements IReportManager{
    private String tenantId =null;
    public  EmployeeReportManager(String tenantId)
    {
        this.tenantId=tenantId;
    }

    @Override
    public String creatReport() {
        return "this is a employee report";
    }
}
