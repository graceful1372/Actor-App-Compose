package ir.hmb72.trainingcomposeactorapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import ir.hmb72.trainingcomposeactorapp.data.model.CharaterModel
import ir.hmb72.trainingcomposeactorapp.data.repository.CharacterRepo
import ir.hmb72.trainingcomposeactorapp.utils.retrofit.RetrofitInstance
import ir.hmb72.trainingcomposeactorapp.utils.themes.theme.TrainingComposeActorAppTheme
import ir.hmb72.trainingcomposeactorapp.viewmodel.CharacterViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TrainingComposeActorAppTheme {
                val api = RetrofitInstance.provideApi(RetrofitInstance.provideRetrofit())
                val repository = CharacterRepo(api)
                val viewModel = CharacterViewModel(repository)
                MainScreen(viewModel = viewModel)

            }
        }
    }
}

@Composable
fun MainScreen(viewModel: CharacterViewModel) {
    val characterz by viewModel.state.collectAsState()

    //Filtering the actors with images
    val nonEmptyList = mutableListOf<CharaterModel>()
    characterz.forEach{
        if (it.image.isNotEmpty()){
            nonEmptyList.add(it)
        }
    }
    ActorsList(characterList = nonEmptyList)

}

@Composable
fun ActorsList(characterList: List<CharaterModel>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.padding(8.dp)
    ) {
        items(items = characterList) { item ->
            CardItem(charaterModel = item)


        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CardItem(charaterModel: CharaterModel) {
    Column {

        GlideImage(
            model = charaterModel.image,
            contentDescription = "Character image",
            modifier = Modifier
                .padding(4.dp)
                .size(width = 140.dp, height = 180.dp)
        )

        Text(text = charaterModel.actor, fontSize = 20.sp)


    }
}














