package cn.cllover.myblog.front.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "`comment_reply`")
public class CommentReply {
    private Long reId;

    private Long reComId;

    private Long reUserId;

    private Long reUseredId;

    private Date reDate;

    private String reContent;

    private Integer reStatus;

    private String reIp;

    private Long reLike;

    public Long getReId() {
        return reId;
    }

    public void setReId(Long reId) {
        this.reId = reId;
    }

    public Long getReComId() {
        return reComId;
    }

    public void setReComId(Long reComId) {
        this.reComId = reComId;
    }

    public Long getReUserId() {
        return reUserId;
    }

    public void setReUserId(Long reUserId) {
        this.reUserId = reUserId;
    }

    public Long getReUseredId() {
        return reUseredId;
    }

    public void setReUseredId(Long reUseredId) {
        this.reUseredId = reUseredId;
    }

    public Date getReDate() {
        return reDate;
    }

    public void setReDate(Date reDate) {
        this.reDate = reDate;
    }

    public String getReContent() {
        return reContent;
    }

    public void setReContent(String reContent) {
        this.reContent = reContent;
    }

    public Integer getReStatus() {
        return reStatus;
    }

    public void setReStatus(Integer reStatus) {
        this.reStatus = reStatus;
    }

    public String getReIp() {
        return reIp;
    }

    public void setReIp(String reIp) {
        this.reIp = reIp;
    }

    public Long getReLike() {
        return reLike;
    }

    public void setReLike(Long reLike) {
        this.reLike = reLike;
    }

    @Override
    public String toString() {
        return "CommentReply{" +
                "reId=" + reId +
                ", reComId=" + reComId +
                ", reUserId=" + reUserId +
                ", reUseredId=" + reUseredId +
                ", reDate=" + reDate +
                ", reContent='" + reContent + '\'' +
                ", reStatus=" + reStatus +
                ", reIp='" + reIp + '\'' +
                ", reLike=" + reLike +
                '}';
    }
}