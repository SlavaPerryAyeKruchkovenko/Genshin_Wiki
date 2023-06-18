package com.example.genshin_wiki.data.models.enums

import com.example.genshin_wiki.R

enum class Stats(val value: Int) {
    ATK(R.string.ATK), ATK_PER(R.string.ATK_PER), DEF(R.string.DEF), DEF_PER(R.string.DEF_PER),
    HP(R.string.HP), HP_PER(R.string.HP_PER), EM(R.string.EM), CRIT_DMG(R.string.CRIT_DMG),
    CRIT_RATE(R.string.CRIT_RATE), ER_PER(R.string.ER_PER), HEAL_PER(R.string.HEAL_PER),
    PHYS_DMG(R.string.PHYS_DMG), PYRO_DMG(R.string.PYRO_DMG), DENDRO_DMG(R.string.DENDRO_DMG),
    GEO_DMG(R.string.GEO_DMG), HYDRO_DMG(R.string.HYDRO_DMG), ELECTRO_DMG(R.string.ELECTRO_DMG),
    ANEMO_DMG(R.string.ANEMO_DMG), CRYO_DMG(R.string.CRYO_DMG)
}