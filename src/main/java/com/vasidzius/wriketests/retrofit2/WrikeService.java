package com.vasidzius.wriketests.retrofit2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface WrikeService {

    //tasks
    @FormUrlEncoded
    @POST("folders/{folderId}/tasks")
    Call<ResponseBody> createTaskWithFieldMap(
            @Path("folderId") String folderId,
            @FieldMap Map<String, String> fieldMap
    );

    @DELETE("tasks/{taskId}")
    Call<ResponseBody> deleteTask(@Path("taskId") String taskId);

    //folders
    @GET("folders")
    Call<ResponseBody> getFolders();

    @FormUrlEncoded
    @POST("folders/{parentFolderId}/folders")
    Call<ResponseBody> createFolder(
            @Path("parentFolderId") String parentFolderId,
            @FieldMap Map<String, String> fieldMap
    );

    @DELETE("folders/{folderId}")
    Call<ResponseBody> deleteFolder(@Path("folderId") String folderId);

    @GET("brokenrequest")
    Call<ResponseBody> brokenRequest();
}
