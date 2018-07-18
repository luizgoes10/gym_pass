package codeone.com.br.gympass.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Features(
        @SerializedName("html_attributions")
        var htmlAttributions: Array<String>,
        @SerializedName("next_page_token")
        var nextPageToken:String,
        var result:Array<Company>
) : Parcelable