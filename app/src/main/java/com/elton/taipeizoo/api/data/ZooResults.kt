package com.elton.taipeizoo.api.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ZooResults(
    @SerializedName("_id")
    val _id: Int,
    @SerializedName("e_category")
    val e_category: String,
    @SerializedName("e_name")
    val e_name: String,
    @SerializedName("e_pic_url")
    val e_pic_url: String,
    @SerializedName("e_info")
    val e_info: String,
    @SerializedName("e_memo")
    var e_memo: String,
    @SerializedName("e_geo")
    val e_geo: String,
    @SerializedName("e_url")
    val e_url: String
) : Serializable