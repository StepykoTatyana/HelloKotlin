package exchange

import java.util.Collections

fun solution() {
    val n = readln().toInt()
    val list = mutableListOf<Int>()
    val listNew = mutableListOf<Int>()
    for (a in 0 until n) {
        val newNum = readln().toInt()
        list.add(newNum)
    }
    for (i in list) {
        try {
            listNew.add(list[list.indexOf(i) - 1])
        } catch (e: Exception) {
            listNew.add(list[list.size - 1])
        }

    }
    Collections.rotate(list, +1)

    println(list.joinToString(" "))
}

fun f(x: Double): Double {
    return if (x <= 0) {
        f1(x)
    } else if (x > 0 && x < 1) {
        f2(x)
    } else {
        f3(x)
    }
}

fun concatenate(a: String, b: String, c: String, d: String = " ") {
    print("$a$d$b$d$c")
}

// implement your functions here
fun f1(x: Double): Double {
    return x * x + 1
}

fun f2(x: Double): Double {
    return 1 / (x * x)
}

fun f3(x: Double): Double {
    return x * x - 1
}

fun main() {
    val li = listOf<Int>(8, 11, 13, 2)
    solution()
    concatenate("Hyperskill", "Kotlin", "Programming", "~~~")
}