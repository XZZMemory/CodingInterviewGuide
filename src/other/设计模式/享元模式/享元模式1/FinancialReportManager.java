package other.设计模式.享元模式.享元模式1;

public class FinancialReportManager implements IReportManager {
    private String tenantId =null;
    public  FinancialReportManager(String tenantId)
    {
        this.tenantId=tenantId;
    }
    @Override
    public String creatReport() {
        return "This is a financial report;";
    }
}
