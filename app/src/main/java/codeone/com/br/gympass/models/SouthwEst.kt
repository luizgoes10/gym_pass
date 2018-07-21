package codeone.com.br.gympass.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SouthwEst(
        var lat:Double,
        var lng:Double
):Parcelable {
}