package solr;

import controllers.Application;
import models.ItemModel;
import models.MealModel;
import org.apache.commons.lang.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CommonsHttpSolrServer;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Solr search engine.
 */
public class SolrSearchEngine {
    private final static int PAGE_SIZE = 10;
    private static final int FACET_LIMIT = 10;

    private final static Logger LOGGER = LoggerFactory.getLogger(SolrSearchEngine.class);
    private static CommonsHttpSolrServer server = null;

    public SolrSearchEngine(String solrUrl) {
        try {
//            server = new CommonsHttpSolrServer(solrUrl);
            server = new CommonsHttpSolrServer("http://localhost:8983/solr");
        } catch (MalformedURLException e) {
            LOGGER.error("Connect to Solr failed!", e);
        }
    }


    public SolrQuery buildQuery(String query, int page, String category, String sortField) {

        SolrQuery q = new SolrQuery();

        int start = (page - 1) * PAGE_SIZE;
        String[] fields = {"mid"};
        setCommonAttributeForQuery(q, query, start, PAGE_SIZE, fields);

        if (!StringUtils.isBlank(category)) {
            q.addFilterQuery("cid:" + Application.reverseCategoryMapper.get(category));
        }

        if (!StringUtils.isBlank(sortField)) {
            if(sortField.equals("default")){
               q.setSortField("score", SolrQuery.ORDER.desc);
            }else{
               q.setSortField(sortField, SolrQuery.ORDER.desc);
            }
        }
        return q;
    }


    private void setCommonAttributeForQuery(SolrQuery q, String query, int start, int rows, String[] fields) {

        q.setQuery(query);
        q.setQueryType("/elevate");

        q.setStart(start);
        q.setRows(rows);

        q.setFields(fields);
        q.setParam("defType", "edismax");
        q.setParam("qf", "title mdesc idesc");

//        q.setParam("mm", "100%");
    }


    public void setFacetFields(String query, SearchResult sr) {
        SolrQuery q = new SolrQuery();
        setCommonAttributeForQuery(q, query, 0, 0, new String[0]);
        q.setFacetLimit(FACET_LIMIT);
        q.setFacet(true);
        q.addFacetField("cid");
        QueryResponse rsp=null;
        try {
            rsp = server.query(q);
        } catch (SolrServerException e) {
            LOGGER.error(e.getMessage(),e);
        }

        sr.setFacetTotalResults(rsp.getResults().getNumFound());

        FacetField facetField = rsp.getFacetField("cid");
        if (facetField.getValues() == null) {
            return;
        }

        for (FacetField.Count count : facetField.getValues()) {
            String cid = count.getName();
            long val = count.getCount();
            if (val > 0) {
                String category = Application.categoryMapper.get(Long.parseLong(cid));
                sr.addFacet(category, val);
            }
        }
    }

    public SearchResult execute(SolrQuery q) {
        SearchResult searchResult = new SearchResult();

        QueryResponse rsp = null;
        LOGGER.info("query q:"+q);
        try {
            rsp = server.query(q);
        } catch (SolrServerException e) {
            LOGGER.error(e.getMessage(), e);
        }

        setCommonAttributes(searchResult, rsp);
        setSearchFeeds(searchResult, rsp);

        return searchResult;
    }

    private void setCommonAttributes(SearchResult sr, QueryResponse rsp) {
        sr.getPagedList().setCount((int) rsp.getResults().getNumFound());
        sr.getPagedList().setPageSize(PAGE_SIZE);
        sr.setSearchTime((double) rsp.getElapsedTime() / 1000);
        sr.setTotalResults(rsp.getResults().getNumFound());
        sr.getPagedList().setPage(((int) rsp.getResults().getStart() / PAGE_SIZE) + 1);
    }

    private void setSearchFeeds(SearchResult sr, QueryResponse rsp) {
        List<SearchFeed> feeds = new LinkedList<SearchFeed>();
        SolrDocumentList docs = rsp.getResults();
        LOGGER.info("mealItemsSize:"+docs.size());
        for (SolrDocument doc : docs) {
            SearchFeed feed = new SearchFeed();
            Long mid = Long.parseLong((String)doc.getFieldValue("mid"));
            feed.setMid(mid);
            MealModel meal =  MealModel.<MealModel>findById(mid);
            feed.setMeal(meal);
            List<ItemModel> mealItems = new ArrayList<ItemModel>();
            LOGGER.info("mealItems:"+mealItems);
            for(long itemid: meal.iids){
                 mealItems.add(ItemModel.<ItemModel>findById(itemid));
            }
            feed.setItems(mealItems);
            feeds.add(feed);
        }
        sr.getPagedList().setItems(feeds);
    }


}
