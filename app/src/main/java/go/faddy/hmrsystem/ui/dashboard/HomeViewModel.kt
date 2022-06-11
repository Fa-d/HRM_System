package go.faddy.hmrsystem.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.haroldadmin.cnradapter.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import go.faddy.hmrsystem.models.CustomerBalanceModel
import go.faddy.hmrsystem.repository.AppRepository
import go.faddy.hmrsystem.utils.Constants.exhaustive
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class HomeViewModel
@Inject
constructor(private val repository: AppRepository) : ViewModel() {

    fun getCustomerBalance(customerCode: String): LiveData<List<CustomerBalanceModel>> {
        val responseBody = MutableLiveData<List<CustomerBalanceModel>>()
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCustomerBalance(customerCode)
            withContext(Dispatchers.Main) {
                when (response) {
                    is NetworkResponse.Success -> {
                        responseBody.value = response.body
                    }
                    is NetworkResponse.ServerError -> {
                        val message =
                            "দুঃখিত, এই মুহূর্তে আমাদের সার্ভার কানেকশনে সমস্যা হচ্ছে, কিছুক্ষণ পর আবার চেষ্টা করুন"
                    }
                    is NetworkResponse.NetworkError -> {
                        val message = "দুঃখিত, এই মুহূর্তে আপনার ইন্টারনেট কানেকশনে সমস্যা হচ্ছে"
                    }
                    is NetworkResponse.UnknownError -> {
                        val message = "কোথাও কোনো সমস্যা হচ্ছে, আবার চেষ্টা করুন"
                    }
                }.exhaustive
            }
        }
        return responseBody
    }


}