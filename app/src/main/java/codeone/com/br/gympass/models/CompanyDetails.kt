package codeone.com.br.gympass.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CompanyDetails(

        @SerializedName("address_components")
        var result:MutableList<AddressComponents>,

        @SerializedName("adr_address")
        var adrAddress:String,

        @SerializedName("formatted_address")
        var formattedAddress:String,

        @SerializedName("formatted_phone_number")
        var formattedPhoneNumber:String,

        var geometry: Geometry,

        var icon:String,

        var id:String,

        @SerializedName("international_phone_number")
        var internationalPhoneNumber:String,

        var name:String,

        var photos:MutableList<Photos>,

        @SerializedName("place_id")
        var placeId:String,

        @SerializedName("plus_code")
        var plusCode:PlusCode,

        var rating:Double,

        var reference:String,

        var reviews:MutableList<Reviews>,

        var scope:String,

        var types:MutableList<String>,

        var url:String,

        @SerializedName("utc_offset")
        var utcOffSet:Int,

        var vicinity:String,

        var website:String

):Parcelable {
}