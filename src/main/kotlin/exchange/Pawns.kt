package exchange

fun main() {
    println("Pawns-Only Chess")
    println("First Player's name:")
    val firstName = readln()

    println("Second Player's name:")
    val secondName = readln()
    val list = mutableListOf<MutableList<String>>()
    for (i in 8 downTo 1) {
        val innerList = mutableListOf<String>()
        for (j in 8 downTo 1) {

            if (i == 2) {
                innerList.add(" B |")
            } else if (i == 7) {
                innerList.add(" W |")
            } else {
                innerList.add("   |")
            }

        }
        list.add(innerList)
    }

    //println(Ex4.getList)

    for (i in 8 downTo 1) {
        println("  +---+---+---+---+---+---+---+---+")
        print("$i ")
        print("|")
        for (j in 8 downTo 1) {
            print(list[i - 1][j - 1])

        }
        println()

    }
    println("  +---+---+---+---+---+---+---+---+")
    println("    a   b   c   d   e   f   g   h")

    var i = 1
    println()
    println("$firstName's turn:")
    var answer = readln()
    val regex = Regex("([a-h][1-8]){2}")
    while (answer != "exit") {
        while (!answer.matches(regex)) {
            if (answer == "exit"){
                break
            }
            println("Invalid Input")
            if (i % 2 == 1) {
                println("$firstName's turn:")
            } else {
                println("$secondName's turn:")
            }
            answer = readln()

        }
        if (answer == "exit"){
            break
        }
        i++
        if (i % 2 == 1) {
            println("$firstName's turn:")
        } else {
            println("$secondName's turn:")
        }
        answer = readln()
    }
    println("Bye!")

//
//for (Ex4.getI in 8 downTo 1) {
//    println("  +---+---+---+---+---+---+---+---+")
//    print("$Ex4.getI ")
//    when (Ex4.getI) {
//        7 -> println("| B | B | B | B | B | B | B | B |")
//        2 -> println("| W | W | W | W | W | W | W | W |")
//        else -> println(
//            "|   |   |   |   |   |   |   |   |"
//        )
//    }
//}
//println("  +---+---+---+---+---+---+---+---+")
//println("    a   b   c   d   e   f   g   h")
//

}