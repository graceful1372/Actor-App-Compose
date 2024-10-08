package ir.hmb72.trainingcomposeactorapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.hmb72.trainingcomposeactorapp.data.model.CharaterModel
import ir.hmb72.trainingcomposeactorapp.data.repository.CharacterRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(val characterRepo: CharacterRepo):ViewModel() {

    private val _state = MutableStateFlow(emptyList<CharaterModel>())
    val state:StateFlow<List<CharaterModel>>
        get() = _state
    init {
        viewModelScope.launch {
            val character = characterRepo.getCharacters()
            _state.value = character
        }
    }
}