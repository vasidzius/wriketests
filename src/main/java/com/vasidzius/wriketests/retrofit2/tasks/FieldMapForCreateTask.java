package com.vasidzius.wriketests.retrofit2.tasks;

import java.util.HashMap;
import java.util.Map;

public class FieldMapForCreateTask {

    private Map<String, String> internalMap = new HashMap<String, String>();

    private FieldMapForCreateTask(){}

    public static FieldMapForCreateTask Builder(String title){
        FieldMapForCreateTask fieldMap = new FieldMapForCreateTask();
        fieldMap.internalMap.put("title", title);
        return fieldMap;
    }

    public FieldMapForCreateTask description(String description){
        internalMap.put("description", description);
        return this;
    }

    public FieldMapForCreateTask status(StatusEnum statusEnum){
        internalMap.put("status", statusEnum.value);
        return this;
    }

    public FieldMapForCreateTask importance(ImportanceEnum importanceEnum){
        internalMap.put("importance", importanceEnum.value);
        return this;
    }

    public Map<String, String> build() {
        return internalMap;
    }

    // Active, Completed, Deferred, Cancelled
    public enum StatusEnum {
        ACTIVE("Active"),
        COMPLETED("Completed"),
        DEFERRED("Deferred"),
        CANCELLED("Cancelled");

        private String value;

        StatusEnum(String value){
            this.value = value;
        }
    }

    //High, Normal, Low
    public enum ImportanceEnum {
        HIGH("High"),
        NORMAL("Normal"),
        LOW("Low");

        private String value;

        ImportanceEnum(String value){
            this.value = value;
        }
    }
}
