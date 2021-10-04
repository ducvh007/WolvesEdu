package Entity_Classes;

import java.awt.Image;
import java.io.Serializable;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Topic: Interface tổ chức chuẩn đặt tên phương thức cho các lớp DAO
 * Content: Phần mềm quản lý hệ thống đào tạo - WolvesEdu...
            * ...
 * Version: 1.0.0
 * Author: Four Wolves >> Văn Hữu Đức - PC01395 >> Trần Thanh Hồ - PC02096 >> Huỳnh Nhật Quang - PC01597 >> Nguyễn Văn Nhựt Trường - PC01752
 * Date: 17th September 2021 >> .. .. 2021
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class NguoiHoc implements Serializable {
    private String maNguoiHoc;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinh;
    private String sdt;
    private String email;
    private String diaChi;
    private Image anh;
    private String ghiChu;
    private String nguoiTao;
    private String ngayDangKy;

    public NguoiHoc() {
    }

    public NguoiHoc(String maNguoiHoc, String hoTen, String gioiTinh, String ngaySinh, String sdt, String email, String diaChi, Image anh, String ghiChu, String nguoiTao, String ngayDangKy) {
        this.maNguoiHoc = maNguoiHoc;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.anh = anh;
        this.ghiChu = ghiChu;
        this.nguoiTao = nguoiTao;
        this.ngayDangKy = ngayDangKy;
    }

    /**
     * @return the maNguoiHoc
     */
    public String getMaNguoiHoc() {
        return maNguoiHoc;
    }

    /**
     * @param maNguoiHoc the maNguoiHoc to set
     */
    public void setMaNguoiHoc(String maNguoiHoc) {
        this.maNguoiHoc = maNguoiHoc;
    }

    /**
     * @return the hoTen
     */
    public String getHoTen() {
        return hoTen;
    }

    /**
     * @param hoTen the hoTen to set
     */
    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    /**
     * @return the gioiTinh
     */
    public String getGioiTinh() {
        return gioiTinh;
    }

    /**
     * @param gioiTinh the gioiTinh to set
     */
    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    /**
     * @return the ngaySinh
     */
    public String getNgaySinh() {
        return ngaySinh;
    }

    /**
     * @param ngaySinh the ngaySinh to set
     */
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    /**
     * @return the sdt
     */
    public String getSdt() {
        return sdt;
    }

    /**
     * @param sdt the sdt to set
     */
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the diaChi
     */
    public String getDiaChi() {
        return diaChi;
    }

    /**
     * @param diaChi the diaChi to set
     */
    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    /**
     * @return the anh
     */
    public Image getAnh() {
        return anh;
    }

    /**
     * @param anh the anh to set
     */
    public void setAnh(Image anh) {
        this.anh = anh;
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
     * @return the ngayDangKy
     */
    public String getNgayDangKy() {
        return ngayDangKy;
    }

    /**
     * @param ngayDangKy the ngayDangKy to set
     */
    public void setNgayDangKy(String ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }
    
 
}
