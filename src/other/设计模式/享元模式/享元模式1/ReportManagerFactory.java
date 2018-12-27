package other.设计模式.享元模式.享元模式1;

import java.util.HashMap;
import java.util.Map;

public class ReportManagerFactory {
    Map<String,IReportManager> financialReportManager=new HashMap<>();
    Map<String,IReportManager> employeeReportManager=new HashMap<>();
    IReportManager getFinancialReportManager(String tenantId)
    {
        IReportManager r=financialReportManager.get(tenantId);
        if (r==null)
        {
            r=new FinancialReportManager(tenantId);
            financialReportManager.put(tenantId,r);
        }
        return r;
    }
    IReportManager getEmployeeReportManager(String tenantId)
    {
        IReportManager r=employeeReportManager.get(tenantId);
        if (r==null)
        {
            r=new FinancialReportManager(tenantId);
            financialReportManager.put(tenantId,r);
        }
        return r;
    }
}
