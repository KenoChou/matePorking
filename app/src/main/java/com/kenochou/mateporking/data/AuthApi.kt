package com.kenochou.mateporking.data

import com.google.gson.JsonElement
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

data class ApiResult<T>(
    val code: Int,
    val message: String,
    val data: T?
)

data class SendSmsRequest(
    val phone: String,
    val scene: String = "LOGIN"
)

data class SmsLoginRequest(
    val phone: String,
    val code: String,
    val deviceId: String,
    val deviceName: String
)

interface AuthApi {
    @POST("api/v1/auth/sms/send")
    suspend fun sendSms(@Body request: SendSmsRequest): ApiResult<JsonElement>

    @POST("api/v1/auth/sms/login")
    suspend fun login(@Body request: SmsLoginRequest): ApiResult<JsonElement>
}

object ApiClient {
    // Replace with the deployed AniMate API Gateway URL; keep the trailing slash.
    private const val BASE_URL = "https://api.example.com/"

    val auth: AuthApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthApi::class.java)
    }
}
