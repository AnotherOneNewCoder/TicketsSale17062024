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
//    @GET
//    suspend fun getMusicFly() : Result<OffersDTO>
//    @GET
//    suspend fun getDirects() : Result<TicketOffersDTO>
    @GET
    suspend fun getTickets() : Result<TicketsDTO>
}
interface MusicflyApi {
    @GET
    suspend fun getMusicFly() : Result<OffersDTO>
}

interface DirectsApi {
    @GET
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