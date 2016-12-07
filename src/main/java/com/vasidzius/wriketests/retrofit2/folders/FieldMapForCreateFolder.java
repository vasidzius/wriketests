package com.vasidzius.wriketests.retrofit2.folders;

import java.util.HashMap;
import java.util.Map;

public class FieldMapForCreateFolder {

    private final Map<String, String> internalMap = new HashMap<>();

    private FieldMapForCreateFolder(){}

    public static FieldMapForCreateFolder Builder(String title){
        FieldMapForCreateFolder fieldMap = new FieldMapForCreateFolder();
        fieldMap.internalMap.put("title", title);
        return fieldMap;
    }

    public FieldMapForCreateFolder description(String description){
        internalMap.put("description", description);
        return this;
    }

    public Map<String, String> build() {
        return internalMap;
    }

}
