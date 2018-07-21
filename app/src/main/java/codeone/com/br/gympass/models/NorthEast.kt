package codeone.com.br.gympass.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NorthEast(
        var lat:Double,
        var lng:Double
):Parcelable {
}