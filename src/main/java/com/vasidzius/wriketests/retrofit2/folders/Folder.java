package com.vasidzius.wriketests.retrofit2.folders;

import java.util.ArrayList;
import java.util.List;

public class Folder {

    private String id;
    private String title;
    private List<String> childIds = new ArrayList<String>();
    private String scope;

    public String getTitle() {
        return title;
    }

    public String getId() {
        return id;
    }

    public String getScope() {
        return scope;
    }
}
