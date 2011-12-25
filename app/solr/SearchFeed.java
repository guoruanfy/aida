package solr;

import com.google.code.morphia.annotations.Id;
import com.google.code.morphia.annotations.Indexed;
import models.ItemModel;
import models.MealModel;

import javax.xml.transform.sax.SAXTransformerFactory;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: fangyuan01
 * Date: 11-12-16
 * Time: 上午12:34
 * To change this template use File | Settings | File Templates.
 */
public class SearchFeed {
    public Long mid;
    public MealModel meal;
    public List<ItemModel> items;

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public MealModel getMeal() {
        return meal;
    }

    public void setMeal(MealModel meal) {
        this.meal = meal;
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }
}
