package com.acosux.MSUpdates.util;

import com.fasterxml.jackson.databind.node.ObjectNode;


public class Issues {

    private String expand;
    private String self;
    private String id;
    private ObjectNode fields;
    private String key;

    public Issues() {
    }

    public Issues(String expand, String self, String id, ObjectNode fields, String key) {
        this.expand = expand;
        this.self = self;
        this.id = id;
        this.fields = fields;
        this.key = key;
    }

    public String getExpand() {
        return expand;
    }

    public void setExpand(String expand) {
        this.expand = expand;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ObjectNode getFields() {
        return fields;
    }

    public void setFields(ObjectNode fields) {
        this.fields = fields;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    
    
}
