package com.vasidzius.wriketests.retrofit2;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.vasidzius.wriketests.retrofit2.folders.Folder;
import com.vasidzius.wriketests.retrofit2.tasks.Task;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Response;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;

public class RetrofitTestUtils {

    @Step("Конвертировать json из ответа в экземпляр")
    static <T> T getItem(Response<ResponseBody> response, TypeToken<T> genericType) throws IOException {
        Gson gson = new Gson();
        JSONObject jsonObject = new JSONObject(response.body().string());
        JSONObject jsonItem = (JSONObject) jsonObject.getJSONArray("data").get(0);
        return gson.fromJson(jsonItem.toString(), genericType.getType());

    }

    @Step("получить rootFolderId")
    static String getRootFolderId(RetrofitBaseTest retrofit) throws IOException {
        Call<ResponseBody> callGetFolderTree = retrofit.service.getFolders();
        Response<ResponseBody> response = callGetFolderTree.execute();
        retrofit.customAssert(response);
        Folder folder = getItem(response, new TypeToken<Folder>() {
        });
        return folder.getId();
    }
}
