package com.example.codewarschallenge.domain.helper

import com.example.codewarschallenge.domain.model.Languages

data class MappedLanguages(
    val languageName: String?,
    val score: Int?
)

object LanguagesMapHelper {

    fun getBestLanguage(languages: Languages): MappedLanguages? {
        return mapLanguages(languages).maxByOrNull { score ->
            score.score ?: 0
        }
    }

    private fun mapLanguages(languages: Languages): List<MappedLanguages> {
        val mappedLanguages = arrayListOf<MappedLanguages>()

        mappedLanguages.add(
            MappedLanguages(
                languageName = "C#",
                score = languages.cSharp?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "JavaScript",
                score = languages.javaScript?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Ruby",
                score = languages.ruby?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "CoffeScript",
                score = languages.coffeeScript?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Python",
                score = languages.python?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Go",
                score = languages.go?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Java",
                score = languages.java?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Haskell",
                score = languages.haskell?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Cpp",
                score = languages.cpp?.score
            )
        )

        return mappedLanguages
    }
}