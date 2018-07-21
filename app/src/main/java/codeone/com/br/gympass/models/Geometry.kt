package codeone.com.br.gympass.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Geometry(
        var location:Location,
        @SerializedName("viewport")
        var viewPort:ViewPort
):Parcelable {
}