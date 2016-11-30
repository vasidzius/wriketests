package com.vasidzius.wriketests.retrofit2.tasks;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private String id;
    private String accountId;
    private String title;
    private String description;
    private String briefDescription;
    private List<String> parentIds = new ArrayList<String>();
    private List<String> superParentIds = new ArrayList<String>();
    private List<String> sharedIds = new ArrayList<String>();
    private List<String> responsibleIds = new ArrayList<String>();
    private String status;
    private String importance;
    private String createdDate;
    private String updatedDate;
    private Dates dates;
    private String scope;
    private List<String> authorIds = new ArrayList<String>();
    private String customStatusId;
    private Boolean hasAttachments;
    private Integer attachmentCount;
    private String permalink;
    private String priority;
    private Boolean followedByMe;
    private List<String> followerIds = new ArrayList<String>();
    private List<String> superTaskIds = new ArrayList<String>();
    private List<Object> subTaskIds = new ArrayList<Object>();
    private List<Object> dependencyIds = new ArrayList<Object>();
    private List<Metadatum> metadata = new ArrayList<Metadatum>();
    private List<CustomField> customFields = new ArrayList<CustomField>();

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    static class CustomField {

        private String id;
        private String value;

    }

    static class Dates {

        private String type;
        private Integer duration;
        private String start;
        private String due;

    }

    static class Metadatum {

        private String key;
        private String value;

    }
}