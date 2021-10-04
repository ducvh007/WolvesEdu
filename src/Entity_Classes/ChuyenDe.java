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
public class ChuyenDe implements Serializable {

    // 
    private String maChuyenDe;
    private String tenChuyenDe;
    private float hocPhi;
    private int thoiLuong;
    private Image anh;
    private String moTa;

    // 
    public ChuyenDe() {
    }

    public ChuyenDe(String maChuyenDe, String tenChuyenDe, float hocPhi, int thoiLuong, Image anh, String moTa) {
        this.maChuyenDe = maChuyenDe;
        this.tenChuyenDe = tenChuyenDe;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.anh = anh;
        this.moTa = moTa;
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
     * @return the tenChuyenDe
     */
    public String getTenChuyenDe() {
        return tenChuyenDe;
    }

    /**
     * @param tenChuyenDe the tenChuyenDe to set
     */
    public void setTenChuyenDe(String tenChuyenDe) {
        this.tenChuyenDe = tenChuyenDe;
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
     * @return the moTa
     */
    public String getMoTa() {
        return moTa;
    }

    /**
     * @param moTa the moTa to set
     */
    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
}
