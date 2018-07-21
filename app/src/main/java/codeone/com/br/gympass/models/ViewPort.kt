package codeone.com.br.gympass.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ViewPort(
        var northeast:NorthEast,
        var southwest:SouthwEst
):Parcelable {
}