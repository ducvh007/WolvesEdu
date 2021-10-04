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

public class HocVien implements Serializable {
    
    private String maNguoiHoc;
    private String maKhoaHoc;
    private float diemTB;

    public HocVien() {
    }

    public HocVien(String maNguoiHoc, String maKhoaHoc, float diemTB) {
        this.maNguoiHoc = maNguoiHoc;
        this.maKhoaHoc = maKhoaHoc;
        this.diemTB = diemTB;
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
     * @return the diemTB
     */
    public float getDiemTB() {
        return diemTB;
    }

    /**
     * @param diemTB the diemTB to set
     */
    public void setDiemTB(float diemTB) {
        this.diemTB = diemTB;
    }
    
}
