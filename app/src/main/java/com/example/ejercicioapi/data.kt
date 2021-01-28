package com.cbellmont.ejemplodescargainternet

import com.google.gson.annotations.SerializedName

data class data(
    var title: String,
    @SerializedName("ID Nation")var id: String,
    @SerializedName("Nation")var nation: String,
    var director: String,
    var producer: String,
    var url: String,
    var created: String,
    var edited: String,
    @SerializedName("ID Year")var idyear : Int,
    @SerializedName("Year")var year: String,
    @SerializedName("Population")var population : String,
    @SerializedName("Slug Nation")var slugnation: String)

    {

    override fun toString(): String {
        return "El $id pertenece a $nation"
    }
}