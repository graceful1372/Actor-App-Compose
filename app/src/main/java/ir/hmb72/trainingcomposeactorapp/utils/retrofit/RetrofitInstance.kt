package ir.hmb72.trainingcomposeactorapp.utils.retrofit

import ir.hmb72.trainingcomposeactorapp.data.service.CharacterApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    fun provideApi(builder:Retrofit.Builder): CharacterApi {
        return builder
            .build()
            .create(CharacterApi::class.java)
    }

    fun provideRetrofit():Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://hp-api.onrender.com/api/")
            .addConverterFactory(MoshiConverterFactory.create())

    }
}