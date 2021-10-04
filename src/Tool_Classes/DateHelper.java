package Tool_Classes;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Topic: Interface tổ chức chuẩn đặt tên phương thức cho các lớp DAO
 * Content: Phần mềm quản lý hệ thống đào tạo - WolvesEdu...
            * ...
 * Version: 1.0.0
 * Author: Four Wolves >> Văn Hữu Đức - PC01395 >> Trần Thanh Hồ - PC02096 >> Huỳnh Nhật Quang - PC01597 >> Nguyễn Văn Nhựt Trường - PC01752
 * Date: 17th September 2021 >> .. .. 2021
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

public class DateHelper {
    
    // Phương thức chuyển chuỗi thành ngày
    public static Date toDate(String ngayJava, String kieu) {
        try {
            DateFormat kieuNgay = new SimpleDateFormat(kieu);
            return kieuNgay.parse(ngayJava);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    
    // Phương thức chuyển ngày thành chuỗi
    public static String toString(Date ngaySQL, String kieu) { // Date sang chuoi
        DateFormat kieuNgay = new SimpleDateFormat(kieu);
        return kieuNgay.format(ngaySQL);
    }

    // Phương thức tăng hoặc giảm ngày SQL
    public static Date addDays(Date ngaySQL, int ngayThem) {
        ngaySQL.setTime(ngaySQL.getTime() + ngayThem * 24 * 60 * 60 * 1000);
        return ngaySQL;
    }
    
    // 
}
