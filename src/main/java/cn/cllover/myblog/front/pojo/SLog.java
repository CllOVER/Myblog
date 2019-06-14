package cn.cllover.myblog.front.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`myblog_log`")
public class SLog implements Serializable {
    private Long logId;

    private Long logUserId;

    private String logDesc;

    private String logParams;

    private long logTime;

    private String logIp;

    private Date logDate;

    private String logMethod;

    private String logClass;

    private String logUrl;

    public String getLogUrl() {
        return logUrl;
    }

    public void setLogUrl(String logUrl) {
        this.logUrl = logUrl;
    }

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getLogUserId() {
        return logUserId;
    }

    public void setLogUserId(Long logUserId) {
        this.logUserId = logUserId;
    }

    public String getLogDesc() {
        return logDesc;
    }

    public void setLogDesc(String logDesc) {
        this.logDesc = logDesc;
    }

    public String getLogParams() {
        return logParams;
    }

    public void setLogParams(String logParams) {
        this.logParams = logParams;
    }

    public long getLogTime() {
        return logTime;
    }

    public void setLogTime(long logTime) {
        this.logTime = logTime;
    }

    public String getLogIp() {
        return logIp;
    }

    public void setLogIp(String logIp) {
        this.logIp = logIp;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getLogMethod() {
        return logMethod;
    }

    public void setLogMethod(String logMethod) {
        this.logMethod = logMethod;
    }

    public String getLogClass() {
        return logClass;
    }

    public void setLogClass(String logClass) {
        this.logClass = logClass;
    }


}