package services;

import models.HotItems;
import models.ItemModel;
import models.MealModel;
import org.slf4j.LoggerFactory;
import solr.SolrSearchEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: fangyuan01
 * Date: 11-12-25
 * Time: 下午7:40
 * To change this template use File | Settings | File Templates.
 */
public class HotDataService {
        private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HotDataService.class);
    public static List<MealModel> getHotWeekMeals() {
        List<HotItems> hots = HotItems.find("type", HotItems.WEEK_HOT_MEALS).asList();
        List<Long> ids = hots.get(0).itemIds;
        LOGGER.info("ids"+ids);
        List<MealModel> mealModels = new ArrayList<MealModel>();
        for (Long id : ids) {
                    LOGGER.info("mealModels"+MealModel.<MealModel>findById(id));
            mealModels.add(MealModel.<MealModel>findById(id));
        }
        return mealModels;
    }

    public static List<ItemModel> getHotDayProducts() {
        List<HotItems> hots = HotItems.find("type", HotItems.DAY_HOT_PRODUCT).asList();
        List<Long> ids = hots.get(0).itemIds;
        List<ItemModel> items = new ArrayList<ItemModel>();
        for (Long id : ids) {
            items.add(ItemModel.<ItemModel>findById(id));
        }
        return items;
    }
}
