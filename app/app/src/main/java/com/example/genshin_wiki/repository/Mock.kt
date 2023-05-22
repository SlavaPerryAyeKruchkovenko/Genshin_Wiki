package com.example.genshin_wiki.repository

import com.example.genshin_wiki.models.CharacterProfile
import com.example.genshin_wiki.models.Element
import com.example.genshin_wiki.models.WeaponType

class Mock {
    enum class WeaponTypes {
        POLEARM, SWORD, BOW, CLAYMOR, CATALYST
    }
    enum class Elements {
        PYRO, HYDRO, GEO, ELECTRO, DENDRO, ANEMO
    }
    fun getCharacters(): List<CharacterProfile> {
        return getMockCharacters()
    }

    private fun getMockCharacters(): List<CharacterProfile> {
        return listOf(
            CharacterProfile(
                "1",
                "1",
                "https://drive.google.com/uc?export=view&id=10yvtmTVxxPuSah6VyNbPDE-boxKOZ0JD",
                "Яо Яо",
                4,
                getWeaponType(WeaponTypes.POLEARM),
                getWeaponElement(Elements.DENDRO)
            ),
            CharacterProfile(
                "2",
                "2",
                "https://drive.google.com/uc?export=view&id=1BBnFVb0ERkIxoI2ylxxnpVMjc4MbVLoc",
                "Джун ли",
                5,
                getWeaponType(WeaponTypes.POLEARM),
                getWeaponElement(Elements.GEO)
            ),
            CharacterProfile(
                "3",
                "3",
                "https://drive.google.com/uc?export=download&id=1oA9C6t28y5i1jtDIXc5vUvmG_ZAqeGKX",
                "Yoimiya",
                5,
                getWeaponType(WeaponTypes.BOW),
                getWeaponElement(Elements.PYRO)
            ),
        )
    }

    private fun getWeaponType(name: WeaponTypes): WeaponType {
        return when (name) {
            WeaponTypes.POLEARM -> {
                WeaponType("1", "Polearm", "https://drive.google.com/uc?export=view&id=19qGBZ66BEsslwYG3Q3nIKcpA5UDB9jkl")
            }
            WeaponTypes.CLAYMOR -> {
                WeaponType("2", "Claymor", "https://drive.google.com/uc?export=view&id=1WtN2EZXX8vB5PRf_XjYMYR48_RWiZXNk")
            }
            WeaponTypes.CATALYST -> {
                WeaponType("3", "Catalyst", "https://drive.google.com/uc?export=view&id=1VF11Eihy7JzoGkFTKT9iisgz2nlgtzrO")
            }
            WeaponTypes.BOW -> {
                WeaponType("4", "Bow", "https://drive.google.com/uc?export=view&id=1MZrqvsc5MAQna0fB7S3iGq93B5W8n_l-")
            }
            WeaponTypes.SWORD -> {
                WeaponType("5", "Sword", "https://drive.google.com/uc?export=view&id=15lCuwX6P62VBVk6V52jq17dY1J3M9bYE")
            }
            else -> {
                WeaponType("1", "Sword", "")
            }
        }
    }

    private fun getWeaponElement(name: Elements): Element {
        return when (name) {
            Elements.PYRO -> {
                Element("1", "Pyro", "https://drive.google.com/uc?export=view&id=10oEiogG0fguDv3qnGeZDGDffXbUxPJ1R")
            }
            Elements.ELECTRO -> {
                Element("2", "Electro", "https://drive.google.com/uc?export=view&id=19lmBJQf-0_1kKvT0NNzNtZAYAUuKiNqw")
            }
            Elements.DENDRO -> {
                Element("3", "Dendro", "https://drive.google.com/uc?export=view&id=1U1Sbh0uyVhVJKT-0WqW9f66Pj2GjjMQx")
            }
            Elements.GEO -> {
                Element("4", "Geo", "https://drive.google.com/uc?export=view&id=1od1d-kDi9sryTuBQzmh6g4PMGc4I1j6n")
            }
            else -> {
                Element("1", "10oEiogG0fguDv3qnGeZDGDffXbUxPJ1R", "")
            }
        }
    }
}