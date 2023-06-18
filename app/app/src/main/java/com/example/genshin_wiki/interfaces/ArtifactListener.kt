package com.example.genshin_wiki.interfaces

import com.example.genshin_wiki.models.Artifact

interface ArtifactListener {
    fun onClick(profile: Artifact)
}