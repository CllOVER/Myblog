package cn.cllover.myblog.front.pojo;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "`myblog_tag`")
public class Tag implements Serializable {
    private Long tagId;

    private String tagDesc;

    private String tagName;

    private Integer tagStatus;

    private Long tagUserId;

    public Long getTagId() {
        return tagId;
    }


    public Long getTagUserId() {
        return tagUserId;
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

    public Long getTagUserId(Long userId) {
        return tagUserId;
    }

    public void setTagUserId(Long tagUserId) {
        this.tagUserId = tagUserId;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId=" + tagId +
                ", tagDesc='" + tagDesc + '\'' +
                ", tagName='" + tagName + '\'' +
                ", tagStatus=" + tagStatus +
                ", tagUserId=" + tagUserId +
                '}';
    }
}