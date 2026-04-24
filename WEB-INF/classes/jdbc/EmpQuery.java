package jdbc;


import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EmpQuery {
    //使用するSQL、ユーザー名、パスワードを定数として定義
    public static final String SELECT_ALL_EMP = "SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno FROM emp";
    public static final String user = "info";
    public static final String pass = "pro";

    //Emp表からResultSetを取得して、それをArrayListに詰めなおしてreturn
    public static List<?> getEmpList(){
        //従業員情報を格納するListを用意
        List<List<String>> empList = new ArrayList<>();
        //JDBC関連の変数を宣言
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        //JDBCドライバのロード
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            //データベースへ接続し、SQLを実行   
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl",user,pass);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(SELECT_ALL_EMP);
            //取得したデータをListに格納
            while (rs.next()) {
                ArrayList<String> empRecord = new ArrayList<>();
                empRecord.add(rs.getString("empno"));
                empRecord.add(rs.getString("ename"));
                empRecord.add(rs.getString("job"));
                empRecord.add(rs.getString("mgr"));
                empRecord.add(rs.getString("hiredate"));                              
                empRecord.add(rs.getString("sal"));                              
                empRecord.add(rs.getString("comm"));                              
                empRecord.add(rs.getString("deptno"));                              
                //recordをListに追加
                empList.add(empRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DB接続に失敗しました。");   
        }catch (ClassNotFoundException e) {
            e.printStackTrace(); 
            System.out.println("JDBCドライバのロードに失敗しました。");
        }finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return empList;
    }





}







