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

//    val map = mapOf(100 to 10, 55 to 3, 112 to 5, 11 to 5000, 1 to 800).toMutableMap()
//
//    map.filter { it.value <= 5 }.toMutableMap()
//    var count = 0
//    val s = map.filter { it.key % 2 == 0 }.values.sum()
//    for (m in map) {
//        if (m.key % 2 == 0) {
//            count += m.value
//        }
//    }
//
//    val map1 = buildMap<String, String> {
//        put("Apple", "Green")
//        put("Banana", "Yellow")
//        put("Strawberry", "Red")
//    }
//
//    println(count)
//    println(s)
//
//    if (args.contains("-sortIntegers")) {
//        sortedByCount()
//
//    } else {
//        when (args[1]) {
//            "word" ->
//                funcForWord()
//
//            "long" ->
//                funcForInt()
//
//            "line" ->
//                funcForLine()
//        }
//    }
    val list = listOf<String>("-sortingType", "-dataType", "long", "word", "line", "natural", "byCount")
    for (i in args.indices) {
        if (args[i] !in list) {
            println("${args[i]} is not a valid parameter. It will be skipped.")
        }
    }
    if (args.contains("-sortingType")) {
        if (args.contains("natural")) {
            if (args.contains("long")) {
                sortInt()
            } else if (args.contains("word")) {
                sortWord()
            } else if (args.contains("line")) {
                sortLine()
            } else {
                println("No data type defined!")
            }
        } else if (args.contains("byCount")) {
            if (args.contains("long")) {
                sortedByCountInt()
            } else if (args.contains("word")) {
                sortedByCountWord()
            } else if (args.contains("line")) {
                sortedByCountLine()
            } else {
                println("No data type defined!")
            }
        } else {
            println("No sorting type defined!")
        }
    } else {
        if (args.contains("long")) {
            sortInt()
        } else if (args.contains("line")) {
            sortLine()
        } else if (args.contains("word")) {
            sortWord()
        } else {
            println("No data type defined!")
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
            .split(" ").stream().toList()
        val mutableList = mutableListOf<Int>()
        for (i in next) {
            try {
                mutableList.add(i.toInt())
            } catch (e: Exception) {
                println("$i is not a long. It will be skipped.")
            }
        }
        list += mutableList
    }
    list.sortBy { it }
    println("Total numbers: ${list.size}.")
    print("Sorted data: ")
    list.stream().forEach { print("$it ") }
}

fun sortWord() {
    val list = mutableListOf<String>()
    while (scanner.hasNext()) {
        val next = scanner.nextLine().replace(r, " ")
            .split(" ").stream().toList()
        list += next
    }
    list.sortBy { it }
    println("Total numbers: ${list.size}.")
    print("Sorted data: ")
    list.stream().forEach { print("$it ") }
}

fun sortLine() {
    val list = mutableListOf<String>()
    while (scanner.hasNext()) {
        val next = scanner.nextLine()
        list.add(next)
    }
    list.sortBy { it }
    println("Total numbers: ${list.size}.")
    println("Sorted data: ")
    list.stream().forEach { println("$it ") }
}

fun sortedByCountInt() {
    val map = mutableMapOf<Int, Int>()
    val list = mutableListOf<Int>()
    while (scanner.hasNext()) {
        val next = scanner.nextLine().replace(r, " ")
            .split(" ").stream().toList()
        val mutableList = mutableListOf<Int>()
        for (i in next) {
            try {
                mutableList.add(i.toInt())
            } catch (e: Exception) {
                println("$i is not a long. It will be skipped.")
            }
        }
        list += mutableList
    }
    for (i in list) {
        map[i] = list.count { x -> x == i }
    }

    println("Total numbers: ${list.size}.")
    val m = map.entries.sortedBy { (k, v) -> v }.toMutableList()
    val countMaxInList = list.size.toDouble()
    var k = list.groupingBy { it }.eachCount()
    k = k.toList().sortedBy { it.first }.sortedBy { it.second }.toMap()

    for (i in list) {
        map[i] = list.count { x -> x == i }
    }
    for (n in k) {
        println("${n.key}: ${n.value} time(s), ${(n.value.toDouble() / countMaxInList * 100).toInt()}%")
    }

}

fun sortedByCountWord() {
    val map = mutableMapOf<String, Int>()
    val list = mutableListOf<String>()
    while (scanner.hasNext()) {
        val next = scanner.nextLine().trim().replace(r, " ")
            .split(" ").stream().toList()
        list += next
    }
    println(list)
    println(":::::::::::")
    list.sort()
    var k = list.groupingBy { it }.eachCount()
    println(k)
    k = k.toList().sortedBy { it.second }.also { it.first() }.toMap()
    println(k.entries)
    for (i in list) {
        map[i] = list.count { x -> x == i }
    }

//    list.groupingBy { it }.eachCount().toList()
    println("Total numbers: ${list.size}.")
    println("Sorted data: ")
//    map.entries.sortedBy { (k, v) -> v }.toMutableList()
//    println(map)
    val m = map.toList().sortedBy { it.second }.toMap()
    val countMaxInList = list.size.toDouble()
    //m.forEach { print("${it.key}: ${it.value} time(s), ${(it.value.toDouble() / countMaxInList * 100).toInt()}%") }
    for (n in k) {
        println("${n.key}: ${n.value} time(s), ${(n.value.toDouble() / countMaxInList * 100).toInt()}%")
    }
}

fun sortedByCountLine() {
    val map = mutableMapOf<String, Int>()
    val list = mutableListOf<String>()
    while (scanner.hasNext()) {
        val next = scanner.nextLine().trim()
        list.add(next)
    }

    var k = list.groupingBy { it }.eachCount()
    k = k.toList().sortedBy { it.first }.sortedBy { it.second }.toMap()
    for (i in list) {
        map[i] = list.count { x -> x == i }
    }

    println("Total numbers: ${list.size}.")
    val m = map.toList().sortedBy { it.second }.toMap()
    val countMaxInList = list.size.toDouble()
    for (n in k) {
        println("${n.key}: ${n.value} time(s), ${(n.value.toDouble() / countMaxInList * 100).toInt()}%")
    }
}