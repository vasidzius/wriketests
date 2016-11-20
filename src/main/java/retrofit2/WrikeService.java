package retrofit2;

import okhttp3.ResponseBody;
import retrofit2.http.*;

public interface WrikeService {

    @FormUrlEncoded
    @POST("folders/IEAAO2AZI7777777/tasks?access_token=0hKcygd0xc8vZkcFDTcQ1yc8NNTfPQWQbYPRBqDxZs5ucmzVgFnPuhTuU5IkjSti-N-WFIUK")
    Call<ResponseBody> createTask(@Field("title") String title);

}
