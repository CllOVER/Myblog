package cn.cllover.myblog.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    private Date date;

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
