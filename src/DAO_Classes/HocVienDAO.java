package DAO_Classes;

import Entity_Classes.HocVien;
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
public class HocVienDAO implements WolvesEduDAO<HocVien, String> {

    @Override
    public List<HocVien> selectAll() {
        // List tạm
        List<HocVien> list = new ArrayList<>();

        // Nhận đối tượng đầu tiên của list
        list = selectBySQL("select * from HocVien");

        return list;
    }

    @Override
    public HocVien selectById(String ma) {
        // List tạm
        List<HocVien> list = new ArrayList<>();

        // Nhận đối tượng đầu tiên của list
        list = selectBySQL("select * from HocVien where id = ?", ma);

        return list.get(0);
    }

    @Override
    public List<HocVien> selectBySQL(String sql, Object... thamSo) {
        // List tạm
        List<HocVien> list = new ArrayList<>();

        try {
            ResultSet ketQua = null;
            try {
                ketQua = JDBCHelper.querySQL(sql, thamSo);

                // Trả kết quả
                while (ketQua.next()) {
                    // Đối tượng chuyên đề
                    HocVien doiTuong = new HocVien(ketQua.getString(1), ketQua.getString(2), ketQua.getFloat(3));

                    // Thêm vào list tạm
                    list.add(doiTuong);
                }
            } finally {
                ketQua.getStatement().getConnection().close();
                JDBCHelper.closeConnectSQL();
            }
        } catch (SQLException e) {
        }

        return list;
    }

    @Override
    public void insert(HocVien doiTuongMoi) {
        String sql = "INSERT INTO HocVien(MANGUOIHOC, MAKHOAHOC, DIEMTB) VALUES (?,?,?)";
        JDBCHelper.updateSQL(sql, doiTuongMoi.getMaNguoiHoc(), doiTuongMoi.getMaKhoaHoc(), doiTuongMoi.getDiemTB());
    }

    @Override
    public void update(HocVien doiTuongCapNhat, String ma) {
        String sql = "UPDATE HocVien SET MAKHOAHOC = ? , DIEMTB = ? WHERE MANGUOIHOC = ?";
        JDBCHelper.updateSQL(sql, doiTuongCapNhat.getMaKhoaHoc(), doiTuongCapNhat.getDiemTB(), doiTuongCapNhat.getMaNguoiHoc());
    }

    @Override
    public void delete(String ma) {
        String sql = "delete from HocVien where maNguoiHoc = ?";
        JDBCHelper.updateSQL(sql, ma);
    }

}
