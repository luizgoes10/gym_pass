package codeone.com.br.gympass.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Company(
        //Testar esse mapeamento
        var geometry:Array<String>,

        var icon:String,

        var id:String,

        var name:String,

        var photos:Array<Photos>,

        @SerializedName("place_id")
        var placeId:String,

        //Testar esse mapeamento
        @SerializedName("plus_code")
        var plusCode:Array<String>,

        var rating:Double,

        var reference:String,

        var scope:String,

        var types:Array<String>,

        var vicinity:String
):Parcelable {
}