package go.faddy.hmrsystem.api;

import java.util.List;

import go.faddy.hmrsystem.api.responses.SupplierFetchResponseModel;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {


    @GET("suppliers")
    Call<List<SupplierFetchResponseModel>> getSupplierListJSON(
//            @Field("supcode") int supcode,
//            @Field("supname") String supname,
//            @Field("invnum") int invnum,
//            @Field("invdate") String invdate,
//            @Field("debit") int debit,
//            @Field("credit") int credit
    );

    @FormUrlEncoded
    @POST("update")
    Call<SupplierFetchResponseModel> updateUser(
            @Field("id") String id,
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("address") String address
    );


    @FormUrlEncoded
    @POST("supplierspost")
    Call<List<SupplierFetchResponseModel>> SearchItem(
            @Field("sCode") String sCode,
            @Field("sName") String sName
    );




}
