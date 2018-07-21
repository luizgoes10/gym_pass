package codeone.com.br.gympass.models

import android.os.Parcelable
import codeone.com.br.gympass.api.BaseUrl
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photos(
        var height:Int,

        @SerializedName("html_attributions")
        var htmlAttribution:Array<String>,

        @SerializedName("photo_reference")
        var photoReference:String,

        var width:Int
):Parcelable {
       fun imgReference() : String = BaseUrl.PHOTO + "maxwidth=120&maxheight=150&photoreference=" + photoReference + "&key=" + BaseUrl.API_KEY

}