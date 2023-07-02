package exchange

import java.util.*
import kotlin.random.Random

var countExplodedMines = 0
var countMines = 0
var countMisses = 0
fun main() {




    ArrayForGame
    countMines = inputUser(ArrayForGame.array, ArrayForGame.arrayMatched)
    matchMines(
        ArrayForGame.array, ArrayForGame.arrayWithoutMines,
        ArrayForGame.arrayMatched
    )
    printArea(ArrayForGame.arrayWithoutMines)
    findMines(ArrayForGame.array, ArrayForGame.arrayWithoutMines, ArrayForGame.arrayMatched)
}


fun generatePredictablePassword(seed: Int): String {
    var randomPassword = ""
    val randomGenerator42 = Random(seed) // the generator takes the seed
    for (i in 0..9) {
        randomPassword += randomGenerator42.nextInt(33, 127).toChar()
    }
    return randomPassword
}

fun printArea(array: MutableList<Array<String?>>) {
    print("\n |")
    for (k in 1..9) {
        print(k)
    }
    println("|")
    print("-|")
    for (k in 1..9) {
        print("-")
    }
    println("|")
    for (i in 0 until ArrayForGame.columnCount) {
        print((i + 1).toString() + "|")
        for (j in 0 until ArrayForGame.lineCount) {
            print(array[i][j])
        }
        println("|")
    }
    print("-|")
    for (k in 1..9) {
        print("-")
    }
    println("|")
}


fun inputUser(array: MutableList<Array<String?>>, arrayMatched: MutableList<Array<String?>>): Int {
    val scanner = Scanner(System.`in`)
    print("How many mines do you want on the field? ")
    val countMinesFromUser = scanner.nextInt()
    if (countMinesFromUser <= ArrayForGame.columnCount * ArrayForGame.lineCount) {
        createMinesToArray(countMinesFromUser, array, arrayMatched)
        return countMinesFromUser
    }
    return 0
}

fun createMinesToArray(countMines: Int, array: MutableList<Array<String?>>, arrayMatched: MutableList<Array<String?>>) {
    val random = java.util.Random()
    var cooX = random.nextInt(ArrayForGame.columnCount)
    var cooY = random.nextInt(ArrayForGame.lineCount)
    var k = 0
    while (k != countMines) {
        if (array[cooX][cooY] != "X") {
            array[cooX][cooY] = "X"
            arrayMatched[cooX][cooY] = "X"
            k++
        }
        cooX = random.nextInt(ArrayForGame.columnCount)
        cooY = random.nextInt(ArrayForGame.lineCount)
    }
}

fun matchMines(
    array: MutableList<Array<String?>>,
    arrayWithoutMines: MutableList<Array<String?>>,
    arrayMatched: MutableList<Array<String?>>,
) {
    for (i in 0 until ArrayForGame.columnCount) {
        for (j in 0 until ArrayForGame.lineCount) {
            if (array[i][j] == "X") {
                val cooX = intArrayOf(i - 1, i, i + 1)
                val cooY = intArrayOf(j - 1, j, j + 1)
                for (a in cooX) {
                    for (b in cooY) {
                        try {
                            if ((arrayMatched[a][b] != ".") and (arrayMatched[a][b] != "X")) {
                                arrayMatched[a][b] = (arrayMatched[a][b]!!.toInt() + 1).toString()
                            } else if (arrayMatched[a][b] != "X") {
                                arrayMatched[a][b] = arrayMatched[a][b]!!.replace(".", "1")
                            }
                        } catch (_: Exception) {
                        }
                    }
                }
            }
        }
    }
    ArrayForGame.array = array
    ArrayForGame.arrayWithoutMines = arrayWithoutMines
    ArrayForGame.arrayMatched = arrayMatched

}


private fun findMines(
    array: MutableList<Array<String?>>,
    arrayWithoutMines: MutableList<Array<String?>>,
    arrayMatched: MutableList<Array<String?>>
) {
    var result = 0
    while ((countExplodedMines != countMines) or (countMisses != 0)) {
        while (result != 1) {
            print("Set/delete mines marks (x and y coordinates): ")
            val scanner = Scanner(System.`in`)
            val User_y = scanner.nextInt()
            val User_x = scanner.nextInt()
            val typeCell = scanner.next()
            result = checkMines(User_x, User_y, typeCell, array, arrayWithoutMines, arrayMatched)
            if (result == 2) {
                break
            }
        }
        printArea(arrayWithoutMines)
        //printArea(arrayMatched);
        //printArea(arrayMatched);
        if (result == 2) {
            println("You stepped on a mine and failed!")
            break
        }
        result = 0
    }
    if (result != 2) {
        println("Congratulations! You found all the mines!")
    }
}


