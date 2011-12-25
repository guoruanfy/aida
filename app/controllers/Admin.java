package controllers;

import models.HotItems;
import models.ItemModel;
import models.MealModel;
import play.mvc.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: fangyuan01
 * Date: 11-12-25
 * Time: 下午7:29
 * To change this template use File | Settings | File Templates.
 */
public class Admin extends Controller {
    public static void importHotItems(){
        List<Long> weekHots = new ArrayList<Long>();
        List<Long> dayHots = new ArrayList<Long>();
        weekHots.add(1L);
        weekHots.add(2L);
        weekHots.add(2L);
        weekHots.add(4L);
        weekHots.add(5L);
        HotItems weekHotItems = new HotItems(HotItems.WEEK_HOT_MEALS,weekHots);
        weekHotItems.save();

        dayHots.add(1L);
        dayHots.add(1L);
        dayHots.add(1L);
        dayHots.add(1L);
        HotItems dayProductItems = new HotItems(HotItems.DAY_HOT_PRODUCT,dayHots);
        dayProductItems.save();
    }

    public static void fabricateData() {
         List<Long> iids = new ArrayList<Long>();
         iids.add(1L);
         iids.add(1L);
         iids.add(1L);
         iids.add(1L);
         iids.add(1L);
         MealModel mm1 = new MealModel(1L, 1L, "2011宝利博纳秋冬爆款搭配优惠更给力",
                 "2011秋冬爆款搭配，月销近万件。",
                 497.0, 98.0, true, iids);
         mm1.save();
         MealModel mm2 = new MealModel(2L, 1L, "情侣套餐：女热力绒套装+男热力绒套装",
                 "描述为空",
                 654.0, 339.0, true, iids);
         mm2.save();
         MealModel mm4 = new MealModel(4L, 1L,
                 "沃跃男鞋冬款 情侣冬季正品清仓日常休闲鞋韩版英伦潮流 真皮鞋子H001",
                 "因活动期间订单暴增，12.12之前的订单，",
                 654.0, 460.0, true, iids);
         mm4.save();
         MealModel mm5 = new MealModel(5L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm5.save();
                 MealModel mm6 = new MealModel(6L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm6.save();
                 MealModel mm7 = new MealModel(7L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm7.save();
                 MealModel mm8 = new MealModel(8L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm8.save();
                 MealModel mm9 = new MealModel(9L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm9.save();
                 MealModel mm10 = new MealModel(10L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm10.save();
                 MealModel mm11 = new MealModel(11L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm11.save();
                 MealModel mm12 = new MealModel(12L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm12.save();
                 MealModel mm13 = new MealModel(13L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm13.save();
                 MealModel mm14 = new MealModel(14L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm14.save();
                         MealModel mm15= new MealModel(15L, 1L,
                 "虎贝尔 汽车坐垫冬季新款 毛绒车垫汽车座垫 通用车座套 正品包邮",
                 "EGF非常完美全效修护眼霜20ML",
                 654.0, 460.0, true, iids);
         mm15.save();

//        添加item信息
         Date now = new Date();
           ItemModel item1 = new ItemModel(1L,1L,1L,
                   "http://detail.tmall.com/item.htm?id=12452909720&pm2=2&source=dou&cm_cat=50032082&prt=1324739444967&prc=2",
                   "http://localhost:9000/public/images/product/product1.jpg",
                   "宝利博纳 2011新款秋装 男士商务休闲 薄款羊绒衫 印花 毛衣 男",
                   "http://localhost:9000/public/images/product/product1.jpg",
                   196.0,now,now,3L,3L);
         item1.save();
     }

}
