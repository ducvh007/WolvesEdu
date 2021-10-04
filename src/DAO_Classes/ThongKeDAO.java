package DAO_Classes;

import Tool_Classes.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Topic: Interface tổ chức chuẩn đặt tên phương thức cho các lớp DAO
 * Content: Phần mềm quản lý hệ thống đào tạo - WolvesEdu...
            * ...
 * VeketQuaion: 1.0.0
 * Author: Four Wolves >> Văn Hữu Đức - PC01395 >> Trần Thanh Hồ - PC02096 >> Huỳnh Nhật Quang - PC01597 >> Nguyễn Văn Nhựt Trường - PC01752
 * Date: 17th September 2021 >> .. .. 2021
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class ThongKeDAO {
    
    // Phương thức thống kê số lượng người học từng chuyên đề
    public static List<Object[]> tk1() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet ketQua = null;
            try {
                ketQua = JDBCHelper.querySQL("{call sp_ThongKeNguoiHoc2}");
                while (ketQua.next()) {
                    Object[] row = {
                        ketQua.getInt(1),
                        ketQua.getInt(2),
                        ketQua.getDate(3),
                        ketQua.getDate(4)
                    };
                    list.add(row);
                }
            } finally {
                ketQua.getStatement().getConnection().close();
                JDBCHelper.closeConnectSQL();
            }
        } catch (SQLException e) { }
        return list;        
    }
    
    // Phương thức thống kê điểm từng khóa học
    public List<Object[]> tk2(String MaKhoaHoc) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet ketQua = null;
            try {
                ketQua = JDBCHelper.querySQL("{call sp_BangDiem (?)}", MaKhoaHoc);
                while (ketQua.next()) {
                    double diem = ketQua.getDouble("Diem");
                    String xepLoai = "Xuất sắc";
                    if (diem < 0) {
                        xepLoai = "Điểm không hợp lệ";
                    } else if (diem < 3) {
                        xepLoai = "Kém";
                    } else if (diem < 5) {
                        xepLoai = "Yếu";
                    } else if (diem < 6.5) {
                        xepLoai = "Trung bình";
                    } else if (diem < 7.5) {
                        xepLoai = "Khá";
                    } else if (diem < 9) {
                        xepLoai = "Giỏi";
                    }
                    Object[] row = {
                        ketQua.getString("MANGUOIHOC"),
                        ketQua.getString("HoTen"),
                        diem,
                        xepLoai
                    };
                    list.add(row);
                }
            } finally {
                ketQua.getStatement().getConnection().close();
                JDBCHelper.closeConnectSQL();
            }
        } catch (SQLException ex) { }
        return list;
    }    
    
    // Phương thức thống kê điểm từng chuyên đề
    public List<Object[]> tk3() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet ketQua = null;
            try {
                ketQua = JDBCHelper.querySQL("{call sp_ThongKeDiem}");
                while (ketQua.next()) {
                    Object[] row = {
                        ketQua.getString("ChuyenDe"),
                        ketQua.getInt("SoHV"),
                        ketQua.getDouble("ThapNhat"),
                        ketQua.getDouble("CaoNhat"),
                        ketQua.getDouble("TrungBinh")
                    };
                    list.add(row);
                }
            } finally {
                ketQua.getStatement().getConnection().close();
                JDBCHelper.closeConnectSQL();
            }
        } catch (SQLException ex) { }
        return list;
    }
    
    // Phương thức thống kê doanh thu từng chuyên đề
    public List<Object[]> tk4(int Nam) {
        List<Object[]> list = new ArrayList<>();
        
        try {
            ResultSet ketQua = null;
            try {
                String sql = "{call sp_ThongKeDoanhThu (?)}";
                ketQua = JDBCHelper.querySQL("{call sp_ThongKeDoanhThu (?)}", Nam);
                while (ketQua.next()) {
                    Object[] row = {
                        ketQua.getString("ChuyenDe"),
                        ketQua.getInt("SoKH"),
                        ketQua.getInt("SoHV"),
                        ketQua.getDouble("DoanhThu"),
                        ketQua.getDouble("ThapNhat"),
                        ketQua.getDouble("CaoNhat"),
                        ketQua.getDouble("TrungBinh")
                    };
                    list.add(row);
                }
            } finally {
                ketQua.getStatement().getConnection().close();
                JDBCHelper.closeConnectSQL();
            }
        } catch (SQLException e) { }
        return list;
    }
    
    // 
}
