package com.vasidzius.wriketests.retrofit2;

import com.google.common.io.Files;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.vasidzius.wriketests.retrofit2.folders.FieldMapForCreateFolder;
import com.vasidzius.wriketests.retrofit2.folders.Folder;
import com.vasidzius.wriketests.retrofit2.tasks.FieldMapForCreateTask;
import com.vasidzius.wriketests.retrofit2.tasks.Task;
import okhttp3.ResponseBody;
import org.json.JSONObject;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import ru.yandex.qatools.allure.annotations.Description;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

import static com.vasidzius.wriketests.retrofit2.RetrofitTestUtils.*;
import static org.junit.Assert.assertEquals;

public class RetrofitTest {

    WrikeService service = new CustomRetrofit().getService();

    @Description("Создание таски с помощью CustomFieldMap")
    @Test
    public void testCreateNewTaskWithCustomFieldMap() throws IOException {
        Call<ResponseBody> callCreateTask = service.createTaskWithFieldMap(
                getRootFolderId(this),
                FieldMapForCreateTask.Builder("with CustomFieldMap")
                        .description("Some description")
                        .importance(FieldMapForCreateTask.ImportanceEnum.HIGH)
                        .status(FieldMapForCreateTask.StatusEnum.CANCELLED)
                        .build()
        );

        Response<ResponseBody> responseFromCreate = callCreateTask.execute();
        customAssert(responseFromCreate);
        Task task = getItem(responseFromCreate, new TypeToken<Task>() {
        });
        String taskId = task.getId();
        Call<ResponseBody> callToDelete = service.deleteTask(taskId);
        Response<ResponseBody> responseFromDelete = callToDelete.execute();
        customAssert(responseFromDelete);
    }

    @Test
    public void testGetPartOfJson() throws IOException {

        JSONObject obj = new JSONObject(
                Files.toString(
                        new File(RetrofitTest.class.getResource("createTaskResponse.json").getFile()),
                        Charset.defaultCharset())
        );
        JSONObject jsonTask = (JSONObject) obj.getJSONArray("data").get(0);
        Gson gson = new Gson();
        Task task = gson.fromJson(jsonTask.toString(), Task.class);

        assertEquals("IEAGIITRKQAYHYM6", task.getId());
    }

    @Description("Создание/удаление таски")
    @Test
    public void testCreateDeleteTask() throws IOException {
        Call<ResponseBody> callToCreate = service.createTaskWithFieldMap(
                getRootFolderId(this),
                FieldMapForCreateTask.Builder("task for delete")
                        .build()
        );
        Response<ResponseBody> responseFromCreate = callToCreate.execute();
        customAssert(responseFromCreate);
        Task task = getItem(responseFromCreate, new TypeToken<Task>() {
        });
        String taskId = task.getId();
        Call<ResponseBody> callToDelete = service.deleteTask(taskId);
        Response<ResponseBody> responseFromDelete = callToDelete.execute();
        customAssert(responseFromDelete);
    }

    @Description("Получить folderTree и проверить id для rootFolder")
    @Test
    public void testGetFolderTree() throws IOException {
        Call<ResponseBody> callGetFolderTree = service.getFolders();
        Response<ResponseBody> response = callGetFolderTree.execute();
        customAssert(response);
        Folder folder = getItem(response, new TypeToken<Folder>() {
        });
        assertEquals("Root", folder.getTitle());
        assertEquals("IEAAO2AZI7777777", folder.getId());
    }

    @Description("Получить id корневой папки")
    @Test
    public void testGetRootFolderId() throws IOException {
        String rootFolderId = getRootFolderId(this);
        assertEquals("IEAAO2AZI7777777", rootFolderId);
    }

    @Description("Создать, затем удалить папку")
    @Test
    public void testCreateDeleteFolder() throws IOException {
        Call<ResponseBody> callCreateFolder = service.createFolder(
                getRootFolderId(this),
                FieldMapForCreateFolder.Builder("test folder AXYABS")
                        .description("test description")
                        .build()
        );
        Response<ResponseBody> responseCreate = callCreateFolder.execute();
        customAssert(responseCreate);
        Folder folder = getItem(responseCreate, new TypeToken<Folder>() {
        });
        Call<ResponseBody> callDeleteFolder = service.deleteFolder(folder.getId());
        Response<ResponseBody> responseDelete = callDeleteFolder.execute();
        customAssert(responseDelete);

    }

    @Description("Сломаный тест для проверки CustomAssert")
    @Test
    public void testBrokenForCheckCustomAssert() throws IOException {
        Call<ResponseBody> callCreateFolder = service.brokenRequest();
        Response<ResponseBody> response = callCreateFolder.execute();
        customAssert(response);
    }

    @Description("Взять таску по имени")
    @Test
    public void testGetTaskByName() throws IOException {
        Call<ResponseBody> callGetTaskByName = service.getTask("test123");
        Response<ResponseBody> response = callGetTaskByName.execute();
        customAssert(response);
    }


}
