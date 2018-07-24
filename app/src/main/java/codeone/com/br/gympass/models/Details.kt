package codeone.com.br.gympass.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Details(

        @SerializedName("html_attributions")
        var htmlAttributions:MutableList<String>,

        var result: MutableList<CompanyDetails>,

        var status:String

):Parcelable {
}