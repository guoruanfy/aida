package solr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PagedList<T> implements Serializable {
    public static final int PAGE_SIZE = 12;
    // 在界面上显示的分页栏中，前后分页的页数
    public static final int PAGE_OFFSET = 4;
 
    

	int page;
    int count;
	int pageSize = PAGE_SIZE;
    List<T> items = new ArrayList<T>();

    
    
    public PagedList() {

    }

    public PagedList(List<T> items, int count, int page) {
        this.items = items;
        this.count = count;
        this.page = page;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public long getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public int getStartPos() {
        return (this.page - 1) * this.pageSize;
    }

    public int getEndPos() {
        return Math.min(this.page * this.pageSize - 1, this.count);
    }

    public int getPageNum() {
        return (this.count + this.pageSize - 1) / this.pageSize;
    }

    /**
     * 得到在界面上分页的开始页数，如果当前页号小于10，取开始页号为1，若大于10， 则取当前页号-10为最开始页号
     * 如：[1] [2] 3 [4] [5] ....
     * 或：[5] [6] [7] [8] [9] [10] [11] [12] [13] [14] 15 [16]
     * 其中没有[]的，就表示当前页号，而开始页号即是显示的第一个，如[1]和[5]
     * 
     * @return 开始页号
     */
    public int getPageShowStart() {
        int num = getPage();
        num -= PAGE_OFFSET;
        if (num < 1) num = 1;
        return num;
    }

    /**
     * 得到在界面上分页的结束页数，如果当前页号大于最大页号，取结束页号为最大页号，若小于最大页号， 则取当前页号+10为结束页号
     * 假设最大总数页号为16
     * 如：[1] [2] [3] [4] [5] [6] [7] [8] [9] 10 [11] [12] [13] [14] [15] [16]
     * 或：[1] [2] [3] [4] [5] 6 [7] [8] [9] [10] [11] [12] [13] [14] [15] [16]
     * 其中没有[]的，就表示当前页号，而结束页号即是显示的最后一个，如[16]
     *
     * @return 开始页号
     */
    public int getPageShowEnd() {
        int num = getPage();
        num += PAGE_OFFSET;
        if (num > getPageNum()) num = getPageNum();
        return num;
    }




}
