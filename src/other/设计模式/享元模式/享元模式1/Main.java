package other.设计模式.享元模式.享元模式1;

public class Main {
    public static void main(String[] args)
    {
        /**
         * 同一公司的不同用户，得到相同的报表
         */
        ReportManagerFactory reportManagerFactory=new ReportManagerFactory();
        IReportManager iReportManagerA=reportManagerFactory.getFinancialReportManager("A");
        IReportManager iReportManagerB=reportManagerFactory.getFinancialReportManager("B");
        System.out.println(iReportManagerA.creatReport());
        System.out.println(iReportManagerB.creatReport());
    }
}
