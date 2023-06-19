package com.example.genshin_wiki.data.models.enums

import com.example.genshin_wiki.R

enum class WeaponTypes(val value: Int) {
    POLEARM(R.string.polearm), SWORD(R.string.sword), BOW(R.string.bow),
    CLAYMOR(R.string.claymor), CATALYST(R.string.catalyst),NoData(R.string.no_data)
}