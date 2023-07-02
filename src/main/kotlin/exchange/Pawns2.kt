package exchange
import java.lang.Exception

var FIRST_PLAYER: String = ""
var SECOND_PLAYER: String = ""
var i: Int = 1
var answer: String = ""
val regex = Regex("([a-h][1-8]){2}")
val list = mutableListOf<MutableList<String>>()
val map = mutableMapOf('a' to 7, 'b' to 6, 'c' to 5, 'd' to 4, 'e' to 3, 'f' to 2, 'g' to 1, 'h' to 0)
val mapIndexes = mutableMapOf(8 to 7, 7 to 6, 6 to 5, 5 to 4, 4 to 3, 3 to 2, 2 to 1, 1 to 0)
var subtraction = 0
var countValidSteps = 2

fun main() {
    println("Pawns-Only Chess")
    println("First Player's name:")
    FIRST_PLAYER = readln()
    println("Second Player's name:")
    SECOND_PLAYER = readln()

    createList()
    printList()

    println("$FIRST_PLAYER's turn:")
    answer = readln()

    loop@ while (answer != "exit") {
        subCertain()
        var flag = false
        while (!answer.matches(regex) || answer[0] != answer[2] || subtraction > countValidSteps || subtraction < 1 || !flag) {
            flag = false
            if (answer == "exit") {
                break@loop
            }
            if (!answer.matches(regex) ) {
                println("Invalid Input")
                if (i % 2 == 1) {
                    println("$FIRST_PLAYER's turn:")
                } else {
                    println("$SECOND_PLAYER's turn:")
                }
                answer = readln()
                subCertain()
            } else {
                if (i % 2 == 1) {
                    if (list[mapIndexes[answer[1].digitToInt()]!!][map[answer[0]]!!].contains("W")) {
                        countValidSteps = if (i % 2 == 1) {
                            if (answer[1].digitToInt() == 2) {
                                2
                            } else {
                                1
                            }

                        } else {
                            if (answer[1].digitToInt() == 7) {
                                2
                            } else {
                                1
                            }
                        }
                        if (subtraction > countValidSteps || subtraction < 1) {
                            println("Invalid Input2")
                            if (i % 2 == 1) {
                                println("$FIRST_PLAYER's turn:")
                            } else {
                                println("$SECOND_PLAYER's turn:")
                            }
                            answer = readln()
                            subCertain()
                        } else {
                            if (list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] == "   |") {
                                list[mapIndexes[answer[1].digitToInt()]!!][map[answer[0]]!!] = "   |"
                                list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] = " W |"
                                flag = true
                            } else {
                                println("Invalid Input3")
                                println("$FIRST_PLAYER's turn:")
                                answer = readln()
                                subCertain()
                            }

                        }

                    } else {
                        println("No white pawn at ${answer[0]}${answer[1]}")
                        println("$FIRST_PLAYER's turn:")
                        answer = readln()
                        subCertain()
                    }

                } else {
                    if (list[mapIndexes[answer[1].digitToInt()]!!][map[answer[0]]!!].contains("B")) {
                        countValidSteps = if (i % 2 == 1) {
                            if (answer[1].digitToInt() == 2) {
                                2
                            } else {
                                1
                            }

                        } else {
                            if (answer[1].digitToInt() == 7) {
                                2
                            } else {
                                1
                            }
                        }
                        if (subtraction > countValidSteps || subtraction < 1) {
                            println("Invalid Input4")
                            if (i % 2 == 1) {
                                println("$FIRST_PLAYER's turn:")
                            } else {
                                println("$SECOND_PLAYER's turn:")
                            }
                            answer = readln()
                            subCertain()
                        } else {
                            if (list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] == "   |") {
                                list[mapIndexes[answer[1].digitToInt()]!!][map[answer[0]]!!] = "   |"
                                list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] = " B |"
                                flag = true
                            } else {
                                println("Invalid Input6")
                                println("$SECOND_PLAYER's turn:")
                                answer = readln()
                                subCertain()
                            }


                        }

                    } else {
                        println("No black pawn at ${answer[0]}${answer[1]}")
                        println("$SECOND_PLAYER's turn:")
                        answer = readln()
                        subCertain()
                    }
                }
            }


        }

        printList()
        i++

        if (i % 2 == 1) {
            println("$FIRST_PLAYER's turn:")

        } else {
            println("$SECOND_PLAYER's turn:")
        }
        answer = readln()
        if (answer == "exit") {
            break@loop
        }
        countValidSteps = if (i % 2 == 1) {
            if (answer[1].digitToInt() == 2) {
                2
            } else {
                1
            }

        } else {
            if (answer[1].digitToInt() == 7) {
                2
            } else {
                1
            }
        }

    }
    println("Bye!")

}

fun createList() {
    for (i in 8 downTo 1) {
        val innerList = mutableListOf<String>()
        for (j in 8 downTo 1) {

            when (i) {
                2 -> {
                    innerList.add(" B |")
                }

                7 -> {
                    innerList.add(" W |")
                }

                else -> {
                    innerList.add("   |")
                }
            }

        }
        list.add(innerList)
    }
}

fun subCertain() {
    try {

        subtraction = if (i % 2 == 1) {
            answer[3].digitToInt() - answer[1].digitToInt()
        } else {
            answer[1].digitToInt() - answer[3].digitToInt()
        }
    } catch (_: Exception) {
    }
}

fun printList() {
    for (k in 8 downTo 1) {
        println("  +---+---+---+---+---+---+---+---+")
        print("$k ")
        print("|")
        for (j in 8 downTo 1) {
            print(list[k - 1][j - 1])

        }
        println()

    }
    println("  +---+---+---+---+---+---+---+---+")
    println("    a   b   c   d   e   f   g   h")
    println()
}
