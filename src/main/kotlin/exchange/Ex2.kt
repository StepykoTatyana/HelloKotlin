package exchange

import java.io.File
import java.lang.Exception
import java.util.*
import kotlin.math.pow

val scanner = Scanner(System.`in`)
val r = Regex("\\s+")
var linesFile = mutableListOf<String>()
val separator: String = File.separator
var flagLog = false
var myFile: File? = null


fun main(args: Array<String>) {

    fun f(n: Int): Int = if (n > 2) f(n - 1) + f(n - 2) + f(n - 3) else n
    println(f(6))
    fun sumRecursive(n: Int): Int {
        var sum = 0
        if (n.toString().length == 1) {
            sum += n
        } else {
            val m = 10.0.pow(n.toString().length.toDouble() - 1).toInt()
            sum = n / m + sumRecursive(n % m)


        }
        return sum
    }

    val n = 54321
    println(n % 10)
    println(54321 / (10.0.pow(54321.toString().length.toDouble() - 1)).toInt())
    println("KKKK")
    println(sumRecursive(n))


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
    val list = listOf(
        "-sortingType",
        "-dataType", "long", "word", "line", "natural", "byCount",
        "-inputFile", "-outputFile"
    )
    var inputFile: String
    var outputFile: String
    if (args.contains("-outputFile")) {
        flagLog = true
    }
    for (i in args.indices) {

        if (args[i] == "-outputFile") {
            outputFile = args[i + 1]
            myFile = File("C:\\IdeaProjects\\HelloKotlin\\src\\waterMark.main\\kotlin\\exchange${flashCards.separator}$outputFile")

        }
        if (args[i] !in list && !args[i].matches(Regex(".+[.].+"))) {
            println("${args[i]} is not a valid parameter. It will be skipped.")
            println(flagLog)
            if (flagLog) {
                myFile?.appendText("${args[i]} is not a valid parameter. It will be skipped.\n")
            }
        }
        if (args[i] == "-inputFile") {
            inputFile = args[i + 1]
            linesFile =
                File("C:\\IdeaProjects\\HelloKotlin\\src\\waterMark.main\\kotlin\\exchange${flashCards.separator}$inputFile").readLines() as MutableList<String>
            println(linesFile)

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
                if (flagLog) {
                    myFile?.appendText("No data type defined!\n")
                }
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
                if (flagLog) {
                    myFile?.appendText("No data type defined!\n")
                }
            }
        } else {
            println("No sorting type defined!")
            if (flagLog) {
                myFile?.appendText("No sorting type defined!\n")
            }
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
            if (flagLog) {
                myFile?.appendText("No data type defined!\n")
            }
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
    var list = mutableListOf<Int>()
    if (linesFile.size == 0) {
        while (scanner.hasNext()) {
            list = funForInt(scanner.nextLine(), list)
        }
    } else {
        for (l in linesFile) {
            list = funForInt(l, list)

        }
    }
    list.sortBy { it }
    println("Total numbers: ${list.size}.")
    print("Sorted data: ")
    list.stream().forEach { print("$it ") }
}

fun funForInt(l: String, list: MutableList<Int>): MutableList<Int> {
    val next = l.replace(r, " ")
        .split(" ").stream().toList()
    val mutableList = mutableListOf<Int>()
    for (i in next) {
        try {
            mutableList.add(i.toInt())
        } catch (e: Exception) {
            println("$i is not a long. It will be skipped.")
            if (flagLog) {
                myFile?.appendText("$i is not a long. It will be skipped.\n")
            }
        }
    }
    list += mutableList
    return list
}

fun funForWord(l: String, list: MutableList<String>): MutableList<String> {
    val next = l.trim().replace(r, " ")
        .split(" ").stream().toList()
    list += next
    return list
}

fun sortWord() {
    var list = mutableListOf<String>()
    if (linesFile.size == 0) {
        while (scanner.hasNext()) {
            list = funForWord(scanner.nextLine(), list)
        }
    } else {
        for (l in linesFile) {
            list = funForWord(l, list)

        }
    }
    list.sortBy { it }
    println("Total numbers: ${list.size}.")
    print("Sorted data: ")
    list.stream().forEach { print("$it ") }
}


fun sortLine() {
    val list = mutableListOf<String>()
    if (linesFile.size == 0) {
        while (scanner.hasNext()) {
            list.add(scanner.nextLine())
        }
    } else {
        for (l in linesFile) {
            list.add(l)

        }
    }
    list.sortBy { it }
    println("Total numbers: ${list.size}.")
    println("Sorted data: ")
    list.stream().forEach { println("$it ") }
}

fun sortedByCountInt() {
    val map = mutableMapOf<Int, Int>()
    var list = mutableListOf<Int>()

    if (linesFile.size == 0) {
        while (scanner.hasNext()) {
            list = funForInt(scanner.nextLine(), list)
        }
    } else {
        for (l in linesFile) {
            list = funForInt(l, list)

        }
    }
    for (i in list) {
        map[i] = list.count { x -> x == i }
    }

    println("Total numbers: ${list.size}.")
    map.entries.sortedBy { (k, v) -> v }.toMutableList()
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
    var list = mutableListOf<String>()
    if (linesFile.size == 0) {
        while (scanner.hasNext()) {
            list = funForWord(scanner.nextLine(), list)
        }
    } else {
        for (l in linesFile) {
            list = funForWord(l, list)

        }
    }
    list.sort()
    var k = list.groupingBy { it }.eachCount()
    k = k.toList().sortedBy { it.second }.also { it.first() }.toMap()
    for (i in list) {
        map[i] = list.count { x -> x == i }
    }
    println("Total numbers: ${list.size}.")
    println("Sorted data: ")
    val countMaxInList = list.size.toDouble()
    for (n in k) {
        println("${n.key}: ${n.value} time(s), ${(n.value.toDouble() / countMaxInList * 100).toInt()}%")
    }
}

fun sortedByCountLine() {
    val map = mutableMapOf<String, Int>()
    val list = mutableListOf<String>()
    if (linesFile.size == 0) {
        while (scanner.hasNext()) {
            list.add(scanner.nextLine().trim())
        }
    } else {
        for (l in linesFile) {
            list.add(l.trim())

        }
    }

    var k = list.groupingBy { it }.eachCount()
    k = k.toList().sortedBy { it.first }.sortedBy { it.second }.toMap()
    for (i in list) {
        map[i] = list.count { x -> x == i }
    }
    println("Total numbers: ${list.size}.")
    val countMaxInList = list.size.toDouble()
    for (n in k) {
        println("${n.key}: ${n.value} time(s), ${(n.value.toDouble() / countMaxInList * 100).toInt()}%")
    }
}

