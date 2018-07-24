package codeone.com.br.gympass.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Reviews(

        @SerializedName("author_name")
        var authorName:String,

        @SerializedName("author_url")
        var authorUrl:String,

        var language:String,

        @SerializedName("profile_photo_url")
        var profilePhotoUrl:String,

        var rating:Double,

        @SerializedName("relative_time_description")
        var relativeTimeDescription:String,

        var text:String,

        var time:Int

) :Parcelable{
}