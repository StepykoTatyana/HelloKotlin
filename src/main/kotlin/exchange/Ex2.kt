package exchange

import java.lang.Exception
import java.util.*
import kotlin.math.absoluteValue

var counter = 3;

val scanner = Scanner(System.`in`)
val r = Regex("\\s+")

fun main(args: Array<String>) {


//    fun calculateBrakingDistance(v1: String, a: String): Int {
//        return try {
//            val c = (v1.toInt() * v1.toInt()) / (2 * a.toInt())
//            c.absoluteValue
//        } catch (e: ArithmeticException) {
//            println("The car does not slow down!")
//            -1
//        } catch (e1: Exception) {
//            println(e1.message)
//            -1
//        }
//    }
//
//    print(calculateBrakingDistance("10", "0"))

    if (args.contains("-sortIntegers")) {
        sortInt()

    } else {
        when (args[1]) {
            "word" ->
                funcForWord()

            "long" ->
                funcForInt()

            "line" ->
                funcForLine()
        }
    }


}

fun funcForInt() {
    val list = mutableListOf<Int>()
    while (scanner.hasNext()) {
        val next = scanner.nextLine().replace(r, " ")
            .split(" ").stream().map(String::toInt).toList()
        list += next
    }
    val countMaxInList = list.filter { it == list.max() }.size
    val partOfMaxInList = countMaxInList.toDouble() / list.size.toDouble() * 100
    println("Total numbers: ${list.size}.")
    println("The greatest number: ${list.max()} (${countMaxInList} time(s)), ${partOfMaxInList.toInt()}%).")
}

fun funcForWord() {
    val list = mutableListOf<String>()
    while (scanner.hasNext()) {
        val next = scanner.nextLine().replace(r, " ")
            .split(" ").stream().toList()
        list += next
    }

    val countMaxInList = list.filter { it -> it == list.maxBy { it.length } }.size
    val partOfMaxInList = countMaxInList.toDouble() / list.size.toDouble() * 100
    println("Total words: ${list.size}.")
    println("The longest word: ${list.maxBy { it.length }} (${countMaxInList} time(s)), ${partOfMaxInList.toInt()}%).")
}

fun funcForLine() {
    val list = mutableListOf<String>()
    var countLine = 0
    while (scanner.hasNext()) {
        val next = scanner.nextLine()
        countLine++
        list.add(next)
    }
    val countMaxInList = list.filter { it -> it == list.maxBy { it.length } }.size
    val partOfMaxInList = countMaxInList.toDouble() / list.size.toDouble() * 100
    println("Total lines: ${countLine}.")
    println("The longest line:\n${list.maxBy { it.length }} \n(${countMaxInList} time(s)), ${partOfMaxInList.toInt()}%).")
}

fun sortInt() {
    val list = mutableListOf<Int>()
    while (scanner.hasNext()) {
        val next = scanner.nextLine().replace(r, " ")
            .split(" ").stream().map(String::toInt).toList()
        list += next
    }
    list.sortBy { it }
    println("Total numbers: ${list.size}.")
    print("Sorted data: ")
    list.stream().forEach { print("$it ") }
}