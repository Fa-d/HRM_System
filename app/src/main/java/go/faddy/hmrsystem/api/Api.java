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
    Call<List<SupplierFetchResponseModel>> getSupplierListJSON();

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
            @Field("sCode") String sCode
//            @Field("sName") String sName
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
    @POST("suppliersinsert")
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
