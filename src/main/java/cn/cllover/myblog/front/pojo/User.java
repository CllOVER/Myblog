package cn.cllover.myblog.front.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "myblog_user")
public class User implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_usname")
    private String userUsname;

    @Column(name = "user_pass")
    private String userPass;

    @Column(name = "user_phone")
    private Integer userPhone;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_qq")
    private Long userQq;

    @Column(name = "user_age")
    private Integer userAge;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_sex")
    private String userSex;

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "user_birthday")
    private Date userBirthday;

    @Column(name = "user_address")
    private String userAddress;

    @Column(name = "user_photo")
    private String userPhoto;

    @Column(name = "user_status")
    private Integer userStatus;

    @Column(name = "user_desc")
    private String userDesc;

    @Column(name = "user_register_date")
    private Date userRegisterDate;

    @Column(name = "user_register_ip")
    private String userRegisterIp;

    @Column(name = "user_frozen")
    private Integer userFrozen;

    @Column(name = "user_art_id")
    private Long userArtId;

    public Long getUserArtId() {
        return userArtId;
    }

    public void setUserArtId(Long userArtId) {
        this.userArtId = userArtId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserUsname() {
        return userUsname;
    }

    public void setUserUsname(String userUsname) {
        this.userUsname = userUsname;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Long getUserQq() {
        return userQq;
    }

    public void setUserQq(Long userQq) {
        this.userQq = userQq;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc;
    }

    public Date getUserRegisterDate() {
        return userRegisterDate;
    }

    public void setUserRegisterDate(Date userRegisterDate) {
        this.userRegisterDate = userRegisterDate;
    }

    public String getUserRegisterIp() {
        return userRegisterIp;
    }

    public void setUserRegisterIp(String userRegisterIp) {
        this.userRegisterIp = userRegisterIp;
    }

    public Integer getUserFrozen() {
        return userFrozen;
    }

    public void setUserFrozen(Integer userFrozen) {
        this.userFrozen = userFrozen;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userUsname='" + userUsname + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userPhone=" + userPhone +
                ", userEmail='" + userEmail + '\'' +
                ", userQq=" + userQq +
                ", userAge=" + userAge +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userBirthday=" + userBirthday +
                ", userAddress='" + userAddress + '\'' +
                ", userPhoto='" + userPhoto + '\'' +
                ", userStatus=" + userStatus +
                ", userDesc='" + userDesc + '\'' +
                ", userRegisterDate=" + userRegisterDate +
                ", userRegisterIp='" + userRegisterIp + '\'' +
                ", userFrozen=" + userFrozen +
                '}';
    }
}