package codeone.com.br.gympass.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OpenNow(
        @SerializedName("open_now")
        var openNow: Boolean
) :Parcelable{
}