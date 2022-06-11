package go.faddy.hmrsystem.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CustomerBalanceModel(
    @SerializedName("credit")
    var credit: Int = 0,
    @SerializedName("cusname")
    var cusname: String = "",
    @SerializedName("debit")
    var debit: Int = 0,
    @SerializedName("doctype")
    var doctype: String = "",
    @SerializedName("invdate")
    var invdate: String = "",
    @SerializedName("invnum")
    var invnum: String = ""
) : Parcelable