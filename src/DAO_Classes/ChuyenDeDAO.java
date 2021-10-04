package DAO_Classes;

import Entity_Classes.ChuyenDe;
import Tool_Classes.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Topic: Interface tổ chức chuẩn đặt tên phương thức cho các lớp DAO
 * Content: Phần mềm quản lý hệ thống đào tạo - WolvesEdu...
            * ...
 * Version: 1.0.0
 * Author: Four Wolves >> Văn Hữu Đức - PC01395 >> Trần Thanh Hồ - PC02096 >> Huỳnh Nhật Quang - PC01597 >> Nguyễn Văn Nhựt Trường - PC01752
 * Date: 17th September 2021 >> .. .. 2021
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class ChuyenDeDAO implements WolvesEduDAO<ChuyenDe, String>{

    @Override
    public List<ChuyenDe> selectAll() {
        // List tạm
        List<ChuyenDe> list = new ArrayList<>();
        
        // Nhận đối tượng đầu tiên của list
        list = selectBySQL("select * from chuyende");
        
        return list; 
    }

    @Override
    public ChuyenDe selectById(String ma) {
        // List tạm
        List<ChuyenDe> list = new ArrayList<>();
        
        // Nhận đối tượng đầu tiên của list
        list = selectBySQL("select * from chuyende where id = ?", ma);
        
        return list.get(0);
    }

    @Override
    public List<ChuyenDe> selectBySQL(String sql, Object... thamSo) {
        // List tạm
        List<ChuyenDe> list = new ArrayList<>();
        
        try {
            ResultSet ketQua = null;
            try {
                ketQua = JDBCHelper.querySQL(sql, thamSo);
                
                // Trả kết quả
                while (ketQua.next()) {
                    // Đối tượng chuyên đề
                    ChuyenDe doiTuong = new ChuyenDe(ketQua.getString(1), ketQua.getString(2), ketQua.getFloat(3), ketQua.getInt(4), ImageHelper.byteToImage(ketQua.getBytes(5)), ketQua.getString(6));
                    
                    // Thêm vào list tạm
                    list.add(doiTuong);
                }
            } finally {
                ketQua.getStatement().getConnection().close();
                JDBCHelper.closeConnectSQL();
            }
        } catch (SQLException e) { }
        
        return list; 
    }

    @Override
    public void insert(ChuyenDe doiTuongMoi) {
        String sql = "INSERT INTO CHUYENDE(MACHUYENDE, TENCHUYENDE, HOCPHI, THOILUONG, HINH , MOTA) VALUES (?,?,?,?,?,?)";
        JDBCHelper.updateSQL(sql, doiTuongMoi.getMaChuyenDe(), doiTuongMoi.getTenChuyenDe(), doiTuongMoi.getHocPhi(), doiTuongMoi.getThoiLuong(), doiTuongMoi.getAnh(), doiTuongMoi.getMoTa());
    }

    @Override
    public void update(ChuyenDe doiTuongCapNhat, String ma) {
        String sql = "UPDATE CHUYENDE SET TENCHUYENDE = ? , HOCPHI = ?, THOILUONG = ?, HINH = ?, MOTA = ? WHERE MACHUYENDE = ?";
        JDBCHelper.updateSQL(sql, doiTuongCapNhat.getTenChuyenDe(), doiTuongCapNhat.getHocPhi(), doiTuongCapNhat.getThoiLuong(), doiTuongCapNhat.getAnh(), doiTuongCapNhat.getMoTa(), doiTuongCapNhat.getMaChuyenDe());
    }

    @Override
    public void delete(String ma) {
        String sql = "delete from chuyende where machuyende = ?";
        JDBCHelper.updateSQL(sql, ma);
    }

}
