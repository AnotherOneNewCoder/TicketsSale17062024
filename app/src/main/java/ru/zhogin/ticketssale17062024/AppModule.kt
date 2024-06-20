package ru.zhogin.ticketssale17062024

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import ru.zhogin.app.api.DirectsApi
import ru.zhogin.app.api.MusicflyApi
import ru.zhogin.app.api.TicketsApi
import ru.zhogin.app.database.TicketsDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor) : OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()



    @Provides
    @Singleton
    fun providesTicketsApi(okHttpClient: OkHttpClient?) : TicketsApi {
        return TicketsApi(
            baseUrl = BASE_URL,
            okHttpClient = okHttpClient,
        )
    }
    @Provides
    @Singleton
    fun providesDirectsApi(okHttpClient: OkHttpClient?) : DirectsApi {
        return DirectsApi(
            baseUrl = BASE_URL,
            okHttpClient = okHttpClient
        )
    }
    @Provides
    @Singleton
    fun providesMusicflyApi(okHttpClient: OkHttpClient?) : MusicflyApi {
        return MusicflyApi(
            baseUrl = BASE_URL,
            okHttpClient = okHttpClient
        )
    }
    @Provides
    @Singleton
    fun providesTicketsDatabase(@ApplicationContext context: Context) : TicketsDatabase {
        return TicketsDatabase(context)
    }
}

private const val BASE_URL = "https://run.mocky.io/"
private const val BASE_URL_GOOGLE_DRIVE = "https://drive.google.com/"
