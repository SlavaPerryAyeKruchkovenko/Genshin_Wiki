package com.example.genshin_wiki.repository

import com.example.genshin_wiki.models.*
import com.example.genshin_wiki.models.enums.Stats

class Mock {
    enum class WeaponTypes {
        POLEARM, SWORD, BOW, CLAYMOR, CATALYST
    }

    enum class Elements {
        PYRO, HYDRO, GEO, ELECTRO, DENDRO, ANEMO
    }

    fun getCharacters(): List<CharacterProfile> = getMockCharacters()

    fun getWeapons(): List<Weapon> = getMockWeapons()
    fun getResources(): List<DungeonResource> = getMockResources()
    private fun getMockWeapons(): List<Weapon> {
        return listOf(
            Weapon(
                "1",
                "Calamity Queller",
                "test",
                getWeaponType(WeaponTypes.POLEARM),
                "Extinguishing Precept",
                5,
                Stats.ATK,
                Stats.ATK_PER,
                "https://drive.google.com/file/d/1kABfbqHoLSHFRi-bnfLNK5cnIo3hVS3T/view"
            ),
            Weapon(
                "2",
                "Staff of Homa",
                "A “firewood staff” that was once used in ancient and long-lost rituals.",
                getWeaponType(WeaponTypes.POLEARM),
                "test",
                5,
                Stats.ATK,
                Stats.CRIT_DMG,
                "https://drive.google.com/file/d/1alsqPm_g-dJus2YPtJuuQy_uon7R11K3/view"
            ),
            Weapon(
                "3",
                "Engulfing Lightning",
                "A naginata used to ''cut grass.'' Any army that stands before this weapon will probably be likewise cut down...",
                getWeaponType(WeaponTypes.POLEARM),
                "test",
                5,
                Stats.ATK,
                Stats.ER_PER,
                "https://drive.google.com/file/d/1eyiEvFWJSdS3-0yuWgXHpKp82E9_4Bad/view"
            ),Weapon(
                "4",
                "Calamity Queller",
                "test",
                getWeaponType(WeaponTypes.POLEARM),
                "Extinguishing Precept",
                5,
                Stats.ATK,
                Stats.ATK_PER,
                "https://drive.google.com/file/d/1kABfbqHoLSHFRi-bnfLNK5cnIo3hVS3T/view"
            ),
            Weapon(
                "5",
                "Staff of Homa",
                "A “firewood staff” that was once used in ancient and long-lost rituals.",
                getWeaponType(WeaponTypes.POLEARM),
                "test",
                5,
                Stats.ATK,
                Stats.CRIT_DMG,
                "https://drive.google.com/file/d/1alsqPm_g-dJus2YPtJuuQy_uon7R11K3/view"
            ),
            Weapon(
                "6",
                "Engulfing Lightning",
                "A naginata used to ''cut grass.'' Any army that stands before this weapon will probably be likewise cut down...",
                getWeaponType(WeaponTypes.POLEARM),
                "test",
                5,
                Stats.ATK,
                Stats.ER_PER,
                "https://drive.google.com/file/d/1eyiEvFWJSdS3-0yuWgXHpKp82E9_4Bad/view"
            )
        )
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

    private fun getMockResources(): List<DungeonResource> {
        return listOf(
            DungeonResource(
                "1",
                "dungeon",
                "mondstadt",
                "https://drive.google.com/file/d/1wlJoO3CuWu5GuExYbaXPDhMocb3N2hpk/view",
            ),
            DungeonResource(
                "2",
                "dungeon",
                "mondstadt",
                "https://drive.google.com/file/d/1qdcMY0nDq8crRax0u3Lppa4a0qjDwr9h/view",
            ),
            DungeonResource(
                "3",
                "dungeon",
                "mondstadt",
                "https://drive.google.com/file/d/1wlJoO3CuWu5GuExYbaXPDhMocb3N2hpk/view",
            ),
            DungeonResource(
                "4",
                "dungeon",
                "mondstadt",
                "https://drive.google.com/file/d/1qdcMY0nDq8crRax0u3Lppa4a0qjDwr9h/view",
            ),
            DungeonResource(
                "5",
                "dungeon",
                "mondstadt",
                "https://drive.google.com/file/d/1wlJoO3CuWu5GuExYbaXPDhMocb3N2hpk/view",
            ),
            DungeonResource(
                "6",
                "dungeon",
                "mondstadt",
                "https://drive.google.com/file/d/1qdcMY0nDq8crRax0u3Lppa4a0qjDwr9h/view",
            ),
            DungeonResource(
                "7",
                "dungeon",
                "mondstadt",
                "https://drive.google.com/file/d/1wlJoO3CuWu5GuExYbaXPDhMocb3N2hpk/view",
            ),
            DungeonResource(
                "8",
                "dungeon",
                "mondstadt",
                "https://drive.google.com/file/d/1qdcMY0nDq8crRax0u3Lppa4a0qjDwr9h/view",
            )
        )
    }

    private fun getWeaponType(name: WeaponTypes): WeaponType {
        return when (name) {
            WeaponTypes.POLEARM -> {
                WeaponType(
                    "1",
                    "Polearm",
                    "https://drive.google.com/uc?export=view&id=19qGBZ66BEsslwYG3Q3nIKcpA5UDB9jkl"
                )
            }
            WeaponTypes.CLAYMOR -> {
                WeaponType(
                    "2",
                    "Claymor",
                    "https://drive.google.com/uc?export=view&id=1WtN2EZXX8vB5PRf_XjYMYR48_RWiZXNk"
                )
            }
            WeaponTypes.CATALYST -> {
                WeaponType(
                    "3",
                    "Catalyst",
                    "https://drive.google.com/uc?export=view&id=1VF11Eihy7JzoGkFTKT9iisgz2nlgtzrO"
                )
            }
            WeaponTypes.BOW -> {
                WeaponType(
                    "4",
                    "Bow",
                    "https://drive.google.com/uc?export=view&id=1MZrqvsc5MAQna0fB7S3iGq93B5W8n_l-"
                )
            }
            WeaponTypes.SWORD -> {
                WeaponType(
                    "5",
                    "Sword",
                    "https://drive.google.com/uc?export=view&id=15lCuwX6P62VBVk6V52jq17dY1J3M9bYE"
                )
            }
            else -> {
                WeaponType("1", "Sword", "")
            }
        }
    }

    private fun getWeaponElement(name: Elements): Element {
        return when (name) {
            Elements.PYRO -> {
                Element(
                    "1",
                    "Pyro",
                    "https://drive.google.com/uc?export=view&id=10oEiogG0fguDv3qnGeZDGDffXbUxPJ1R"
                )
            }
            Elements.ELECTRO -> {
                Element(
                    "2",
                    "Electro",
                    "https://drive.google.com/uc?export=view&id=19lmBJQf-0_1kKvT0NNzNtZAYAUuKiNqw"
                )
            }
            Elements.DENDRO -> {
                Element(
                    "3",
                    "Dendro",
                    "https://drive.google.com/uc?export=view&id=1U1Sbh0uyVhVJKT-0WqW9f66Pj2GjjMQx"
                )
            }
            Elements.GEO -> {
                Element(
                    "4",
                    "Geo",
                    "https://drive.google.com/uc?export=view&id=1od1d-kDi9sryTuBQzmh6g4PMGc4I1j6n"
                )
            }
            else -> {
                Element("1", "10oEiogG0fguDv3qnGeZDGDffXbUxPJ1R", "")
            }
        }
    }
}