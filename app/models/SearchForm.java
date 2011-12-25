package models;

public class SearchForm {
    private String sortField;
    private String keyword;
    private String category;
    private int pageNo;

    public SearchForm(String sortField, String keyword, String category, int pageNo) {
        this.sortField = sortField;
        this.keyword = keyword;
        this.category = category;
        this.pageNo = pageNo;
    }

    public String getSortField() {
        return sortField;
    }

    public String getKeyword() {
        return keyword;
    }

    public String getCategory() {
        return category;
    }

    public int getPageNo() {
        return pageNo;
    }
}
