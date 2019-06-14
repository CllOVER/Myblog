package cn.cllover.myblog.front.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "`myblog_article`")
public class Article implements Serializable {
    private Long artId;

    private String artDesc;   //博客描述

    private String artTitle;  //标题

    private String artPoint;  //简要

    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date artWritedate;  //编写时间

    private Date artUpdatedate;

    private String artPhoto;

    private String artUrl;

    private Long artView;

    private Long artLike;

    private Long artComId;

    private Integer artStatus;

    private Integer artOpenPrivate;   //是否公开

    private Long artUserId;

    private Integer artTop;   //是否指定

    private String artContent;    //博客内容

    private Long artTagId;

    private Long artCatId;
    //联合查询
    private Tag tags;

    private Category cats;

    private User users;

    public User getUsers() {
        return users;
    }

    public void setUsers(User users) {
        this.users = users;
    }

    public Category getCats() {
        return cats;
    }

    public void setCats(Category cats) {
        this.cats = cats;
    }

    public Tag getTag() {
        return tags;
    }

    public void setTag(Tag tags) {
        this.tags = tags;
    }

    public Long getArtTagId() {
        return artTagId;
    }

    public void setArtTagId(Long artTagId) {
        this.artTagId = artTagId;
    }

    public Long getArtCatId() {
        return artCatId;
    }

    public void setArtCatId(Long artCatId) {
        this.artCatId = artCatId;
    }

    public Long getArtId() {
        return artId;
    }

    public void setArtId(Long artId) {
        this.artId = artId;
    }

    public String getArtDesc() {
        return artDesc;
    }

    public void setArtDesc(String artDesc) {
        this.artDesc = artDesc;
    }

    public String getArtTitle() {
        return artTitle;
    }

    public void setArtTitle(String artTitle) {
        this.artTitle = artTitle;
    }

    public String getArtPoint() {
        return artPoint;
    }

    public void setArtPoint(String artPoint) {
        this.artPoint = artPoint;
    }

    public Date getArtWritedate() {
        return artWritedate;
    }

    public void setArtWritedate(Date artWritedate) {
        this.artWritedate = artWritedate;
    }

    public Date getArtUpdatedate() {
        return artUpdatedate;
    }

    public void setArtUpdatedate(Date artUpdatedate) {
        this.artUpdatedate = artUpdatedate;
    }

    public String getArtPhoto() {
        return artPhoto;
    }

    public void setArtPhoto(String artPhoto) {
        this.artPhoto = artPhoto;
    }

    public String getArtUrl() {
        return artUrl;
    }

    public void setArtUrl(String artUrl) {
        this.artUrl = artUrl;
    }

    public Long getArtView() {
        return artView;
    }

    public void setArtView(Long artView) {
        this.artView = artView;
    }

    public Long getArtLike() {
        return artLike;
    }

    public void setArtLike(Long artLike) {
        this.artLike = artLike;
    }

    public Long getArtComId() {
        return artComId;
    }

    public void setArtComId(Long artComId) {
        this.artComId = artComId;
    }

    public Integer getArtStatus() {
        return artStatus;
    }

    public void setArtStatus(Integer artStatus) {
        this.artStatus = artStatus;
    }

    public Integer getArtOpenPrivate() {
        return artOpenPrivate;
    }

    public void setArtOpenPrivate(Integer artOpenPrivate) {
        this.artOpenPrivate = artOpenPrivate;
    }

    public Long getArtUserId() {
        return artUserId;
    }

    public void setArtUserId(Long artUserId) {
        this.artUserId = artUserId;
    }

    public Integer getArtTop() {
        return artTop;
    }

    public void setArtTop(Integer artTop) {
        this.artTop = artTop;
    }

    public String getArtContent() {
        return artContent;
    }

    public void setArtContent(String artContent) {
        this.artContent = artContent;
    }

    @Override
    public String toString() {
        return "Article{" +
                "artId=" + artId +
                ", artDesc='" + artDesc + '\'' +
                ", artTitle='" + artTitle + '\'' +
                ", artPoint='" + artPoint + '\'' +
                ", artWritedate=" + artWritedate +
                ", artUpdatedate=" + artUpdatedate +
                ", artPhoto='" + artPhoto + '\'' +
                ", artUrl='" + artUrl + '\'' +
                ", artView=" + artView +
                ", artLike=" + artLike +
                ", artComId=" + artComId +
                ", artStatus=" + artStatus +
                ", artOpenPrivate=" + artOpenPrivate +
                ", artUserId=" + artUserId +
                ", artTop=" + artTop +
                ", artContent='" + artContent + '\'' +
                '}';
    }
}