package com.acosux.MSUpdates.util;

public class JiraTask {
    private String key;
    private String summary;
    private String description;
    // otros campos y propiedades de la tarea

    public JiraTask(String key, String summary, String description) {
        this.key = key;
        this.summary = summary;
        this.description = description;
    }

    public String getKey() {
        return key;
    }

    public String getSummary() {
        return summary;
    }

    public String getDescription() {
        return description;
    }

}


