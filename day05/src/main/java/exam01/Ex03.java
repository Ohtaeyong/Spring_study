package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ex03 { // 안전하고 좋음
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String user = "scott";
        String pass = "tiger";

        String sql = "INSERT INTO DEPT2 VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, pass);
        PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1,50); // 직접 값을 입력하는게 아니라 변수형태로 넘어옴
            pstmt.setString(2, "DEPT2");
            pstmt.setString(3, "LOC2");

            int affectedRows = pstmt.executeUpdate();
            System.out.println(affectedRows);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
