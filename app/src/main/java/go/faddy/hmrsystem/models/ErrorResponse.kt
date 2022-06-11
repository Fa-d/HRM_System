package go.faddy.hmrsystem.models

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("Message")
    var message: String? = ""
)