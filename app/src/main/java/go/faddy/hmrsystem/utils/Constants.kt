package go.faddy.hmrsystem.utils

object Constants {

    const val BASE_URL = "https://hmr-sys.herokuapp.com/"
    const val CUSTOMER_BALANCE_END_POINT = "api/customerBal/"

    val <T> T.exhaustive: T
        get() = this

}