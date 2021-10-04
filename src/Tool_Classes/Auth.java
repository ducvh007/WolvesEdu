package Tool_Classes;

import Entity_Classes.NhanVien;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Topic: Interface tổ chức chuẩn đặt tên phương thức cho các lớp DAO
 * Content: Phần mềm quản lý hệ thống đào tạo - WolvesEdu...
            * ...
 * Version: 1.0.0
 * Author: Four Wolves >> Văn Hữu Đức - PC01395 >> Trần Thanh Hồ - PC02096 >> Huỳnh Nhật Quang - PC01597 >> Nguyễn Văn Nhựt Trường - PC01752
 * Date: 17th September 2021 >> .. .. 2021
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class Auth {
    
    // Đối tượng user thuộc lớp NhanVien
    public static NhanVien user = null;
    
    // Phương thức xác định có đang đăng nhập hay không?: hàm trong hàm
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    // Xóa dữ liệu của user
    public static void clear(){
        Auth.user = null;
    }
    
    // Phương thức xác định có phải chức vụ "Trưởng phòng" hay không?
    public static boolean isManager(){
        return Auth.isLogin() && user.getChucVu().equalsIgnoreCase("Trưởng phòng");
    }
    
    // 
}
