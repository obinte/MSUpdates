
package com.acosux.MSUpdates.util;

import java.util.List;

/**
 *
 * @author tabango
 */
public class IssuesResponse {

    private String expand;
    private int total;
    private int maxResults;
    private List<Issues> issues;
    private int startAt;

    public List<Issues> getIssues() {
        return issues;
    }

    public void setIssues(List<Issues> issues) {
        this.issues = issues;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getStartAt() {
        return startAt;
    }

    public void setStartAt(int startAt) {
        this.startAt = startAt;
    }

}
