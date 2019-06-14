package cn.cllover.myblog.front.pojo;

import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "cat_art_count")
public class CatArtCount implements Serializable {

    private Long CaId;
    private Long CaCount;
    private Long CaUserId;

    public Long getCaId() {
        return CaId;
    }

    public void setCaId(Long caId) {
        CaId = caId;
    }

    public Long getCaCount() {
        return CaCount;
    }

    public void setCaCount(Long caCount) {
        CaCount = caCount;
    }

    public Long getCaUserId() {
        return CaUserId;
    }

    public void setCaUserId(Long caUserId) {
        CaUserId = caUserId;
    }
}
