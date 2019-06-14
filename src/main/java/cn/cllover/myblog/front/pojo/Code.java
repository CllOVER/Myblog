package cn.cllover.myblog.front.pojo;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`myblog_code`")
public class Code implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "code_id")
    private Long codeId;

    @Column(name = "code_right_code")
    private String codeRightCode;

    @Column(name = "code_address_ip")
    private String codeAddressIp;

    @Column(name = "code_date")
    private Date codeDate;

    public Long getCodeId() {
        return codeId;
    }

    public void setCodeId(Long codeId) {
        this.codeId = codeId;
    }

    public String getCodeRightCode() {
        return codeRightCode;
    }

    public void setCodeRightCode(String codeRightCode) {
        this.codeRightCode = codeRightCode;
    }

    public String getCodeAddressIp() {
        return codeAddressIp;
    }

    public void setCodeAddressIp(String codeAddressIp) {
        this.codeAddressIp = codeAddressIp;
    }

    public Date getCodeDate() {
        return codeDate;
    }

    public void setCodeDate(Date codeDate) {
        this.codeDate = codeDate;
    }

    @Override
    public String toString() {
        return "Code{" +
                "codeId=" + codeId +
                ", codeRightCode='" + codeRightCode + '\'' +
                ", codeAddressIp='" + codeAddressIp + '\'' +
                ", codeDate=" + codeDate +
                '}';
    }
}