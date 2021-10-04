package DAO_Classes;

import java.util.List;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Topic: Interface tổ chức chuẩn đặt tên phương thức cho các lớp DAO
 * Content: Phần mềm quản lý hệ thống đào tạo - WolvesEdu...
            * ...
 * Version: 1.0.0
 * Author: Four Wolves >> Văn Hữu Đức - PC01395 >> Trần Thanh Hồ - PC02096 >> Huỳnh Nhật Quang - PC01597 >> Nguyễn Văn Nhựt Trường - PC01752
 * Date: 17th September 2021 >> .. .. 2021
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public interface WolvesEduDAO <loaiThucThe, kieuMa>{
    
    // Tên chuẩn cho phương thức select * ...
    public List<loaiThucThe> selectAll();
    
    // Tên chuẩn cho phương thức select ... where ... = ma
    public loaiThucThe selectById(kieuMa ma);
    
    // Tên chuẩn cho phương thức select ... where ... = key1, ..., ... = keyn
    List<loaiThucThe> selectBySQL(String sql, Object...thamSo);
    
    // Tên chuẩn cho phương thức insert ...
    public void insert(loaiThucThe doiTuongMoi);
    
    // Tên chuẩn cho phương thức insert ...
    public void insert(loaiThucThe doiTuongMoi, String linkAnh);
    
    // Tên chuẩn cho phương thức update ...
    public void update(loaiThucThe doiTuongCapNhat, kieuMa ma);
    
    // Tên chuẩn cho phương thức update ...
    public void update(loaiThucThe doiTuongCapNhat, kieuMa ma, String linkAnh);
    
    // Tên chuẩn cho phương thức delete ...
    public void delete(kieuMa ma);
    
    // 
}
