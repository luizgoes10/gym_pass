package codeone.com.br.gympass.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photos(
        var height:Int,

        @SerializedName("html_attribution")
        var htmlAttribution:Array<String>,

        @SerializedName("photo_reference")
        var photoReference:String,

        var width:Int
):Parcelable {
}