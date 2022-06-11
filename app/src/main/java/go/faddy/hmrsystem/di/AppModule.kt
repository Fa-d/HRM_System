package go.faddy.hmrsystem.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import go.faddy.hmrsystem.api.ApiService
import go.faddy.hmrsystem.utils.Constants
import go.faddy.hmrsystem.utils.RetrofitUtils.retrofitInstance
import okhttp3.OkHttpClient
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Named("apiHRMSYS")
    fun provideBaseUrlMovies1() = Constants.BASE_URL

    @Provides
    @Singleton
    fun provideRetrofitInstance1(
        @Named("apiHRMSYS") BASE_URL: String,
        gson: Gson,
        httpClient: OkHttpClient
    ): ApiService =
        retrofitInstance(baseUrl = BASE_URL, gson, httpClient)
            .create(ApiService::class.java)


}