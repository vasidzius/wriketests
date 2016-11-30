package com.vasidzius.wriketests.retrofit2;

import com.google.common.io.Files;
import com.google.gson.Gson;
import com.vasidzius.wriketests.retrofit2.tasks.FieldMapForCreateTask;
import com.vasidzius.wriketests.retrofit2.tasks.Task;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

public class RetrofitTest extends RetrofitBaseTest {

    @Test
    public void testCreateNewTaskWithCustomFieldMap() throws IOException {
        Call<ResponseBody> call = service.createTaskWithFieldMap(
                FieldMapForCreateTask.Builder("with CustomFieldMap")
                        .description("Some description")
                        .importance(FieldMapForCreateTask.ImportanceEnum.HIGH)
                        .status(FieldMapForCreateTask.StatusEnum.CANCELLED)
                        .build()
        );

        Response<ResponseBody> response = call.execute();
        customAssert(response);
    }

    @Test
    public void testGetPartOfJson() throws IOException {

        JSONObject obj = new JSONObject(
                Files.toString(
                        new File(RetrofitTest.class.getResource("createTaskResponse.json").getFile()),
                        Charset.defaultCharset())
        );
        JSONObject jsonTask = (JSONObject)obj.getJSONArray("data").get(0);
        Gson gson = new Gson();
        Task task = gson.fromJson(jsonTask.toString(), Task.class);

        assertEquals("IEAGIITRKQAYHYM6", task.getId());
    }

    @Test
    public void testCreateDeleteTask() throws IOException {
        Call<ResponseBody> callToCreate = service.createTaskWithFieldMap(
                FieldMapForCreateTask.Builder("task for delete")
                .build()
        );
        Response<ResponseBody> responseFromCreate = callToCreate.execute();
        customAssert(responseFromCreate);
        Gson gson = new Gson();
        JSONObject jsonObject = new JSONObject(responseFromCreate.body().string());
        JSONObject jsonTask = (JSONObject) jsonObject.getJSONArray("data").get(0);
        Task task = gson.fromJson(jsonTask.toString(), Task.class);
        String taskId = task.getId();
        Call<ResponseBody> callToDelete = service.deleteTask(taskId);
        Response<ResponseBody> responseFromDelete = callToDelete.execute();
        customAssert(responseFromDelete);

    }


}
