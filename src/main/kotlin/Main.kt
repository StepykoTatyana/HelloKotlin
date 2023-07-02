import java.util.Scanner
import kotlin.math.pow

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
    val scanner = Scanner(System.`in`)

//    val a = readln().toDouble()
//    val b = readln().toDouble()
//    val c = readln().toDouble()
//    val d = readln().toDouble()
//    for (Ex4.getI in 1..1000) {
//        if ((a * Ex4.getI.toDouble().pow(3.0) + b * Ex4.getI.toDouble().pow(2.0) + c * Ex4.getI.toDouble() + d).toInt() == 0) {
//            println(Ex4.getI.toInt())
//        }
//
//    }

//    val a = readln().toInt()
//    val b = readln().toInt()
//    var sum = 0;
//    for (Ex4.getI in a..b) {
//        sum += Ex4.getI
//    }
//    println(sum)

    for (i in 1..3) {
        for (j in 1..i) {
            println(j)
        }
    }

    val inputList = mutableListOf(
        mutableListOf(1, 2, 3),
        mutableListOf(4, 5, 6),
        mutableListOf(7, 8, 9),
        mutableListOf(10, 11, 12)
    )

    println(inputList[2].joinToString())
}