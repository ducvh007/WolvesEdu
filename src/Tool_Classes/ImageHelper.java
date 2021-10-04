package Tool_Classes;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Topic: Interface tổ chức chuẩn đặt tên phương thức cho các lớp DAO
 * Content: Phần mềm quản lý hệ thống đào tạo - WolvesEdu...
            * ...
 * Version: 1.0.0
 * Author: Four Wolves >> Văn Hữu Đức - PC01395 >> Trần Thanh Hồ - PC02096 >> Huỳnh Nhật Quang - PC01597 >> Nguyễn Văn Nhựt Trường - PC01752
 * Date: 17th September 2021 >> .. .. 2021
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class ImageHelper {
    
    // Phương thức đưa ảnh về kích thước mong muốn
    public static Image anhChuan(Image anhVao, int dai, int cao) {
        Image anhRa = new ImageIcon(new ImageIcon(anhVao).getImage().getScaledInstance(dai, cao, Image.SCALE_SMOOTH)).getImage();
        return anhRa;
    }
    
    // Phương thức chuyển kiểu ảnh thành byte[]
    public static byte[] imageToByte(String linkAnh) {
        try {
            FileInputStream fis = new FileInputStream(new File(linkAnh));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte [] buffer = new byte[1024];
            
            int checkByte;
            while((checkByte = fis.read(buffer)) !=-1) {
                bos.write(buffer, 0, checkByte);
            }
            bos.close();
            fis.close();
            return bos.toByteArray();            
        } catch (Exception e) { }
        return null;
    }
    
    // Phương thức chuyển byte[] thành kiểu ảnh
    public static Image byteToImage(byte[] anhByte) {
        try {
            Image anh = new ImageIcon(anhByte).getImage();
            return anh;
        } catch (Exception e) { }
        return null;
    }
    
    // 
}
