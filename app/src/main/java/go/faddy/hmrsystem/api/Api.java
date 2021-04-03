package go.faddy.hmrsystem.api;

import go.faddy.hmrsystem.api.responses.CarFetchResponseModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("/orders")
    Call<CarFetchResponseModel> getCarModels();


}
