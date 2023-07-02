package exchange

fun main() {

    when (readln().toInt()) {
        in mutableListOf(0, 1, 2, 3, 5, 8, 13, 21, 34, 55) ->
            println("F")

        in mutableListOf(0, 1, 3, 6, 10, 15, 21, 28, 36, 45) ->
            println("T")

        in mutableListOf(1, 10, 100, 1000, 10000, 100000) ->
            println("P")

        else -> println("N")
    }

    val letter = readln()
    var alfa = ""
    for (i in 'a'..'z') {
        if (i.toString() == letter) {
            break
        }
        alfa += i

    }
    println(alfa)

}