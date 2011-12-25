package models;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import play.modules.morphia.Model;

import java.util.Date;

@Entity
public class SellerModel extends Model {

    @Id
    public Long uid;
    public String nick;
    public Date expire;
    public String mstatus;

    @Override
    public Object getId() {
        return this.uid;
    }

    @Override
    protected void setId_(Object id) {
        this.uid = (Long) id;
    }

    public SellerModel(Long uid, String nick) {
        this.uid = uid;
        this.nick = nick;
        this.mstatus = "init";
    }
}
