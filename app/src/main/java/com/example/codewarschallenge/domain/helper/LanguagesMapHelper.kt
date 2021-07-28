package com.example.codewarschallenge.domain.helper

import com.example.codewarschallenge.domain.model.Languages

data class MappedLanguages(
    val languageName: String?,
    val score: Int?
)

object LanguagesMapHelper {

    fun getBestLanguage(languages: Languages): MappedLanguages? {
        return mapLanguages(languages).maxByOrNull { language ->
            language.score ?: 0
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
                languageName = "CoffeeScript",
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

        mappedLanguages.add(
            MappedLanguages(
                languageName = "R",
                score = languages.r?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "C",
                score = languages.c?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Cfml",
                score = languages.cfml?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Clojure",
                score = languages.clojure?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Cobol",
                score = languages.cobol?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Commonlisp",
                score = languages.commonlisp?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Coq",
                score = languages.coq?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Crystal",
                score = languages.crystal?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Dart",
                score = languages.dart?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Elixir",
                score = languages.elixir?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Elm",
                score = languages.elm?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Erlang",
                score = languages.erlang?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "F#",
                score = languages.fSharp?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Factor",
                score = languages.factor?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Forth",
                score = languages.forth?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Fortran",
                score = languages.fortran?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Groovy",
                score = languages.groovy?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Haxe",
                score = languages.haxe?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Julia",
                score = languages.julia?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Kotlin",
                score = languages.kotlin?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Lua",
                score = languages.lua?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Nim",
                score = languages.nim?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Objc",
                score = languages.objc?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Ocaml",
                score = languages.ocaml?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Pascal",
                score = languages.pascal?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Perl",
                score = languages.perl?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Php",
                score = languages.php?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Powershell",
                score = languages.powershell?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Prolog",
                score = languages.prolog?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Purescript",
                score = languages.purescript?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Racket",
                score = languages.racket?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Raku",
                score = languages.raku?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Php",
                score = languages.php?.score
            )
        )


        mappedLanguages.add(
            MappedLanguages(
                languageName = "Reason",
                score = languages.reason?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Rust",
                score = languages.rust?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Scala",
                score = languages.scala?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Shell",
                score = languages.shell?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "VB",
                score = languages.vb?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Solidity",
                score = languages.solidity?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Swift",
                score = languages.swift?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Sql",
                score = languages.sql?.score
            )
        )

        mappedLanguages.add(
            MappedLanguages(
                languageName = "Typescript",
                score = languages.typeScript?.score
            )
        )

        return mappedLanguages
    }
}