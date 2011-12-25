package solr;

import controllers.Application;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class SearchResult {

    private PagedList<SearchFeed> pagedList = new PagedList<SearchFeed>();

	private double searchTime;
    
    private long totalResults = 0;

    private long facetTotalResults = 0;

    private List<String> corrections = new ArrayList<String>();
    
	private List<String> relates = new ArrayList<String>();

    private Map<String, Long> facets = new LinkedHashMap<String, Long>();

    public Map<String, Long> getFacets() {
        return facets;
    }

    public void addFacet(String category, long count) {
        facets.put(category, count);
    }

    public double getSearchTime() {
		return searchTime;
	}

	public void setSearchTime(double searchTime) {
		this.searchTime = searchTime;
	}

	public long getTotalResults() {
		return totalResults;
	}

	public void setTotalResults(long totalResults) {
		this.totalResults = totalResults;
	}


	public List<String> getCorrections() {
		return corrections;
	}

	public void setCorrections(List<String> corrections) {
		this.corrections = corrections;
	}

	public List<String> getRelates() {
		return relates;
	}

	public void setRelates(List<String> relates) {
		this.relates = relates;
	}

	public PagedList<SearchFeed> getPagedList() {
		return pagedList;
	}

	public void setPagedList(PagedList<SearchFeed> pagedList) {
		this.pagedList = pagedList;
	}

    public long getFacetTotalResults() {
        return facetTotalResults;
    }

    public void setFacetTotalResults(long facetTotalResults) {
        this.facetTotalResults = facetTotalResults;
    }
}
