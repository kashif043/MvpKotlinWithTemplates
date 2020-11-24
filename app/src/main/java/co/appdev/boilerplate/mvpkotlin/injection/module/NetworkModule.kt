package co.appdev.boilerplate.mvpkotlin.injection.module

import co.appdev.boilerplate.mvpkotlin.data.local.SharedPrefHelper
import co.appdev.boilerplate.mvpkotlin.data.remote.ApiService
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun providesInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    internal fun provideOkhttpClient(interceptor: HttpLoggingInterceptor?, sharedPrefHelper: SharedPrefHelper): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor!!)
            .addInterceptor { chain: Interceptor.Chain ->
                val request = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Authorization", "Bearer " + sharedPrefHelper.token)
                    .build()
                chain.proceed(request)
            }.build()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(gson: Gson?, okHttpClient: OkHttpClient?): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson!!))
            .baseUrl(ApiService.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient!!)
            .build()
    }

    @Provides
    @Singleton
    internal fun providesApiInterface(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}