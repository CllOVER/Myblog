package cn.cllover.myblog.front.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "`myblog_category`")
public class Category implements Serializable {
    private Long catId;

    private String catName;

    private String catDesc;

    private Integer catStatus;

    private Long catUserId;

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
}