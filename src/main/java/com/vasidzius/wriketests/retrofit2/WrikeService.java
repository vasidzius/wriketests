package com.vasidzius.wriketests.retrofit2;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.Map;

public interface WrikeService {

    @FormUrlEncoded
    @POST("folders/IEAAO2AZI7777777/tasks")
    Call<ResponseBody> createTask(@Field("title") String title);

    @FormUrlEncoded
    @POST("folders/IEAAO2AZI7777777/tasks")
    Call<ResponseBody> createTaskWithFieldMap(@FieldMap Map<String, String> fieldMap);


}
