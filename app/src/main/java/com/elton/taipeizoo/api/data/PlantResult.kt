package com.elton.taipeizoo.api.data

import com.google.gson.annotations.SerializedName

data class PlantResult(
    @SerializedName("limit")
    val limit: Int,
    @SerializedName("offset")
    val offset: Int,
    @SerializedName("count")
    val count: Int,
    @SerializedName("sort")
    val sort: String,
    @SerializedName("results")
    val results: ArrayList<PlantResults>
)