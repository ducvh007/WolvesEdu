package DAO_Classes;

import Entity_Classes.NguoiHoc;
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

public class NguoiHocDAO implements WolvesEduDAO<NguoiHoc, String>{
    
    @Override
    public List<NguoiHoc> selectAll() {
        // List tạm
        List<NguoiHoc> list = new ArrayList<>();
        
        // Nhận đối tượng đầu tiên của list
        list = selectBySQL("select * from NguoiHoc");
        
        return list; 
    }

    @Override
    public NguoiHoc selectById(String ma) {
        // List tạm
        List<NguoiHoc> list = new ArrayList<>();
        
        // Nhận đối tượng đầu tiên của list
        list = selectBySQL("select * from NguoiHoc where id = ?", ma);
        
        return list.get(0);
    }

    @Override
    public List<NguoiHoc> selectBySQL(String sql, Object... thamSo) {
        // List tạm
        List<NguoiHoc> list = new ArrayList<>();
        
        try {
            ResultSet ketQua = null;
            try {
                ketQua = JDBCHelper.querySQL(sql, thamSo);
                
                // Trả kết quả
                while (ketQua.next()) {
                    // Đối tượng chuyên đề
                    NguoiHoc doiTuong = new NguoiHoc(ketQua.getString(1), ketQua.getString(2), ketQua.getString(3), DateHelper.toString(ketQua.getDate(4), ""), ketQua.getString(5), ketQua.getString(6), ketQua.getString(7), ImageHelper.byteToImage(ketQua.getBytes(8)), ketQua.getString(9), ketQua.getString(10), DateHelper.toString(ketQua.getDate(11), ""));
                    
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
    public void insert(NguoiHoc doiTuongMoi) {
        String sql = "INSERT INTO NguoiHoc(MANGUOIHOC, HOTEN, GIOITINH, NGAYSINH, SDT, EMAIL, DIACHI, ANH, GHICHU, NGUOITAO, NGAYDANGKY) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        JDBCHelper.updateSQL(sql, doiTuongMoi.getMaNguoiHoc(), doiTuongMoi.getHoTen(), doiTuongMoi.getGioiTinh(), doiTuongMoi.getNgaySinh(), doiTuongMoi.getSdt(), doiTuongMoi.getEmail(), doiTuongMoi.getDiaChi(), doiTuongMoi.getAnh(), doiTuongMoi.getGhiChu(), doiTuongMoi.getNguoiTao(), doiTuongMoi.getNgayDangKy());
    }

    @Override
    public void update(NguoiHoc doiTuongCapNhat, String ma) {
        String sql = "UPDATE NguoiHoc SET HOTEN = ?, GIOITINH = ?, NGAYSINH = ?, SDT = ?, EMAIL = ?, DIACHI = ?, ANH = ?, GHICHU= ?, NGUOITAO = ?, NGAYDANGKY = ?  WHERE MANGUOIHOC = ?";
        JDBCHelper.updateSQL(sql, doiTuongCapNhat.getHoTen(), doiTuongCapNhat.getGioiTinh(), doiTuongCapNhat.getNgaySinh(), doiTuongCapNhat.getSdt(), doiTuongCapNhat.getEmail(), doiTuongCapNhat.getDiaChi(), doiTuongCapNhat.getAnh(), doiTuongCapNhat.getGhiChu(), doiTuongCapNhat.getNguoiTao(), doiTuongCapNhat.getNgayDangKy(), doiTuongCapNhat.getMaNguoiHoc());
    }

    @Override
    public void delete(String ma) {
        String sql = "delete from NguoiHoc where maNguoiHoc = ?";
        JDBCHelper.updateSQL(sql, ma);
    }

}
