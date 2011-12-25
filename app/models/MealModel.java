package models;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import play.modules.morphia.Model;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MealModel extends Model {
    @Id
    public Long mid;
    @Indexed
    public Long uid;
    public String name;
    public String memo;
    public Double price;
    public Double discount;
    public Boolean available;
    public Boolean indexed;
    public List<Long> iids;

    @Override
    public Object getId() {
        return this.mid;
    }

    @Override
    protected void setId_(Object id) {
        this.mid = (Long) id;
    }

    public MealModel(Long mid, Long uid, String name, String memo,
                     Double price, Double discount, Boolean available, List<Long> iids) {
        this.mid = mid;
        this.uid = uid;
        this.name = name;
        this.memo = memo;
        this.price = price;
        this.discount = discount;
        this.available = available;
        this.indexed = false;
        this.iids = iids;
    }

    public List<ItemModel> getItemsOfMeal(){
        List<ItemModel> items = new ArrayList<ItemModel>();
        for(Long id :iids){
           items.add(ItemModel.<ItemModel>findById(id));
        }
        return items;
    }
}