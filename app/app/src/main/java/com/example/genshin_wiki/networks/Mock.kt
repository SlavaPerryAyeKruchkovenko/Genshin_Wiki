package com.example.genshin_wiki.networks

import com.example.genshin_wiki.data.models.*
import com.example.genshin_wiki.data.models.enums.Elements
import com.example.genshin_wiki.data.models.enums.Stats
import com.example.genshin_wiki.data.models.enums.WeaponTypes

class Mock {

    fun getCharacters(): List<Character> = getMockCharacters()
    fun getWeapons(): List<Weapon> = getMockWeapons()
    fun getResources(): List<DungeonResource> = getMockResources()
    fun getArtifacts(): List<Artifact> = getMockArtifacts()
    fun getLikeable(): List<Likeable> = getMockLikeable()
    fun getArtifactById(id: String): Artifact? {
        return getMockArtifacts().find { it.id == id }
    }
    fun getWeaponById(id: String): Weapon?{
        return getMockWeapons().find { it.id == id }
    }
    fun getCharacterPortraitById(characterId: String): Character? {
        return getMockCharacters().find { it.id === characterId }
    }

    private fun getMockLikeable(): List<Likeable> {
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
            Character(
                "2",
                "https://drive.google.com/file/d/10yvtmTVxxPuSah6VyNbPDE-boxKOZ0JD/view",
                "Yao Yao",
                4,
                getWeaponType(WeaponTypes.POLEARM),
                getWeaponElement(Elements.DENDRO),
                CharacterPortrait(
                    "1",
                    "https://drive.google.com/file/d/1bai2zj5anPUQME0JPbMZFVNuJOEXsAgp/view",
                    "Lee Yue",
                    false,
                    "6 марта",
                    "Младшая ученица Владыки Песен и Скитаний, добрый и заботливый «маленький взрослый».",
                    "Возращаюсиеся копье",
                    "Небесное скопление редьки",
                    "Сошествие лунной яшмы",

                    ),
            ),
            Character(
                "3",
                "https://drive.google.com/file/d/1WD5p8cqkzPcsK26-NtUtWpxmmWOa7OIi/view",
                "Raiden",
                5,
                getWeaponType(WeaponTypes.POLEARM),
                getWeaponElement(Elements.ELECTRO),
                CharacterPortrait(
                    "4",
                    "https://drive.google.com/file/d/1YVwqOKFXR24UxCwmpW5nztHSpf1_2hhY/view",
                    "Inadzuma",
                    false,
                    "26 июня",
                    "Её Превосходительство Наруками Огосё, пообещавшая неизменную вечность для жителей Инадзумы.",
                    "Исток",
                    "Превосходство: Зловещее знамение",
                    "Тайное искусство: Мусо синсэцу",
                ),
            ),
            Artifact(
                "4",
                "https://drive.google.com/file/d/16EH-ODMcaLMQ0dDZWfVc6j4YZUxNIIuQ/view",
                "Emblem of Severed Fate",
                5,
                "bonus 2",
                "bonus 4",
            ),
            Artifact(
                "5",
                "https://drive.google.com/file/d/15QVYW9Leqb44va03fa0daNNUAO8YOvj9/view",
                "Lucky Dog",
                2,
                "bonus 2",
                "bonus 4",
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
            ),
            Artifact(
                "7",
                "https://drive.google.com/file/d/1vSHZqh8EHiBtv5WyTVCQC0KkStxQpiuX/view",
                "Adventurer",
                1,
                "bonus 2",
                "bonus 4",
            ),
            Artifact(
                "8",
                "https://drive.google.com/file/d/1Fbc633EPX2bV8OEdzqVNUls3JwY_4QQx/view",
                "Resolution of Sojourner",
                3,
                "bonus 2",
                "bonus 4",
            ),
        )
    }
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
            ), Weapon(
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

    private fun getMockCharacters(): List<Character> {
        return listOf(
            Character(
                "1",
                "https://drive.google.com/file/d/10yvtmTVxxPuSah6VyNbPDE-boxKOZ0JD/view",
                "Yao Yao",
                4,
                getWeaponType(WeaponTypes.POLEARM),
                getWeaponElement(Elements.DENDRO),
                CharacterPortrait(
                    "1",
                    "https://drive.google.com/file/d/1bai2zj5anPUQME0JPbMZFVNuJOEXsAgp/view",
                    "Lee Yue",
                    false,
                    "6 марта",
                    "Младшая ученица Владыки Песен и Скитаний, добрый и заботливый «маленький взрослый».",
                    "Возращаюсиеся копье",
                    "Небесное скопление редьки",
                    "Сошествие лунной яшмы",
                    ),
            ),
            Character(
                "2",
                "https://drive.google.com/file/d/1BBnFVb0ERkIxoI2ylxxnpVMjc4MbVLoc/view",
                "Zhong Li",
                5,
                getWeaponType(WeaponTypes.POLEARM),
                getWeaponElement(Elements.GEO),
                CharacterPortrait(
                    "2",
                    "https://drive.google.com/file/d/1ZxLbuMA9WGNaV0M_xfKKef4mcy7MIC8t/view",
                    "Lee Yue",
                    true,
                    "31st December",
                    "Приглашённый специалист ритуального бюро “Ваншэн”. Необычайно загадочен и сведущ во всех делах.",
                    "Каменный дождь",
                    "Власть над камнем",
                    "Падение кометы",
                ),
            ),
            Character(
                "3",
                "https://drive.google.com/file/d/1oA9C6t28y5i1jtDIXc5vUvmG_ZAqeGKX/view",
                "Yoimiya",
                5,
                getWeaponType(WeaponTypes.BOW),
                getWeaponElement(Elements.PYRO),
                CharacterPortrait(
                    "3",
                    "https://drive.google.com/file/d/1vOVdApLRMA-ypysBjfAznZrIOqT5D9x5/view",
                    "Inadzuma",
                    false,
                    "21 июня",
                    "Владелица «Фейерверков Наганохары», так же известна как «Королева праздника лета». Будучи мастером своего дела, она воплощает надежды и мечты людей в своих фейерверках.",
                    "Вспышка фейерверка",
                    "Огненный танец Ниваби",
                    "Камнеломка Рюкин",
                ),
            ),
            Character(
                "4",
                "https://drive.google.com/file/d/1WD5p8cqkzPcsK26-NtUtWpxmmWOa7OIi/view",
                "Raiden",
                5,
                getWeaponType(WeaponTypes.POLEARM),
                getWeaponElement(Elements.ELECTRO),
                CharacterPortrait(
                    "4",
                    "https://drive.google.com/file/d/1YVwqOKFXR24UxCwmpW5nztHSpf1_2hhY/view",
                    "Inadzuma",
                    false,
                    "26 июня",
                    "Её Превосходительство Наруками Огосё, пообещавшая неизменную вечность для жителей Инадзумы.",
                    "Исток",
                    "Превосходство: Зловещее знамение",
                    "Тайное искусство: Мусо синсэцу",
                ),
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
                "li yue",
                "https://drive.google.com/file/d/1wlJoO3CuWu5GuExYbaXPDhMocb3N2hpk/view",
            ),
            DungeonResource(
                "4",
                "dungeon",
                "li yue",
                "https://drive.google.com/file/d/1aKpmkVNvDZNS5VotyFf-9dXtbnYqo89J/view",
            ),
            DungeonResource(
                "5",
                "dungeon",
                "inadzuma",
                "https://drive.google.com/file/d/1wlJoO3CuWu5GuExYbaXPDhMocb3N2hpk/view",
            ),
            DungeonResource(
                "6",
                "dungeon",
                "inadzuma",
                "https://drive.google.com/file/d/1WCAjHc6OLszh3fXhyfHHEubB07iQOPz2/view",
            ),
            DungeonResource(
                "7",
                "dungeon",
                "sumeru",
                "https://drive.google.com/file/d/1Fb_X3fhKihgKsxXhdseCRMozx8DelziO/view",
            ),
            DungeonResource(
                "8",
                "dungeon",
                "sumeru",
                "https://drive.google.com/file/d/1Fb_X3fhKihgKsxXhdseCRMozx8DelziO/view",
            )
        )
    }

    private fun getWeaponType(name: WeaponTypes): WeaponType {
        return when (name) {
            WeaponTypes.POLEARM -> {
                WeaponType(
                    "1",
                    WeaponTypes.POLEARM,
                    "https://drive.google.com/file/d/19qGBZ66BEsslwYG3Q3nIKcpA5UDB9jkl/view"
                )
            }
            WeaponTypes.CLAYMOR -> {
                WeaponType(
                    "2",
                    WeaponTypes.CLAYMOR,
                    "https://drive.google.com/file/d/1WtN2EZXX8vB5PRf_XjYMYR48_RWiZXNk/view"
                )
            }
            WeaponTypes.CATALYST -> {
                WeaponType(
                    "3",
                    WeaponTypes.CATALYST,
                    "https://drive.google.com/file/d/1VF11Eihy7JzoGkFTKT9iisgz2nlgtzrO/view"
                )
            }
            WeaponTypes.BOW -> {
                WeaponType(
                    "4",
                    WeaponTypes.BOW,
                    "https://drive.google.com/file/d/1MZrqvsc5MAQna0fB7S3iGq93B5W8n_l-/view"
                )
            }
            WeaponTypes.SWORD -> {
                WeaponType(
                    "5",
                    WeaponTypes.SWORD,
                    "https://drive.google.com/file/d/15lCuwX6P62VBVk6V52jq17dY1J3M9bYE/view"
                )
            }
            WeaponTypes.NoData -> {
                WeaponType(
                    "6",
                    WeaponTypes.NoData,
                    "https://drive.google.com/file/d/15lCuwX6P62VBVk6V52jq17dY1J3M9bYE/view"
                )
            }
        }
    }

    private fun getWeaponElement(name: Elements): Element {
        return when (name) {
            Elements.PYRO -> {
                Element(
                    "1",
                    Elements.PYRO,
                    "https://drive.google.com/file/d/10oEiogG0fguDv3qnGeZDGDffXbUxPJ1R/view"
                )
            }
            Elements.ELECTRO -> {
                Element(
                    "2",
                    Elements.ELECTRO,
                    "https://drive.google.com/file/d/19lmBJQf-0_1kKvT0NNzNtZAYAUuKiNqw/view"
                )
            }
            Elements.DENDRO -> {
                Element(
                    "3",
                    Elements.DENDRO,
                    "https://drive.google.com/file/d/1U1Sbh0uyVhVJKT-0WqW9f66Pj2GjjMQx/view"
                )
            }
            Elements.GEO -> {
                Element(
                    "4",
                    Elements.GEO,
                    "https://drive.google.com/file/d/1od1d-kDi9sryTuBQzmh6g4PMGc4I1j6n/view"
                )
            }
            else -> {
                Element("1", Elements.PYRO, "")
            }
        }
    }

    private fun getMockArtifacts(): List<Artifact>{
        return listOf(
            Artifact(
                "1",
                "https://drive.google.com/file/d/16EH-ODMcaLMQ0dDZWfVc6j4YZUxNIIuQ/view",
                "Emblem of Severed Fate",
                5,
                "Energy Recharge +20%",
                "Increases Elemental Burst DMG by 25% of Energy Recharge. A maximum of 75% bonus DMG can be obtained in this way."
            ),
            Artifact(
                "2",
                "https://drive.google.com/file/d/1YiA9rL236gLIwBAaamyYi4qG0GCZmwnn/view",
                "Shimenawa's Reminiscence",
                5,
                "ATK +18%",
                "When casting an Elemental Skill, if the character has 15 or more Energy, they lose 15 Energy and Normal/Charged/Plunging Attack DMG is increased by 50% for 10s. This effect will not trigger again during that duration.",

                ),
            Artifact(
                "3",
                "https://drive.google.com/file/d/1hx9dnxVKuXMfLiNJd-lqD65CjUkp845J/view",
                "Deepwood Memories",
                5,
                "Dendro DMG Bonus +15%",
                "After Elemental Skills or Bursts hit opponents, the targets' Dendro RES will be decreased by 30% for 8s. This effect can be triggered even if the equipping character is not on the field.",
            ),
            Artifact(
                "4",
                "https://drive.google.com/file/d/1Ru7Jxi3z8lTnNs5f0Ufr2znsSAikHXWI/view",
                "Scholar",
                4,
                "bonus 2",
                "bonus 4",
            ),
            Artifact(
                "5",
                "https://drive.google.com/file/d/15QVYW9Leqb44va03fa0daNNUAO8YOvj9/view",
                "Lucky Dog",
                2,
                "bonus 2",
                "bonus 4",
            ),
            Artifact(
                "6",
                "https://drive.google.com/file/d/1vSHZqh8EHiBtv5WyTVCQC0KkStxQpiuX/view",
                "Adventurer",
                1,
                "bonus 2",
                "bonus 4",
            ),
            Artifact(
                "7",
                "https://drive.google.com/file/d/1Fbc633EPX2bV8OEdzqVNUls3JwY_4QQx/view",
                "Resolution of Sojourner",
                3,
                "bonus 2",
                "bonus 4",
            ),
        )
    }
}