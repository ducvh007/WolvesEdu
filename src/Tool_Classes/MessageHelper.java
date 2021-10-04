package Tool_Classes;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Topic: Interface tổ chức chuẩn đặt tên phương thức cho các lớp DAO
 * Content: Phần mềm quản lý hệ thống đào tạo - WolvesEdu...
            * ...
 * Version: 1.0.0
 * Author: Four Wolves >> Văn Hữu Đức - PC01395 >> Trần Thanh Hồ - PC02096 >> Huỳnh Nhật Quang - PC01597 >> Nguyễn Văn Nhựt Trường - PC01752
 * Date: 17th September 2021 >> .. .. 2021
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class MessageHelper {

    // Phương thức thông báo OK
    public static void alert(Component frame, String thongBao, String tieuDe, String linkAnh){
        ImageIcon anh = new ImageIcon(ImageHelper.anhChuan(new ImageIcon(linkAnh).getImage(), 40, 40));
        JOptionPane.showMessageDialog(frame, thongBao, tieuDe, JOptionPane.PLAIN_MESSAGE, anh);
    }
    
    // Phương thức thông báo xác nhận
    public static boolean confirm(Component frame, String thongBao, String tieuDe, String linkAnh){
        ImageIcon anh = new ImageIcon(ImageHelper.anhChuan(new ImageIcon(linkAnh).getImage(), 40, 40));
        int luaChon = JOptionPane.showConfirmDialog(frame, thongBao, tieuDe, JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, anh);
        return luaChon == JOptionPane.YES_OPTION;
    }
    
    // Phương thức thông báo nhập
    public static String prompt(Component frame, String thongBao, String tieuDe){
        return JOptionPane.showInputDialog(frame, thongBao, tieuDe,JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Phương thức thông báo lỗi
    public static void error(Component frame, String thongBao, String tieuDe){
        JOptionPane.showMessageDialog(frame, thongBao, tieuDe,JOptionPane.ERROR_MESSAGE);
    }
    
    // 
}
