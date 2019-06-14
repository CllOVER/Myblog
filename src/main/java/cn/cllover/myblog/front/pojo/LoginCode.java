package cn.cllover.myblog.front.pojo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`myblog_login_code`")
public class LoginCode implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "login_code_id")
    private Long loginCodeId;

    @Column(name = "login_code_username")
    private String loginCodeUsername;

    @Column(name = "login_code_rightcode")
    private String loginCodeRightcode;

    @Column(name = "login_code_trycode")
    private String loginCodeTrycode;

    @Column(name = "login_ip")
    private String loginIp;

    @Column(name = "login_date")
    private Date loginDate;

    public Long getLoginCodeId() {
        return loginCodeId;
    }

    public void setLoginCodeId(Long loginCodeId) {
        this.loginCodeId = loginCodeId;
    }

    public String getLoginCodeUsername() {
        return loginCodeUsername;
    }

    public void setLoginCodeUsername(String loginCodeUsername) {
        this.loginCodeUsername = loginCodeUsername;
    }

    public String getLoginCodeRightcode() {
        return loginCodeRightcode;
    }

    public void setLoginCodeRightcode(String loginCodeRightcode) {
        this.loginCodeRightcode = loginCodeRightcode;
    }

    public String getLoginCodeTrycode() {
        return loginCodeTrycode;
    }

    public void setLoginCodeTrycode(String loginCodeTrycode) {
        this.loginCodeTrycode = loginCodeTrycode;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Override
    public String toString() {
        return "LoginCode{" +
                "loginCodeId=" + loginCodeId +
                ", loginCodeUsername='" + loginCodeUsername + '\'' +
                ", loginCodeRightcode='" + loginCodeRightcode + '\'' +
                ", loginCodeTrycode='" + loginCodeTrycode + '\'' +
                ", loginIp='" + loginIp + '\'' +
                ", loginDate=" + loginDate +
                '}';
    }
}