package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

    private static final String HOST = "localhost";
    private static final String PORT = "5432";
    private static final String DB_NAME = "qltv_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "admin";

    private static final String URL = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DB_NAME;

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                createTablesIfNotExists(conn);
            } catch (SQLException e) {
                System.out.println("Lỗi kết nối CSDL: " + e.getMessage());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println("Không tìm thấy PostgreSQL JDBC Driver!");
            }
        }
        return conn;
    }

    private static void createTablesIfNotExists(Connection conn) {
                String sqlSach = "CREATE TABLE IF NOT EXISTS Sach ("
                + " MaSach TEXT PRIMARY KEY,"
                + " TenSach TEXT NOT NULL,"
                + " TacGia TEXT,"
                + " TheLoai TEXT,"
                + " SoLuong INTEGER"
                + ");";

        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sqlSach);
        } catch (SQLException e) {
            System.out.println("Lỗi khi tạo bảng Sach: " + e.getMessage());
        }
    }
}