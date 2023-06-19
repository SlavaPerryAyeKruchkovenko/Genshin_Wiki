package com.example.genshin_wiki.data.responses

import com.google.gson.annotations.SerializedName

class ArtifactListResponse(
    @SerializedName("data") val artifacts: List<ArtifactResponse>
)