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

    @GET("v3/c0464573-5a13-45c9-89f8-717436748b69")
    suspend fun getTickets() : Result<TicketsDTO>
    // since mocky link was dead
//    @GET("uc?export=download&id=1HogOsz4hWkRwco4kud3isZHFQLUAwNBA")
//    suspend fun getTickets() : Result<TicketsDTO>
}
interface MusicflyApi {

    @GET("v3/ad9a46ba-276c-4a81-88a6-c068e51cce3a")
    suspend fun getMusicFly() : Result<OffersDTO>
    // since mocky link was dead
//    @GET("uc?export=download&id=1o1nX3uFISrG1gR-jr_03Qlu4_KEZWhav")
//    suspend fun getMusicFly() : Result<OffersDTO>
}

interface DirectsApi {

    @GET("v3/38b5205d-1a3d-4c2f-9d77-2f9d1ef01a4a")
    suspend fun getDirects() : Result<TicketOffersDTO>
    // since mocky link was dead
//    @GET("uc?export=download&id=13WhZ5ahHBwMiHRXxWPq-bYlRVRwAujta")
//    suspend fun getDirects() : Result<TicketOffersDTO>
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