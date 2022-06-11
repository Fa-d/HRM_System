package go.faddy.hmrsystem.api

import com.haroldadmin.cnradapter.NetworkResponse
import go.faddy.hmrsystem.models.CustomerBalanceModel
import go.faddy.hmrsystem.models.ErrorResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("api/customerBal/{customerCode}")
    suspend fun getCustomerBalance(@Path("customerCode") customerCode: String): NetworkResponse<List<CustomerBalanceModel>, ErrorResponse>

}