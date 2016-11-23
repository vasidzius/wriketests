package com.vasidzius.wriketests.retrofit2;

import okhttp3.ResponseBody;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import com.vasidzius.wriketests.retrofit2.WrikeService;

import java.io.IOException;

public class RetrofitTest {

    @Test
    public void test() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wrike.com/api/v3/")
                .build();


        WrikeService service = retrofit.create(WrikeService.class);
        Call<ResponseBody> call = service.createTask("from Code5");
        Response<ResponseBody> response = call.execute();
        System.out.println(response.isSuccessful());
        System.out.println(response.body().string());


    }
}
