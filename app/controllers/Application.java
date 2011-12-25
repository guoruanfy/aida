package controllers;

import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.slf4j.*;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import services.HotDataService;
import solr.SearchResult;
import solr.SolrSearchEngine;

public class Application extends Controller {
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SolrSearchEngine.class);
    public static Map<Long, String> categoryMapper = new HashMap<Long, String>();
    public static Map<String, Long> reverseCategoryMapper = new HashMap<String, Long>();

    @Before
    public static void init() {
        categoryMapper.put(1L, "衣服");
        categoryMapper.put(2L, "鞋子");
        categoryMapper.put(3L, "裤子");
        reverseCategoryMapper.put("衣服", 1L);
        reverseCategoryMapper.put("鞋子", 2L);
        reverseCategoryMapper.put("裤子", 3L);
    }

    public static void index() {
        List<MealModel> weekHotMeals = HotDataService.getHotWeekMeals();
        List<ItemModel> dayHotProducts = HotDataService.getHotDayProducts();
        render("index.html",weekHotMeals,dayHotProducts);
    }


    public static void search(String keyword, int pageNo, String category, String sortField) {
        if (StringUtils.isBlank(keyword)) {
            redirect("/");
        }
        doSearch(keyword, pageNo, category, sortField, "http://localhost:8983/solr");
    }

    private static void doSearch(String keyword, int pageNo, String category,
                                 String sortField, String solrUrl) {

        SearchResult sr;
        SolrSearchEngine s = new SolrSearchEngine(solrUrl);
        SolrQuery sq
                = s.buildQuery(keyword, pageNo, category, sortField);

        sr = s.execute(sq);

        s.setFacetFields(keyword, sr);

        SearchForm form = new SearchForm(sortField, keyword, category, pageNo);

        render("list.html", sr, form);
    }

}