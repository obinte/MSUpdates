
package com.acosux.MSUpdates.util;

import com.fasterxml.jackson.databind.node.ObjectNode;
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
    private ObjectNode errorMessages;

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

    public ObjectNode getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(ObjectNode errorMessages) {
        this.errorMessages = errorMessages;
    }

}
