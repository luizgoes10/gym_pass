package codeone.com.br.gympass.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddressComponents(

        @SerializedName("long_name")
        var longName:String,

        @SerializedName("short_name")
        var shortName:String,

        var types:MutableList<String>

):Parcelable {
}