package com.elton.taipeizoo.api

import com.elton.taipeizoo.api.data.PlantData
import com.elton.taipeizoo.api.data.ZooData
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {
    @GET(APIConfig.ZOOM)
    suspend fun getZoomList(): Response<ZooData>

    @GET(APIConfig.PLANT)
    suspend fun getPlantList(): Response<PlantData>
}