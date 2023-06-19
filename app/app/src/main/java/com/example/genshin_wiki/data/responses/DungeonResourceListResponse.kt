package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

data class DungeonResourceListResponse(
    @SerializedName("data") val resources: List<DungeonResourceResponse>
)
