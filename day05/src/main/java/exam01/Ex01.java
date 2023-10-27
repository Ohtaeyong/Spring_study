package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver"); // 동적 로딩

        String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // xe쓰는사람은 뒤에 xe까지
        String username = "scott";
        String password = "tiger";

//        try {
//            Connection conn = DriverManager.getConnection(url, username, password);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } // 자원해제 -> 아래와 같이 변경
        try (Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement()) { // 알아서 자원해제

            int deptNo = 50;
            String dName = "DEPT1";
            String loc = "LOC1";

            //String sql = "INSERT INTO DEPT2 VALUES (50, 'DEPT1', 'LOC1')";
            String sql = "INSERT INTO DEPT2 VALUES (" + deptNo + ", '" + dName + "', '" + loc + "')";
            int affectedRows = stmt.executeUpdate(sql);
            System.out.println(affectedRows); // 1이 나오면 성공

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
