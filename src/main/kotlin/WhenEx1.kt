fun main() {
    val (var1, var2, var3) = readln().split(" ")

    val a = var1.toInt()
    val b = var2.toInt()
    val c = var3.toInt()

    println(
        when (c) {
            a + b -> "$c equals $a plus $b"
            a - b -> "$c equals $a minus $b"
            a * b -> "$c equals $a times $b"
            else -> "We do not know how to calculate $c"
        }
    )

    val n = readln().toInt()
    when (n) {
        0 -> println("n is zero")
        in 1..10 -> println("n is between 1 and 10 (inclusive)")
        in 25..30 -> println("n is between 25 and 30 (inclusive)")
        else -> println("n is outside a range")
    }

    when {
        n == 0 -> println("n is zero")
        n in 100..200 -> println("n is between 100 and 200")
        n > 300 -> println("n is greater than 300")
        n < 0 -> println("n is negative")
        // else-branch is optional here
    }

    when (readln().toInt()) {
        1 -> println("move up")
        2 -> println("move down")
        3 -> println("move left")
        4 -> println("move right")
        else -> println("error!")
    }

    val word1 = readln()
    val op = readln()
    val word2 = readln()

    when (op) {
        "equals" -> println(word1 == word2)
        "plus" -> println(word1 + word2)
        "endsWith" -> println(word1.endsWith(word2))
        else -> println("Unknown operation")
    }


    when (readln()) {
        "gryffindor" -> println("bravery")
        "hufflepuff" -> println("loyalty")
        "slytherin" -> println("cunning")
        "ravenclaw" -> println("intellect")
        else -> println("not a valid house")
    }
}