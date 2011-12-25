package models;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import play.modules.morphia.Model;

import java.util.Date;


@Entity
public class ItemModel extends Model {
    @Id
    public Long iid;
    public Long uid;
    public Long cid;
    public String url;
    public String tbkurl;
    public String memo;
    public String purl;
    public Double price;
    public Date list;
    public Date delist;
    public Long score;
    public Long volume;

    @Override
    public Object getId() {
        return this.iid;
    }

    @Override
    protected void setId_(Object id) {
        this.iid = (Long) id;
    }

    public ItemModel(Long iid, Long uid, Long cid, String url, String tbkurl, String memo,
                     String purl, Double price, Date list, Date delist, Long score,
                     Long volume) {
        this.iid = iid;
        this.uid = uid;
        this.cid = cid;
        this.url = url;
        this.tbkurl = tbkurl;
        this.memo = memo;
        this.purl = purl;
        this.price = price;
        this.list = list;
        this.delist = delist;
        this.score = score;
        this.volume = volume;
    }
}
