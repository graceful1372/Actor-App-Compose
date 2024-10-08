package ir.hmb72.trainingcomposeactorapp.data.repository

import ir.hmb72.trainingcomposeactorapp.data.model.CharaterModel
import ir.hmb72.trainingcomposeactorapp.data.service.CharacterApi

class CharacterRepo(private val characterApi: CharacterApi) {
    suspend fun getCharacters():List<CharaterModel>{
        return characterApi.getCharacters()
    }

}