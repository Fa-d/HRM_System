package go.faddy.hmrsystem.api;

import java.util.List;

import go.faddy.hmrsystem.api.responses.UserFetchResponseModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
    @Headers({"Accept: application/json"})
    @GET("users")
    Call<List<UserFetchResponseModel>> getCarModels();

    @FormUrlEncoded
    @POST("users")
    Call<UserFetchResponseModel> insertNewUser(
            @Field("name") String CarName,
            @Field("phone") String Owner,
            @Field("address") String Model
    );

    @FormUrlEncoded
    @POST("update")
    Call<UserFetchResponseModel> updateUser(
            @Field("id") String id,
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("address") String address
    );


    @FormUrlEncoded
    @POST("delete")
    Call<UserFetchResponseModel> deleteUser(
            @Field("id") String id
    );
}
