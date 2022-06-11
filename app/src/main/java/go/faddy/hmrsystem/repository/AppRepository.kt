package go.faddy.hmrsystem.repository

import go.faddy.hmrsystem.api.ApiService
import javax.inject.Inject


class AppRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getCustomerBalance(customerCode: String) = apiService.getCustomerBalance(customerCode)

}