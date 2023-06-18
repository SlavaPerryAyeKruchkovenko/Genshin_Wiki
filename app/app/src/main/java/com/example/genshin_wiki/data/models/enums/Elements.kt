package com.example.genshin_wiki.data.models.enums

import com.example.genshin_wiki.R

enum class Elements(val text: Int,val colorAttr: Int) {
    PYRO(R.string.pyro,R.attr.colorPyro), HYDRO(R.string.hydro,R.attr.colorHydro),
    GEO(R.string.geo,R.attr.colorGeo), ELECTRO(R.string.electro,R.attr.colorElectro),
    DENDRO(R.string.dendro,R.attr.colorDendro), ANEMO(R.string.anemo,R.attr.colorAnemo),
    CRYO(R.string.cryo,R.attr.colorCryo)
}