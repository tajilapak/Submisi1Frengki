package com.example.frengki.submisi1frengki

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KlubBola(val nama : String, val logo : Int, val keterangan : String, val berdiri : String, val stadion : String, val pelatih : String) : Parcelable
