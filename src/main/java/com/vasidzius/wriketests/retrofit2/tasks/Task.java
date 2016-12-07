package com.vasidzius.wriketests.retrofit2.tasks;

import java.util.ArrayList;
import java.util.List;

public class Task {

    private String id;
    private String accountId;
    private String title;
    private String description;
    private String briefDescription;
    private List<String> parentIds = new ArrayList<>();
    private List<String> superParentIds = new ArrayList<>();
    private List<String> sharedIds = new ArrayList<>();
    private List<String> responsibleIds = new ArrayList<>();
    private String status;
    private String importance;
    private String createdDate;
    private String updatedDate;
    private Dates dates;
    private String scope;
    private List<String> authorIds = new ArrayList<>();
    private String customStatusId;
    private Boolean hasAttachments;
    private Integer attachmentCount;
    private String permalink;
    private String priority;
    private Boolean followedByMe;
    private List<String> followerIds = new ArrayList<>();
    private List<String> superTaskIds = new ArrayList<>();
    private List<Object> subTaskIds = new ArrayList<>();
    private List<Object> dependencyIds = new ArrayList<>();
    private List<Metadatum> metadata = new ArrayList<>();
    private List<CustomField> customFields = new ArrayList<>();

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    private static class CustomField {

        private String id;
        private String value;

    }

    private static class Dates {

        private String type;
        private Integer duration;
        private String start;
        private String due;

    }

    private static class Metadatum {

        private String key;
        private String value;

    }
}