package kofesutra.cryptolist.dataloader

import kofesutra.cryptolist.dataloader.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {

    val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    val httpClient = OkHttpClient.Builder().addInterceptor(logging)

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient.build()) // httpInterceptor
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}