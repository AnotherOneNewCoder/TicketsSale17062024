package ru.zhogin.app.api

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.create
import retrofit2.http.GET
import ru.zhogin.app.api.models.directs.TicketOffersDTO
import ru.zhogin.app.api.models.musicfly.OffersDTO
import ru.zhogin.app.api.models.tickets.TicketsDTO

interface TicketsApi {
    // since mocky link is dead
//    @GET("v3/670c3d56-7f03-4237-9e34-d437a9e56ebf")
//    suspend fun getTickets() : Result<TicketsDTO>

    @GET("uc?export=download&id=1HogOsz4hWkRwco4kud3isZHFQLUAwNBA")
    suspend fun getTickets() : Result<TicketsDTO>
}
interface MusicflyApi {
    // since mocky link is dead
//    @GET("v3/214a1713-bac0-4853-907c-a1dfc3cd05fd")
//    suspend fun getMusicFly() : Result<OffersDTO>

    @GET("uc?export=download&id=1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav")
    suspend fun getMusicFly() : Result<OffersDTO>
}

interface DirectsApi {
    // since mocky link is dead
//    @GET("v3/7e55bf02-89ff-4847-9eb7-7d83ef884017")
//    suspend fun getDirects() : Result<TicketOffersDTO>

    @GET("uc?export=download&id=13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta")
    suspend fun getDirects() : Result<TicketOffersDTO>
}

fun TicketsApi(
    baseUrl: String,
    okHttpClient: OkHttpClient? = null,
    json: Json = Json
) : TicketsApi {
    return  retrofit(baseUrl, okHttpClient, json).create()
}
fun DirectsApi(
    baseUrl: String,
    okHttpClient: OkHttpClient? = null,
    json: Json = Json
) : DirectsApi {
    return  retrofit(baseUrl, okHttpClient, json).create()
}

fun MusicflyApi(
    baseUrl: String,
    okHttpClient: OkHttpClient? = null,
    json: Json = Json
) : MusicflyApi {
    return  retrofit(baseUrl, okHttpClient, json).create()
}

fun retrofit(
    baseUrl: String,
    okHttpClient: OkHttpClient?,
    json: Json,
) : Retrofit {
    val jsonConverterFactory = json.asConverterFactory("application/json".toMediaType())
    val modifiedClient : OkHttpClient = (okHttpClient?.newBuilder() ?: OkHttpClient.Builder())
        .build()

    return Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(jsonConverterFactory)
        .addCallAdapterFactory(ResultCallAdapterFactory.create())
        .client(modifiedClient)
        .build()
}