private fun checkMines(
    user_x: Int,
    user_y: Int,
    typeCell: String,
    array: MutableList<Array<String?>>,
    arrayWithoutMines: MutableList<Array<String?>>,
    arrayMatched: MutableList<Array<String?>>
): Int {
    var user_x = user_x - 1
    var user_y = user_y - 1
    println(user_x)
    println(user_y)
    println(array[user_x][user_y])
    if (array[user_x][user_y] == "X") {
        if (typeCell == "free") {
            for (i in 0 until ArrayForGame.columnCount) {
                for (j in 0 until ArrayForGame.lineCount) {
                    if (arrayMatched[i][j] == "X") {
                        arrayWithoutMines[i][j] = "X"
                    }
                }
            }
            return 2
        } else {
            if (arrayWithoutMines[user_x][user_y] == "*") {
                arrayWithoutMines[user_x][user_y] = ArrayForGame.arrayWithoutMinesCopy[user_x][user_y]!!
                countExplodedMines--
            } else {
                arrayWithoutMines[user_x][user_y] = "*"
                countExplodedMines++
            }
        }
    } else {
        if (typeCell == "free") {
            if (arrayWithoutMines[user_x][user_y] == "*") {
                arrayWithoutMines[user_x][user_y] = ArrayForGame.arrayWithoutMinesCopy[user_x][user_y]!!
                countMisses--
            } else {
                val deque: Deque<IntArray?> = ArrayDeque()
                val queueNext: Deque<IntArray> = ArrayDeque()
                deque.add(intArrayOf(user_x, user_y))
                var i = 1
                var existMine = 0
                while ((queueNext.size != 0) or (i != 0)) {
                    val cooX = intArrayOf(
                        user_x,
                        user_x - 1,
                        user_x + 1,
                        user_x,
                        user_x - 1,
                        user_x + 1,
                        user_x - 1,
                        user_x + 1
                    )
                    val cooY = intArrayOf(
                        user_y - 1,
                        user_y,
                        user_y,
                        user_y + 1,
                        user_y - 1,
                        user_y - 1,
                        user_y + 1,
                        user_y + 1
                    )
                    for (j in 0..7) {
                        try {
                            if (array[cooX[j]][cooY[j]] == "X") {
                                array[user_x][user_y] = arrayMatched[user_x][user_y]
                                arrayWithoutMines[user_x][user_y] = arrayMatched[user_x][user_y]
                                ArrayForGame.arrayWithoutMinesCopy[user_x][user_y] = arrayMatched[user_x][user_y]
                                existMine = 1
                            }
                        } catch (ignored: java.lang.Exception) {
                        }
                    }
                    if (existMine == 0) {
                        for (j in 0..7) {
                            try {
                                if (arrayMatched[cooX[j]][cooY[j]] == ".") {
                                    arrayWithoutMines[cooX[j]][cooY[j]] = "/"
                                    ArrayForGame.arrayWithoutMinesCopy[cooX[j]][cooY[j]] = "/"
                                } else {
                                    arrayWithoutMines[cooX[j]][cooY[j]] = arrayMatched[cooX[j]][cooY[j]]
                                    ArrayForGame.arrayWithoutMinesCopy[cooX[j]][cooY[j]] =
                                        arrayMatched[cooX[j]][cooY[j]]
                                }
                                var wrong = 0
                                for (ints in deque) {
                                    if (Arrays.equals(ints, intArrayOf(cooX[j], cooY[j]))) {
                                        wrong = 1
                                        break
                                    }
                                }
                                for (ints in queueNext) {
                                    if (Arrays.equals(ints, intArrayOf(cooX[j], cooY[j]))) {
                                        wrong = 1
                                        break
                                    }
                                }
                                if (wrong == 0) {
                                    queueNext.add(intArrayOf(cooX[j], cooY[j]))
                                }
                            } catch (ignored: java.lang.Exception) {
                            }
                        }
                        if (arrayMatched[user_x][user_y] == ".") {
                            arrayWithoutMines[user_x][user_y] = "/"
                            ArrayForGame.arrayWithoutMinesCopy[user_x][user_y] = "/"
                        } else {
                            arrayWithoutMines[user_x][user_y] = arrayMatched[user_x][user_y]
                            ArrayForGame.arrayWithoutMinesCopy[user_x][user_y] = arrayMatched[user_x][user_y]
                        }
                    }
                    if (queueNext.size == 0) {
                        i = 0
                    } else {
                        val xAndY = queueNext.pollFirst()!!
                        user_x = xAndY[0]
                        user_y = xAndY[1]
                        deque.add(xAndY)
                        existMine = 0
                    }
                }
            }
        } else {
            if (arrayWithoutMines[user_x][user_y] == "*") {
                arrayWithoutMines[user_x][user_y] = ArrayForGame.arrayWithoutMinesCopy[user_x][user_y]!!
                countMisses--
            } else {
                arrayWithoutMines[user_x][user_y] = "*"
                countMisses++
            }
        }
    }
    val arrayForGame = ArrayForGame()
    ArrayForGame.array = array
    ArrayForGame.arrayWithoutMines = arrayWithoutMines
    ArrayForGame.arrayMatched = arrayMatched
    return 1
}


class ArrayForGame {

    companion object {
        var columnCount = 0
        var lineCount = 0
        var arrayWithoutMines: MutableList<Array<String?>>
        var arrayWithoutMinesCopy: MutableList<Array<String?>>
        var arrayMatched: MutableList<Array<String?>>
        var array: MutableList<Array<String?>>

        init {
            columnCount = 9
            lineCount = 9
            array = MutableList(columnCount) {
                arrayOfNulls(
                    lineCount
                )
            }
            arrayWithoutMines = MutableList(columnCount) {
                arrayOfNulls(
                    lineCount
                )
            }
            arrayMatched = MutableList(columnCount) {
                arrayOfNulls(
                    lineCount
                )
            }
            arrayWithoutMinesCopy = MutableList(columnCount) {
                arrayOfNulls(
                    lineCount
                )
            }
            for (i in 0 until columnCount) {
                for (j in 0 until lineCount) {
                    array[i][j] = "."
                    arrayWithoutMines[i][j] = "."
                    arrayMatched[i][j] = "."
                    arrayWithoutMinesCopy[i][j] = "."
                }
            }
        }
    }
}





