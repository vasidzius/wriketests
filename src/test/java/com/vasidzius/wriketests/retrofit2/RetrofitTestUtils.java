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

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class RetrofitTestUtils {

    @Step("Конвертировать json из ответа в экземпляр")
    static <T> T getItem(Response<ResponseBody> response, TypeToken<T> genericType) throws IOException {
        Gson gson = new Gson();
        JSONObject jsonObject = new JSONObject(response.body().string());
        JSONObject jsonItem = (JSONObject) jsonObject.getJSONArray("data").get(0);
        return gson.fromJson(jsonItem.toString(), genericType.getType());

    }

    @Step("получить rootFolderId")
    static String getRootFolderId(RetrofitTest retrofit) throws IOException {
        Call<ResponseBody> callGetFolderTree = retrofit.service.getFolders();
        Response<ResponseBody> response = callGetFolderTree.execute();
        customAssert(response);
        Folder folder = getItem(response, new TypeToken<Folder>() {
        });
        return folder.getId();
    }

    public static void customAssert(Response<ResponseBody> response) throws IOException {
        assertThat(response.errorBody() == null ? "" :
                        response.code() + response.errorBody().string(),
                response.errorBody(),
                is(nullValue())
        );
    }

    public static void deleteTaskByName(WrikeService wrikeService, String name) throws IOException {
        Call<ResponseBody> call = wrikeService.getTask(name);
        Response<ResponseBody> response = call.execute();
        Task task = getItem(response, new TypeToken<Task>() {});
        String taskId = task.getId();
        Call<ResponseBody> deleteResponse = wrikeService.deleteTask(taskId);
        customAssert(deleteResponse.execute());
    }
}
