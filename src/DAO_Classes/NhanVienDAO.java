package DAO_Classes;

import Entity_Classes.NhanVien;
import Entity_Classes.NhanVien;
import Tool_Classes.DateHelper;
import Tool_Classes.ImageHelper;
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

public class NhanVienDAO implements WolvesEduDAO<NhanVien, String>{
    
    @Override
    public List<NhanVien> selectAll() {
        // List tạm
        List<NhanVien> list = new ArrayList<>();
        
        // Nhận đối tượng đầu tiên của list
        list = selectBySQL("select * from NhanVien");
        
        return list; 
    }

    @Override
    public NhanVien selectById(String ma) {
        // List tạm
        List<NhanVien> list = new ArrayList<>();
        
        // Nhận đối tượng đầu tiên của list
        list = selectBySQL("select * from NhanVien where id = ?", ma);
        
        return list.get(0);
    }

    @Override
    public List<NhanVien> selectBySQL(String sql, Object... thamSo) {
        // List tạm
        List<NhanVien> list = new ArrayList<>();
        
        try {
            ResultSet ketQua = null;
            try {
                ketQua = JDBCHelper.querySQL(sql, thamSo);
                
                // Trả kết quả
                while (ketQua.next()) {
                    // Đối tượng chuyên đề
                    NhanVien doiTuong = new NhanVien(ketQua.getString(1), ketQua.getString(2), ketQua.getString(3), DateHelper.toString(ketQua.getDate(5), ""), ketQua.getString(5), ketQua.getString(6), ketQua.getString(7), ImageHelper.byteToImage(ketQua.getBytes(8)), ketQua.getString(9), ketQua.getString(10), ketQua.getString(11));
                    
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
    public void insert(NhanVien doiTuongMoi) {
        String sql = "INSERT INTO NhanVien(MANHANVIEN, HOTEN, GIOITINH, NGAYSINH, SDT, EMAIL, DIACHI,ANH, CCCD, CHUCVU, MATKHAU) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        JDBCHelper.updateSQL(sql, doiTuongMoi.getMaNhanVien(), doiTuongMoi.getHoTen(), doiTuongMoi.getGioiTinh(), doiTuongMoi.getNgaySinh(), doiTuongMoi.getSdt(), doiTuongMoi.getEmail(), doiTuongMoi.getDiaChi(), doiTuongMoi.getAnh(), doiTuongMoi.getCCCD(), doiTuongMoi.getChucVu(), doiTuongMoi.getMatKhau());
    }

    @Override
    public void update(NhanVien doiTuongCapNhat, String ma) {
        String sql = "UPDATE NhanVien SET HOTEN = ?, GIOITINH = ?, NGAYSINH = ?, SDT = ?, EMAIL = ?, DIACHI = ?, ANH = ?, CCCD= ?, CHUCVU = ?, MATKHAU = ? WHERE MANHANVIEN = ?";
        JDBCHelper.updateSQL(sql, doiTuongCapNhat.getHoTen(), doiTuongCapNhat.getGioiTinh(), doiTuongCapNhat.getNgaySinh(), doiTuongCapNhat.getSdt(), doiTuongCapNhat.getEmail(), doiTuongCapNhat.getDiaChi(), doiTuongCapNhat.getAnh(), doiTuongCapNhat.getAnh(), doiTuongCapNhat.getCCCD(), doiTuongCapNhat.getChucVu(), doiTuongCapNhat.getMatKhau(), doiTuongCapNhat.getMaNhanVien());
    }

    @Override
    public void delete(String ma) {
        String sql = "delete from NhanVien where maNhanVien = ?";
        JDBCHelper.updateSQL(sql, ma);
    }

}
