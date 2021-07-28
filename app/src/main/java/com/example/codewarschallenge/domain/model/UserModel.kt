package com.example.codewarschallenge.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    @SerializedName("username") val userName: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("honor") val honor: Int?,
    @SerializedName("clan") val clan: String?,
    @SerializedName("leaderboardPosition") val leaderboardPosition: Int?,
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
    @SerializedName("javascript") val javaScript: JavaScript?,
    @SerializedName("ruby") val ruby: Ruby?,
    @SerializedName("coffescript") val coffeeScript: CoffeeScript?,
    @SerializedName("csharp") val cSharp: CSharp?,
    @SerializedName("python") val python: Python?,
    @SerializedName("java") val java: Java?,
    @SerializedName("go") val go: Go?,
    @SerializedName("haskell") val haskell: Haskell?,
    @SerializedName("cpp") val cpp: Cpp?,
    @SerializedName("elixir") val elixir: Elixir?,
    @SerializedName("dart") val dart: Dart?,
    @SerializedName("typescript") val typeScript: TypeScript?,
    @SerializedName("fsharp") val fSharp: FSharp?,
    @SerializedName("ocaml") val ocaml: Ocaml?,
    @SerializedName("clojure") val clojure: Clojure?,
    @SerializedName("rust") val rust: Rust?,
    @SerializedName("c") val c: C?,
    @SerializedName("php") val php: Php?,
    @SerializedName("crystal") val crystal: Crystal?,
    @SerializedName("swift") val swift: Swift?,
    @SerializedName("shell") val shell: Shell?,
    @SerializedName("lua") val lua: Lua?,
    @SerializedName("sql") val sql: Sql?,
    @SerializedName("r") val r: R?,
    @SerializedName("objc") val objc: Objc?,
    @SerializedName("nim") val nim: Nim?,
    @SerializedName("kotlin") val kotlin: Kotlin?,
    @SerializedName("groovy") val groovy: Groovy?,
    @SerializedName("scala") val scala: Scala?,
    @SerializedName("solidity") val solidity: Solidity?,
    @SerializedName("erlang") val erlang: Erlang?,
    @SerializedName("fortran") val fortran: Fortran?,
    @SerializedName("julia") val julia: Julia?,
    @SerializedName("powershell") val powershell: PowerShel?,
    @SerializedName("reason") val reason: Reason?,
    @SerializedName("racket") val racket: Racket?,
    @SerializedName("vb") val vb: Vb?,
    @SerializedName("forth") val forth: Forth?,
    @SerializedName("factor") val factor: Factor?,
    @SerializedName("prolog") val prolog: Prolog?,
    @SerializedName("cobol") val cobol: Cobol?,
    @SerializedName("coq") val coq: Coq?,
    @SerializedName("haxe") val haxe: Haxe?,
    @SerializedName("elm") val elm: Elm?,
    @SerializedName("cfml") val cfml: Cfml?,
    @SerializedName("purescript") val purescript: PureScript?,
    @SerializedName("commonlisp") val commonlisp: CommonLisp?,
    @SerializedName("perl") val perl: Perl?,
    @SerializedName("raku") val raku: Raku?,
    @SerializedName("pascal") val pascal: Pascal?
) : Parcelable

@Parcelize
data class JavaScript(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable


@Parcelize
data class Ruby(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class CoffeeScript(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class CSharp(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Python(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Go(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Java(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Haskell(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Cpp(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Elixir(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable


@Parcelize
data class Dart(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class TypeScript(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class FSharp(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Ocaml(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Clojure(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Rust(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class C(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Php(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable


@Parcelize
data class Crystal(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Swift(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Shell(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Lua(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Sql(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class R(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Nim(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Objc(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Kotlin(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Groovy(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Scala(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Solidity(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Erlang(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Fortran(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Julia(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class PowerShel(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Reason(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Racket(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Vb(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Forth(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Factor(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Prolog(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Cobol(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Coq(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable


@Parcelize
data class Haxe(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Elm(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Cfml(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class PureScript(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class CommonLisp(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Perl(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable

@Parcelize
data class Raku(
    @SerializedName("rank") val rank: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("score") val score: Int?
) : Parcelable


@Parcelize
data class Pascal(
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