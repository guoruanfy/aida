package models;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;
import play.modules.morphia.Model;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: fangyuan01
 * Date: 11-12-25
 * Time: 下午7:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class HotItems extends Model {
    public static final String WEEK_HOT_MEALS="WeekHotMeals";
    public static final String DAY_HOT_PRODUCT="DayHotProducts";
    public String type;
    public List<Long> itemIds;

    public HotItems(String type, List<Long> itemIds) {
        this.type = type;
        this.itemIds = itemIds;
    }

}
