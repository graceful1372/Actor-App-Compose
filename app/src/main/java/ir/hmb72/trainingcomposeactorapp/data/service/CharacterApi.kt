package ir.hmb72.trainingcomposeactorapp.data.service

import ir.hmb72.trainingcomposeactorapp.data.model.CharaterModel
import retrofit2.http.GET

interface CharacterApi {

    @GET("characters")
    suspend fun getCharacters():List<CharaterModel>
}