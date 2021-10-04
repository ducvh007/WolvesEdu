package Entity_Classes;

import java.io.Serializable;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Topic: Interface tổ chức chuẩn đặt tên phương thức cho các lớp DAO
 * Content: Phần mềm quản lý hệ thống đào tạo - WolvesEdu...
            * ...
 * Version: 1.0.0
 * Author: Four Wolves >> Văn Hữu Đức - PC01395 >> Trần Thanh Hồ - PC02096 >> Huỳnh Nhật Quang - PC01597 >> Nguyễn Văn Nhựt Trường - PC01752
 * Date: 17th September 2021 >> .. .. 2021
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class KhoaHoc implements Serializable {
    
    // 
    private String maKhoaHoc;
    private String maChuyenDe;
    private float hocPhi;
    private int thoiLuong;
    private String ngayKhaiGiang;
    private String nguoiTao;
    private String ngayTao;
    private String ghiChu;
    // 

    public KhoaHoc() {
    }
    
    public KhoaHoc(String maKhoaHoc, String maChuyenDe, float hocPhi, int thoiLuong, String ngayKhaiGiang, String nguoiTao, String ngayTao, String ghiChu) {
        this.maKhoaHoc = maKhoaHoc;
        this.maChuyenDe = maChuyenDe;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.ngayKhaiGiang = ngayKhaiGiang;
        this.nguoiTao = nguoiTao;
        this.ngayTao = ngayTao;
        this.ghiChu = ghiChu;
    }

    /**
     * @return the maKhoaHoc
     */
    public String getMaKhoaHoc() {
        return maKhoaHoc;
    }

    /**
     * @param maKhoaHoc the maKhoaHoc to set
     */
    public void setMaKhoaHoc(String maKhoaHoc) {
        this.maKhoaHoc = maKhoaHoc;
    }

    /**
     * @return the maChuyenDe
     */
    public String getMaChuyenDe() {
        return maChuyenDe;
    }

    /**
     * @param maChuyenDe the maChuyenDe to set
     */
    public void setMaChuyenDe(String maChuyenDe) {
        this.maChuyenDe = maChuyenDe;
    }

    /**
     * @return the hocPhi
     */
    public float getHocPhi() {
        return hocPhi;
    }

    /**
     * @param hocPhi the hocPhi to set
     */
    public void setHocPhi(float hocPhi) {
        this.hocPhi = hocPhi;
    }

    /**
     * @return the thoiLuong
     */
    public int getThoiLuong() {
        return thoiLuong;
    }

    /**
     * @param thoiLuong the thoiLuong to set
     */
    public void setThoiLuong(int thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    /**
     * @return the ngayKhaiGiang
     */
    public String getNgayKhaiGiang() {
        return ngayKhaiGiang;
    }

    /**
     * @param ngayKhaiGiang the ngayKhaiGiang to set
     */
    public void setNgayKhaiGiang(String ngayKhaiGiang) {
        this.ngayKhaiGiang = ngayKhaiGiang;
    }

    /**
     * @return the nguoiTao
     */
    public String getNguoiTao() {
        return nguoiTao;
    }

    /**
     * @param nguoiTao the nguoiTao to set
     */
    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    /**
     * @return the ngayTao
     */
    public String getNgayTao() {
        return ngayTao;
    }

    /**
     * @param ngayTao the ngayTao to set
     */
    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    /**
     * @return the ghiChu
     */
    public String getGhiChu() {
        return ghiChu;
    }

    /**
     * @param ghiChu the ghiChu to set
     */
    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
