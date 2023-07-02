package exchange


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

    while (answer != "exit") {
        subCertain()
        var flag = false
        while (!answer.matches(regex) || subtraction > countValidSteps || subtraction < 1 || !flag) {
            flag = false
            if (answer == "exit") {
                break
            }
            if (!answer.matches(regex)) {
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
                    countValidSteps = if (answer[1].digitToInt() == 2) {
                        2
                    } else {
                        1
                    }
                    if (list[mapIndexes[answer[1].digitToInt()]!!][map[answer[0]]!!].contains("W")) {
                        if (subtraction > countValidSteps || subtraction < 1) {
                            println("Invalid Input")
                            println("$SECOND_PLAYER's turn:")
                            answer = readln()
                            subCertain()
                        } else {
                            if (answer[0] == answer[2]) {
                                if (list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] == "   |") {
                                    list[mapIndexes[answer[1].digitToInt()]!!][map[answer[0]]!!] = "   |"
                                    list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] = " W |"
                                    flag = true
                                } else {
                                    println("Invalid Input")
                                    println("$FIRST_PLAYER's turn:")
                                    answer = readln()
                                    subCertain()
                                }
                            } else {
                                if (list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] == " B |") {
                                    list[mapIndexes[answer[1].digitToInt()]!!][map[answer[0]]!!] = "   |"
                                    list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] = " W |"
                                    flag = true
                                } else {
                                    println("Invalid Input")
                                    println("$FIRST_PLAYER's turn:")
                                    answer = readln()
                                    subCertain()
                                }
                            }
                        }
                    } else {
                        printList()
                        println("No white pawn at ${answer[0]}${answer[1]}")
                        println("$FIRST_PLAYER's turn:")
                        answer = readln()
                        subCertain()
                    }
                } else {
                    countValidSteps = if (answer[1].digitToInt() == 7) {
                        2
                    } else {
                        1
                    }
                    if (list[mapIndexes[answer[1].digitToInt()]!!][map[answer[0]]!!].contains("B")) {
                        if (subtraction > countValidSteps || subtraction < 1) {
                            println("Invalid Input")
                            println("$SECOND_PLAYER's turn:")
                            answer = readln()
                            subCertain()
                        } else {
                            if (answer[0] == answer[2]) {
                                if (list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] == "   |") {
                                    list[mapIndexes[answer[1].digitToInt()]!!][map[answer[0]]!!] = "   |"
                                    list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] = " B |"
                                    flag = true
                                } else {
                                    println("Invalid Input")
                                    println("$SECOND_PLAYER's turn:")
                                    answer = readln()
                                    subCertain()
                                }
                            } else {
                                if (list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] == " W |") {
                                    list[mapIndexes[answer[1].digitToInt()]!!][map[answer[0]]!!] = "   |"
                                    list[mapIndexes[answer[3].digitToInt()]!!][map[answer[2]]!!] = " B |"
                                    flag = true
                                } else {
                                    println("Invalid Input")
                                    println("$SECOND_PLAYER's turn:")
                                    answer = readln()
                                    subCertain()
                                }
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
            break
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
