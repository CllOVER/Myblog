package cn.cllover.myblog.common.entries;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AddBlog {

    private Long artId;

    private String artDesc;   //博客描述

    private String artTitle;  //标题

    private String artPoint;  //简要

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

    private Long catId;

    private String catName;

    private String catDesc;

    private Integer catStatus;

    private Long catUserId;

    private Long tagId;

    private String tagDesc;

    private String tagName;

    private Integer tagStatus;

    private Long tagUserId;

    private Long userId;

    public void setArtTagId(Long artTagId) {
        this.artTagId = artTagId;
    }

    public Long getArtCatId() {
        return artCatId;
    }

    public void setArtCatId(Long artCatId) {
        this.artCatId = artCatId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getCatDesc() {
        return catDesc;
    }

    public void setCatDesc(String catDesc) {
        this.catDesc = catDesc;
    }

    public Integer getCatStatus() {
        return catStatus;
    }

    public void setCatStatus(Integer catStatus) {
        this.catStatus = catStatus;
    }

    public Long getCatUserId() {
        return catUserId;
    }

    public void setCatUserId(Long catUserId) {
        this.catUserId = catUserId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagDesc() {
        return tagDesc;
    }

    public void setTagDesc(String tagDesc) {
        this.tagDesc = tagDesc;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getTagStatus() {
        return tagStatus;
    }

    public void setTagStatus(Integer tagStatus) {
        this.tagStatus = tagStatus;
    }

    public Long getTagUserId() {
        return tagUserId;
    }

    public void setTagUserId(Long tagUserId) {
        this.tagUserId = tagUserId;
    }

    private List<AddBlog> list = new ArrayList<>();

    public List<AddBlog> getList() {
        return list;
    }

    public void setList(List<AddBlog> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "AddBlog{" +
                "userId=" + userId +
                "，artId=" + artId +
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
                ", catId=" + catId +
                ", catName='" + catName + '\'' +
                ", catDesc='" + catDesc + '\'' +
                ", catStatus=" + catStatus +
                ", catUserId=" + catUserId +
                ", tagId=" + tagId +
                ", tagDesc='" + tagDesc + '\'' +
                ", tagName='" + tagName + '\'' +
                ", tagStatus=" + tagStatus +
                ", tagUserId=" + tagUserId +
                ", list=" + list +
                '}';
    }
}
