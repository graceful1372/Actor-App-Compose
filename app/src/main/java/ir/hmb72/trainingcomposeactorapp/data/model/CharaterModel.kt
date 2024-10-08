package ir.hmb72.trainingcomposeactorapp.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class CharaterModel(
    @Json(name = "actor")
    val actor:String ,
    @Json(name = "image")
    val image:String
)
