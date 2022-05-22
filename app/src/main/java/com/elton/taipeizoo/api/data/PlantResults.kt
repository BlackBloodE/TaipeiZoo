package com.elton.taipeizoo.api.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PlantResults(
    @SerializedName("_id")
    val _id: Int,
    @SerializedName("\ufeffF_Name_Ch")  // 編碼問題...
    val name_Ch: String,
    @SerializedName("F_Summary")
    val summary: String,
    @SerializedName("F_Keywords")
    val keywords: String,
    @SerializedName("F_AlsoKnown")
    val alsoKnow: String,
    @SerializedName("F_Geo")
    var geo: String,
    @SerializedName("F_Location")
    val location: String,
    @SerializedName("F_Name_En")
    val name_En: String,
    @SerializedName("F_Name_Latin")
    val name_Latin: String,
    @SerializedName("F_Family")
    val family: String,
    @SerializedName("F_Genus")
    val genus: String,
    @SerializedName("F_Brief")
    val brief: String,
    @SerializedName("F_Feature")
    val feature: String,
    @SerializedName("F_Function＆Application")
    val fun_app: String,
    @SerializedName("F_Code")
    val code: String,
    @SerializedName("F_Pic01_ALT")
    val pic01_ALT: String,
    @SerializedName("F_Pic01_URL")
    val pic01_URL: String,
    @SerializedName("F_Pic02_ALT")
    val pic02_ALT: String,
    @SerializedName("F_Pic02_URL")
    val pic02_URL: String,
    @SerializedName("F_Pic03_ALT")
    val pic03_ALT: String,
    @SerializedName("F_Pic03_URL")
    val pic03_URL: String,
    @SerializedName("F_Pic04_ALT")
    val pic04_ALT: String,
    @SerializedName("F_Pic04_URL")
    val pic04_URL: String,
    @SerializedName("F_pdf01_ALT")
    val pdf01_ALT: String,
    @SerializedName("F_pdf01_URL")
    val pdf01_URL: String,
    @SerializedName("F_pdf02_ALT")
    val pdf02_ALT: String,
    @SerializedName("F_pdf02_URL")
    val pdf02_URL: String,
    @SerializedName("F_Voice01_ALT")
    val voice01_ALT: String,
    @SerializedName("F_Voice01_URL")
    val voice01_URL: String,
    @SerializedName("F_Voice02_ALT")
    val voice02_ALT: String,
    @SerializedName("F_Voice02_URL")
    val voice02_URL: String,
    @SerializedName("F_Voice03_ALT")
    val voice03_ALT: String,
    @SerializedName("F_Voice03_URL")
    val voice03_URL: String,
    @SerializedName("F_Vedio_URL")  // 這是拼錯?
    val video_URL: String,
    @SerializedName("F_Update")
    val update: String,
    @SerializedName("F_CID")
    val CID: String
) : Serializable