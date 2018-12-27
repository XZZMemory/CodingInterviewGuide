package other.JDBC连接数据库; /**
 * created by memory
 * on 2018/10/10 下午4:05
 */
import java.sql.*;
public class databaseTest {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/test1";

    //  Database credentials -- 数据库名和密码自己修改
    static final String USER = "root";
    static final String PASS = "kai201713";
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);//注册JDBC驱动程序

            //STEP 3: Open a connection 打开一个连接
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);

            //STEP 4: Execute a query执行一个查询
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "SELECT id, ename FROM emp";
            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set从结果集中提取数据
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String name = rs.getString("ename");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", name: " + name);
            }
            //STEP 6: Clean-up environment 清理环境资源
            rs.close();
            stmt.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    stmt.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main

}
