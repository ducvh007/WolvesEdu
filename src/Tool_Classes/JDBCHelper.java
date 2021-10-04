package Tool_Classes;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Topic: Interface tổ chức chuẩn đặt tên phương thức cho các lớp DAO
 * Content: Phần mềm quản lý hệ thống đào tạo - WolvesEdu...
            * ...
 * Version: 1.0.0
 * Author: Four Wolves >> Văn Hữu Đức - PC01395 >> Trần Thanh Hồ - PC02096 >> Huỳnh Nhật Quang - PC01597 >> Nguyễn Văn Nhựt Trường - PC01752
 * Date: 17th September 2021 >> .. .. 2021
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class JDBCHelper {
    
    // Đối tượng kết nối với CSDL
    public static Connection connect;
    
    // Phương thức kết nối với CSDL: hàm trong hàm
    public static void getConnectSQL(String database, String user, String password) {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost; databaseName = "+database;
            connect = DriverManager.getConnection(url, user, password);
        } catch (Exception e) { System.out.println("Lỗi kết nối: "+e);}
    }
    
    // Phương thức đóng kết nối với SQL: hàm trong hàm
    public static void closeConnectSQL() {
        if (connect !=null) {
            try {
                connect.close();
            } catch (Exception e) { }
        }
    }
    
    // Phương thức nhập lại mật khẩu sa khi xảy ra lại
    public static String saPassword(Component frame, String cauHoi) {
        return (JOptionPane.showInputDialog(frame, cauHoi)).trim();
    }

    // Phương thức chuẩn bị câu lệnh truyền xuống SQL Server: hàm trong hàm
    public static PreparedStatement preparedStatement(String sql, Object...thamSo) {
        try {
            PreparedStatement cauLenh = null;
            if (sql.trim().contains("{")) {// Thủ tục lưu có chưa dấu ngoặc nhọn {}
                cauLenh = connect.prepareCall(sql);
            } else {
                cauLenh = connect.prepareStatement(sql);
            }
            // Chạy vòng for để điền tham số truyền vào vào chấm hỏi tương ứng
            for (int i = 0; i < thamSo.length; i++) {
                cauLenh.setObject(i+1, thamSo[i]);
            }
            return cauLenh;            
        } catch (Exception e) {
            return null;
        }
    }
    
    // Phương thức truy vấn CSDL
    public static ResultSet querySQL(String sql, Object...thamSo) {
        try {
            PreparedStatement cauLenh = preparedStatement(sql, thamSo);
            return cauLenh.executeQuery();
        } catch (SQLException e) {
            System.out.println("Lỗi query: "+e);
            return null;
        }
    }    
    
    // Phương thức có thao tác với CSDL: insert, update, delete
    public static void updateSQL(String sql, Object...thamSo) {
        try {
            PreparedStatement cauLenh = preparedStatement(sql, thamSo);
            try {
                 cauLenh.executeUpdate();
            } finally {
                cauLenh.getConnection().close();
            }
        } catch (Exception e) {
        }
    }
    
    // Phương thức truy vấn SQL trả về duy nhất 1 giá trị
    public static Object valueSQL(String sql, Object...args){
        try {
            ResultSet ketQua = JDBCHelper.querySQL(sql, args);
            if(ketQua.next()){
                return ketQua.getObject(sql);
            }
            ketQua.getStatement().getConnection().close();
            return null;
        } catch (Exception e) {
            System.out.println("Lỗi value: "+e);
            return null;
        }
    }
    
    // 
}
