package cn.cllover.myblog.front.pojo;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "tag_cat_count")
public class TagArtCount implements Serializable {

    private Long TaId;
    private Long TaCount;
    private Long TaUserId;

    public Long getTaId() {
        return TaId;
    }

    public void setTaId(Long taId) {
        TaId = taId;
    }

    public Long getTaCount() {
        return TaCount;
    }

    public void setTaCount(Long taCount) {
        TaCount = taCount;
    }

    public Long getTaUserId() {
        return TaUserId;
    }

    public void setTaUserId(Long taUserId) {
        TaUserId = taUserId;
    }
}
