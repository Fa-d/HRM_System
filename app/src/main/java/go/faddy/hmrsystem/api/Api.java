package go.faddy.hmrsystem.api;

import java.util.List;

import go.faddy.hmrsystem.api.responses.SupplierFetchResponseModel;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface Api {


    @GET("suppliers")
    Call<List<SupplierFetchResponseModel>> getSupplierListJSON();

    @FormUrlEncoded
    @POST("update")
    Call<SupplierFetchResponseModel> updateUser(
            @Field("id") String id,
            @Field("name") String name,
            @Field("phone") String phone,
            @Field("address") String address
    );


    @GET("suppliers/{id}")
    Call<List<SupplierFetchResponseModel>> SearchItem(
            @Path("id") String sCode
//            @Field("sName") String sName
    );


    @DELETE("suppliers/{id}")
    Call<List<SupplierFetchResponseModel>> deletePost(
//            @Field("id") String sCode,
            @Path("id") String sCode1
    );

    @FormUrlEncoded
    @POST("updatedebit")
    Call<List<SupplierFetchResponseModel>> UpdateDebitCredit(
            @Field("supcode") String supcode,
            @Field("supname") String supname,
            @Field("invnum") String invnum,
            @Field("debit") int debit,
            @Field("credit") int credit
    );

    @FormUrlEncoded
    @POST("suppliers")
    Call<List<SupplierFetchResponseModel>> insertIntoSupplierBal(
            @Field("sCode") String supcode,
            @Field("sName") String supname,
            @Field("invNum") String invnum,
            @Field("docType") String doctype,
            @Field("date") String invdate,
            @Field("debit") int debit,
            @Field("credit") int credit
    );

}
