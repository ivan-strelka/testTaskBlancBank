package api.utils

import api.constants.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class RetrofitUtils {

    val jsonMapper = com.fasterxml.jackson.module.kotlin.jacksonObjectMapper()

        var logging: HttpLoggingInterceptor = HttpLoggingInterceptor(PrettyLogger())
        var client = OkHttpClient()
            .newBuilder()
            .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        fun getRetrofit(): Retrofit? {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create(jsonMapper))
                .build()
        }




}