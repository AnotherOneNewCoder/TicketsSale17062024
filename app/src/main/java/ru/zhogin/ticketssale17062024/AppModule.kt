package ru.zhogin.ticketssale17062024

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import ru.zhogin.app.api.DirectsApi
import ru.zhogin.app.api.MusicflyApi
import ru.zhogin.app.api.TicketsApi
import ru.zhogin.app.database.TicketsDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesTicketsApi(okHttpClient: OkHttpClient?) : TicketsApi {
        return TicketsApi(
            baseUrl = TICKETS_URL,
            okHttpClient = okHttpClient,
        )
    }
    @Provides
    @Singleton
    fun providesDirectsApi(okHttpClient: OkHttpClient?) : DirectsApi {
        return DirectsApi(
            baseUrl = DIRECTS_URL,
            okHttpClient = okHttpClient
        )
    }
    @Provides
    @Singleton
    fun providesMusicflyApi(okHttpClient: OkHttpClient?) : MusicflyApi {
        return MusicflyApi(
            baseUrl = MUSIC_FLY_URL,
            okHttpClient = okHttpClient
        )
    }
    @Provides
    @Singleton
    fun providesTicketsDatabase(@ApplicationContext context: Context) : TicketsDatabase {
        return TicketsDatabase(context)
    }
}

private const val MUSIC_FLY_URL = "https://run.mocky.io/v3/214a1713-bac0-4853-907c-a1dfc3cd05fd"
private const val DIRECTS_URL = "https://run.mocky.io/v3/7e55bf02-89ff-4847-9eb7-7d83ef884017"
private const val TICKETS_URL = "https://run.mocky.io/v3/670c3d56-7f03-4237-9e34-d437a9e56ebf"
