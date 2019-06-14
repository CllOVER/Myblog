package cn.cllover.myblog.front.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`myblog_comment`")
public class Comment {
    private Long comId;

    private Long comUserId;

    private String comContent;

    private Long comLike;

    private Long comArtId;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date comDate;

    private Integer comStatus;

    private String comIp;

    private CommentReply reply;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CommentReply getReply() {
        return reply;
    }

    public void setReply(CommentReply reply) {
        this.reply = reply;
    }

    public Long getComId() {
        return comId;
    }

    public void setComId(Long comId) {
        this.comId = comId;
    }

    public Long getComUserId() {
        return comUserId;
    }

    public void setComUserId(Long comUserId) {
        this.comUserId = comUserId;
    }

    public String getComContent() {
        return comContent;
    }

    public void setComContent(String comContent) {
        this.comContent = comContent;
    }

    public Long getComLike() {
        return comLike;
    }

    public void setComLike(Long comLike) {
        this.comLike = comLike;
    }

    public Long getComArtId() {
        return comArtId;
    }

    public void setComArtId(Long comArtId) {
        this.comArtId = comArtId;
    }

    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public Integer getComStatus() {
        return comStatus;
    }

    public void setComStatus(Integer comStatus) {
        this.comStatus = comStatus;
    }

    public String getComIp() {
        return comIp;
    }

    public void setComIp(String comIp) {
        this.comIp = comIp;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "comId=" + comId +
                ", comUserId=" + comUserId +
                ", comContent='" + comContent + '\'' +
                ", comLike=" + comLike +
                ", comArtId=" + comArtId +
                ", comDate=" + comDate +
                ", comStatus=" + comStatus +
                ", reply=" + reply +
                ", comIp='" + comIp + '\'' +
                '}';
    }
}