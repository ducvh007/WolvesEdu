package DAO_Classes;

import Entity_Classes.KhoaHoc;
import Tool_Classes.DateHelper;
import Tool_Classes.JDBCHelper;
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

public class KhoaHocDAO implements WolvesEduDAO<KhoaHoc, String>{
    @Override
    public List<KhoaHoc> selectAll() {
        // List tạm
        List<KhoaHoc> list = new ArrayList<>();
        
        // Nhận đối tượng đầu tiên của list
        list = selectBySQL("select * from KhoaHoc");
        
        return list; 
    }

    @Override
    public KhoaHoc selectById(String ma) {
        // List tạm
        List<KhoaHoc> list = new ArrayList<>();
        
        // Nhận đối tượng đầu tiên của list
        list = selectBySQL("select * from KhoaHoc where id = ?", ma);
        
        return list.get(0);
    }

    @Override
    public List<KhoaHoc> selectBySQL(String sql, Object... thamSo) {
        // List tạm
        List<KhoaHoc> list = new ArrayList<>();
        
        try {
            ResultSet ketQua = null;
            try {
                ketQua = JDBCHelper.querySQL(sql, thamSo);
                
                // Trả kết quả
                while (ketQua.next()) {
                    // Đối tượng chuyên đề
                    KhoaHoc doiTuong = new KhoaHoc(ketQua.getString(1), ketQua.getString(2), ketQua.getFloat(3), ketQua.getInt(4), DateHelper.toString(ketQua.getDate(5), ""), ketQua.getString(6), DateHelper.toString(ketQua.getDate(7), ""), ketQua.getString(8));
                    
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
    public void insert(KhoaHoc moi) {
        String sql = "INSERT INTO KhoaHoc(MAKHOAHOC, MACHUYENDE, HOCPHI, THOILUONG, NGAYKHAIGIANG, NGUOITAO, NGAYTAO, GHICHU) VALUES (?,?,?,?,?,?,?,?)";
        JDBCHelper.updateSQL(sql, moi.getMaKhoaHoc(), moi.getMaChuyenDe(), moi.getHocPhi(), moi.getThoiLuong(), moi.getNgayKhaiGiang(), moi.getNguoiTao(), moi.getNguoiTao(), moi.getGhiChu());
    }

    @Override
    public void update(KhoaHoc capNhat, String ma) {
        String sql = "UPDATE KHOAHOC SET MaChuyenDe = ?, Hocphi = ?, Thoiluong = ?, NgayKhaiGiang = ?, GhiChu = ?, NguoiTao = ?, NgayTao = ? WHERE MaKhoaHoc = ?";
        JDBCHelper.updateSQL(sql, capNhat.getMaChuyenDe(), capNhat.getHocPhi(), capNhat.getThoiLuong(), capNhat.getNgayKhaiGiang(), capNhat.getGhiChu(), capNhat.getNguoiTao(), capNhat.getNgayTao(),capNhat.getMaKhoaHoc());
    }

    @Override
    public void delete(String ma) {
        String sql = "delete from KhoaHoc where makhoahoc = ?";
        JDBCHelper.updateSQL(sql, ma);
    }
}
