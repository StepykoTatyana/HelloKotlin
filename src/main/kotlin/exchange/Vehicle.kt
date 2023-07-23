package exchange

import java.util.*

class Vehicle(val name: String) {
    inner class Engine(val horsePower: Int) {
        fun start() {
            println("RRRrrrrrrr....")
        }

        fun printHorsePower() {
            println("The $name vehicle has $horsePower horsepower.")
        }
    }
}

class ChristmasTree(var color: String) {

    fun putTreeTopper(color: String) {
        val treeTopperColor = TreeTopper(color)
        treeTopperColor.sparkle()
    }

    inner class TreeTopper(var color: String) {

        fun sparkle() {
            println(
                "The sparkling $color tree topper looks" +
                        " stunning on the ${this@ChristmasTree.color}" +
                        " Christmas tree!"
            )


        }
    }
}

fun main() {

    var number1 = 38
    var number2 = 54
    number1 = number1 shl 2
    number2 = number2 shr 1
    var result = number2 xor number1

    println()
    val result2 = isPrime(5977)

    var greatestPrimeInRange = 2
    for (number in 2..1000) {
        if (isPrime(number) && number > greatestPrimeInRange)
            greatestPrimeInRange = number
    }


    var fibonacciPrevious = 1
    var fibonacciCurrent = 1
    var fibonacciSum = fibonacciPrevious + fibonacciCurrent

    while(true) {
        val tmp = fibonacciPrevious + fibonacciCurrent
        fibonacciPrevious = fibonacciCurrent
        fibonacciCurrent = tmp
        fibonacciSum += fibonacciCurrent
    }


    whatever()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNextLine()) {
        var ints = intArrayOf(
            scanner.nextLine().toInt(),
            scanner.nextLine().toInt(),
        )
        ints = swapInts(ints)
        println(ints[0])
        println(ints[1])
    }

    val v = ChristmasTree("red")
    v.putTreeTopper("green")

}

fun isPrime(number: Int): Boolean {
    for (i in 2..(number / 2)) {
        if (number % i != 0)
            continue
        else
            return false
    }
    return true
}


fun swapInts(ints: IntArray): IntArray {
    return intArrayOf(ints[1], ints[0])
}

fun whatever() {
//    var greeting = "Hello world"
//    if (greeting.contains("e")) {
//        greeting += "!"
//        println(greeting)
//    }
//    println("Shutting down")


    val rangeStart = 'C'
    val rangeEnd = 'Y'
    val findLetter = 'Q'
    for (c in rangeStart..rangeEnd) {
        if (c == findLetter) {
            println(
                "Character $findLetter is within range $rangeStart–$rangeEnd"
            )
            return
        }
    }
    println("Character $findLetter is not within range $rangeStart–$rangeEnd")

}
