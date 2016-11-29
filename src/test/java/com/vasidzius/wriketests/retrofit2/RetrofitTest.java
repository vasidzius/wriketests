package com.vasidzius.wriketests.retrofit2;

import com.vasidzius.wriketests.retrofit2.fieldmaps.FieldMapForCreateTask;
import okhttp3.ResponseBody;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;

public class RetrofitTest extends RetrofitBaseTest {

    @Test
    public void testCreateNewTaskInRootCatalog() throws IOException {

        Call<ResponseBody> call = service.createTask("testCreateNewTaskInRootCatalog999");
        Response<ResponseBody> response = call.execute();
        assertTrue(response.isSuccessful());
        System.out.println(response.body().string());
    }

    @Test
    public void testCreateNewTaskWithFieldMap() throws IOException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "withMapField44");
        map.put("status", "completed");
        map.put("title", "withMapField55");
        Call<ResponseBody> call = service.createTaskWithFieldMap(map);
        Response<ResponseBody> response = call.execute();
        assertTrue(response.isSuccessful());
        System.out.println(response.code());
        System.out.println(response.body().string());
    }

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

    //

}
