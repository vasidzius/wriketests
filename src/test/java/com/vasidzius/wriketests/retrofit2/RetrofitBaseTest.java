package com.vasidzius.wriketests.retrofit2;

import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

class RetrofitBaseTest {

    WrikeService service;

    RetrofitBaseTest() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(httpLoggingInterceptor);

        httpClient.addInterceptor(new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url().newBuilder()
                        .addQueryParameter(
                                "access_token",
                                AccessToken.ACCESS_TOKEN
                        )
                        .build();
                request = request.newBuilder().url(url).build();
                return chain.proceed(request);
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.wrike.com/api/v3/")
                .client(httpClient.build())
                .build();

        service = retrofit.create(WrikeService.class);
    }

    void customAssert(retrofit2.Response<ResponseBody> response) throws IOException {
        assertThat(response.errorBody() == null ? "" :
                        response.code() + response.errorBody().string(),
                response.errorBody(),
                is(nullValue())
        );
    }
}
