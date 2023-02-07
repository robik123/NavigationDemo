package edu.quinnipiac.ser210.ls03_nav_demo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
class Money( val amount: BigDecimal): Parcelable {
}