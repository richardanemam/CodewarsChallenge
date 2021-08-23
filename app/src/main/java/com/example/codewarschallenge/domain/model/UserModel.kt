package com.example.codewarschallenge.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
        @SerializedName("username") val userName: String,
        @SerializedName("name") val name: String?,
        @SerializedName("honor") val honor: Int?,
        @SerializedName("clan") val clan: String?,
        @SerializedName("leaderboardPosition") val leaderBoardPosition: Int?,
        @SerializedName("skills") val skillsList: List<String>?,
        @SerializedName("ranks") val ranks: Ranks?,
        @SerializedName("codeChallenges") val codeChallenges: CodeChallenges?
) : Parcelable

@Parcelize
data class Ranks(
        @SerializedName("overall") val overall: Overall?,
        @SerializedName("languages") val languages: Languages?
) : Parcelable

@Parcelize
data class Overall(
        @SerializedName("rank") val rank: Int?,
        @SerializedName("name") val name: String?,
        @SerializedName("color") val color: String?,
        @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Languages(
        @SerializedName("javascript") val javaScript: LanguageInfo?,
        @SerializedName("ruby") val ruby: LanguageInfo?,
        @SerializedName("coffescript") val coffeeScript: LanguageInfo?,
        @SerializedName("csharp") val cSharp: LanguageInfo?,
        @SerializedName("python") val python: LanguageInfo?,
        @SerializedName("java") val java: LanguageInfo?,
        @SerializedName("go") val go: LanguageInfo?,
        @SerializedName("haskell") val haskell: LanguageInfo?,
        @SerializedName("cpp") val cpp: LanguageInfo?,
        @SerializedName("elixir") val elixir: LanguageInfo?,
        @SerializedName("dart") val dart: LanguageInfo?,
        @SerializedName("typescript") val typeScript: LanguageInfo?,
        @SerializedName("fsharp") val fSharp: LanguageInfo?,
        @SerializedName("ocaml") val ocaml: LanguageInfo?,
        @SerializedName("clojure") val clojure: LanguageInfo?,
        @SerializedName("rust") val rust: LanguageInfo?,
        @SerializedName("c") val c: LanguageInfo?,
        @SerializedName("php") val php: LanguageInfo?,
        @SerializedName("crystal") val crystal: LanguageInfo?,
        @SerializedName("swift") val swift: LanguageInfo?,
        @SerializedName("shell") val shell: LanguageInfo?,
        @SerializedName("lua") val lua: LanguageInfo?,
        @SerializedName("sql") val sql: LanguageInfo?,
        @SerializedName("r") val r: LanguageInfo?,
        @SerializedName("objc") val objc: LanguageInfo?,
        @SerializedName("nim") val nim: LanguageInfo?,
        @SerializedName("kotlin") val kotlin: LanguageInfo?,
        @SerializedName("groovy") val groovy: LanguageInfo?,
        @SerializedName("scala") val scala: LanguageInfo?,
        @SerializedName("solidity") val solidity: LanguageInfo?,
        @SerializedName("erlang") val erlang: LanguageInfo?,
        @SerializedName("fortran") val fortran: LanguageInfo?,
        @SerializedName("julia") val julia: LanguageInfo?,
        @SerializedName("powershell") val powershell: LanguageInfo?,
        @SerializedName("reason") val reason: LanguageInfo?,
        @SerializedName("racket") val racket: LanguageInfo?,
        @SerializedName("vb") val vb: LanguageInfo?,
        @SerializedName("forth") val forth: LanguageInfo?,
        @SerializedName("factor") val factor: LanguageInfo?,
        @SerializedName("prolog") val prolog: LanguageInfo?,
        @SerializedName("cobol") val cobol: LanguageInfo?,
        @SerializedName("coq") val coq: LanguageInfo?,
        @SerializedName("haxe") val haxe: LanguageInfo?,
        @SerializedName("elm") val elm: LanguageInfo?,
        @SerializedName("cfml") val cfml: LanguageInfo?,
        @SerializedName("purescript") val purescript: LanguageInfo?,
        @SerializedName("commonlisp") val commonlisp: LanguageInfo?,
        @SerializedName("perl") val perl: LanguageInfo?,
        @SerializedName("raku") val raku: LanguageInfo?,
        @SerializedName("pascal") val pascal: LanguageInfo?
) : Parcelable

@Parcelize
data class LanguageInfo(
        @SerializedName("rank") val rank: Int?,
        @SerializedName("name") val name: String?,
        @SerializedName("color") val color: String?,
        @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class CodeChallenges(
        @SerializedName("totalAuthored") val totalAuthored: Int?,
        @SerializedName("totalCompleted") val totalCompleted: Int?
) : Parcelable