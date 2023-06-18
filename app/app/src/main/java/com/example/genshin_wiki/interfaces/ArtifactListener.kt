package com.example.genshin_wiki.interfaces

import com.example.genshin_wiki.data.models.Artifact

interface ArtifactListener {
    fun onClick(profile: Artifact)
}