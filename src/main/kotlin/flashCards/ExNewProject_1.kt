package flashCards

import java.io.File
import java.io.FileNotFoundException
import kotlin.math.log

var mapOfCards = mutableMapOf<String, String>()
var mapOfWrongCards = mutableMapOf<String, Int>()
val separator: String = File.separator
val workingDirectory: String = System.getProperty("user.dir")
val logList = mutableListOf<String>()

fun main() {


//    println("Input the number of cards:")
//    val countCards = readln().toInt()
//    for (i in 1..countCards) {
//        println("Card #$i:")
//        var term: String
//        var definition: String
//        while (true) {
//            term = readln()
//            if (mapOfCards.containsKey(term)) {
//                println("The term \"${term}\" already exists. Try again:")
//            } else {
//                break
//            }
//        }
//        println("The definition for card #$i:")
//        while (true) {
//            definition = readln()
//            if (mapOfCards.containsValue(definition)) {
//                println("The definition \"${definition}\" already exists. Try again:")
//            } else {
//                break
//            }
//        }
//        mapOfCards[term] = definition
//    }
//    for (n in mapOfCards.entries) {
//        println("Print the definition of \"${n.key}\":")
//        val answer = readln()
//        if (n.value == answer) {
//            println("Correct!")
//        } else {
//            if (mapOfCards.values.contains(answer)) {
//                println(
//                    "Wrong. The right answer is \"${n.value}\"," +
//                            " but your definition is correct" +
//                            " for \"${mapOfCards.entries.first { x -> x.value == answer && n.key != x.key }.key}\"."
//                )
//            } else {
//                println("Wrong. The right answer is \"${n.value}\".")
//            }
//
//        }
//    }

    while (true) {
        println("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):")
        logList.add("Input the action (add, remove, import, export, ask, exit, log, hardest card, reset stats):\n")
        val action = readln()
        logList.add(action + "\n")
        when (action) {
            "add" -> add()
            "remove" -> remove()
            "import" -> importData()
            "export" -> export()
            "ask" -> ask()
            "log" -> logApp()
            "hardest card" -> hardestCards()
            "reset stats" -> resetStats()
            "exit" -> {
                println("Bye bye!")

                break
            }

        }
    }

}

fun resetStats() {
    println("Card statistics have been reset.\n")
    logList.add("Card statistics have been reset.\n")
    mapOfWrongCards.clear()

}

fun hardestCards() {
    if (mapOfWrongCards.isEmpty()) {
        println("There are no cards with errors.\n")
        logList.add("There are no cards with errors.\n")
    } else {
        val maxWrong = mapOfWrongCards.values.maxOrNull()
        val listHardestCard = mutableListOf<String>()
        for (i in mapOfWrongCards) {
            if (i.value == maxWrong && maxWrong != 0 && maxWrong != null) {
                listHardestCard.add(i.key)
            }
        }
        val strList = listHardestCard.joinToString("\", \"")
        if (listHardestCard.size == 1) {
            println("The hardest card is \"${listHardestCard[0]}\". You have ${mapOfWrongCards[listHardestCard[0]]} errors answering it.\n")
            logList.add("The hardest card is \"${listHardestCard[0]}\". You have ${mapOfWrongCards[listHardestCard[0]]} errors answering it.\n")
        } else {

            println("The hardest cards are \"${strList}\". You have ${mapOfWrongCards[listHardestCard[0]]} errors answering them.\n")
            logList.add("The hardest cards are \"${strList}\". You have ${mapOfWrongCards[listHardestCard[0]]} errors answering them.\n")
        }
    }

}

fun logApp() {
    println("File name:")
    val fileName = readln()
    logList.add("File name:\n")
    logList.add(fileName + "\n")
    //val f = File("C:\\IdeaProjects\\HelloKotlin\\src\\waterMark.main\\kotlin\\exchange\\${fileName}")
    val f = File("$workingDirectory$separator${fileName}")
    for (i in 0 until logList.size) {
        f.appendText(logList[i])
    }
    println("The log has been saved.\n")
    logList.add("The log has been saved.\n")
}

fun add() {
    println("The card:")
    logList.add("The card:\n")
    val definition: String

    val term: String = readln()
    logList.add(term + "\n")
    if (mapOfCards.containsKey(term)) {
        println("The card \"${term}\" already exists.\n")
        logList.add("The card \"${term}\" already exists.\n")
    } else {
        println("The definition of the card:")
        logList.add("The definition of the card:\n")

        definition = readln()
        logList.add(definition + "\n")
        if (mapOfCards.containsValue(definition)) {
            println("The definition \"${definition}\" already exists.\n")
            logList.add("The definition \"${definition}\" already exists.\n")
        } else {
            mapOfCards[term] = definition
            println("The pair (\"${term}\":\"${definition}\") has been added.\n")
            logList.add("The pair (\"${term}\":\"${definition}\") has been added.\n")
        }
    }


}

fun remove() {
    println("Which card?")
    logList.add("Which card?\n")
    val term = readln()
    logList.add(term + "\n")
    if (mapOfCards.containsKey(term)) {
        mapOfCards.remove(term)
        println("The card has been removed.\n")
        logList.add("The card has been removed.\n")
    } else {
        println("Can't remove \"${term}\": there is no such card.\n")
        logList.add("Can't remove \"${term}\": there is no such card.\n")
    }


}

fun importData() {
    println("File name:")
    logList.add("File name:\n")
    try {
        val f = File(readln())
        logList.add(f.toString() + "\n")
        val countCardsInBefore = mapOfCards.size
        val cardsFile = File("$workingDirectory$separator$f").readLines() as MutableList<String>
        //val cardsFile =             File("C:\\IdeaProjects\\HelloKotlin\\src\\waterMark.main\\kotlin\\exchange\\$f").readLines() as MutableList<String>
        if (cardsFile.size != 0) {
            for (l in 0 until cardsFile.size - 1 step 3) {
                mapOfCards[cardsFile[l]] = cardsFile[l + 1]
                if (cardsFile[l + 2].toIntOrNull() != null) {
                    val n = mapOfWrongCards[cardsFile[l]]
                    if (n != null) {
                        mapOfWrongCards[cardsFile[l]] = n + cardsFile[l + 2].toInt()
                    } else {
                        mapOfWrongCards[cardsFile[l]] = cardsFile[l + 2].toInt()
                    }

                } else {
                    mapOfWrongCards[cardsFile[l]] = 0
                }


            }
        }
        println("${(mapOfCards.size - countCardsInBefore)} cards have been loaded.\n")
        logList.add("${(mapOfCards.size - countCardsInBefore)} cards have been loaded.\n")
    } catch (e: FileNotFoundException) {
        println("File not found.\n")
        logList.add("File not found.\n")
    }
}

fun export() {
    println("File name:")
    logList.add("File name:\n")
    val fileName = readln()
    logList.add(fileName + "\n")

    //val f = readln()
    //val f = File("C:\\IdeaProjects\\HelloKotlin\\src\\waterMark.main\\kotlin\\exchange\\${fileName}")
    val f = File("$workingDirectory$separator${fileName}")
    //val cardsFile = File("${waterMark.getWorkingDirectory}${waterMark.getSeparator}$f").readLines() as MutableList<String>

    for (n in mapOfCards.entries) {
        f.appendText(n.key + "\n")
        f.appendText(n.value + "\n")
        f.appendText(mapOfWrongCards[n.key].toString() + "\n")
    }

    println("${(mapOfCards.size)} cards have been saved.\n")
    logList.add("${(mapOfCards.size)} cards have been saved.\n")

}

fun ask() {
    if (mapOfWrongCards.isEmpty()) {
        for (i in mapOfCards.keys) {
            mapOfWrongCards[i] = 0
        }
    }

    println("How many times to ask?")
    logList.add("How many times to ask?\n")
    val countAsk = readln().toInt()
    logList.add(countAsk.toString() + "\n")
    var k = 0
    while (true) {
        if (k == countAsk) {
            break
        }
        for (i in 0 until mapOfCards.keys.size) {
            if (k == countAsk) {
                break
            }

            val ranKey = mapOfCards.keys.toList().sorted()[i]

            println("Print the definition of \"${ranKey}\":")
            logList.add("Print the definition of \"${ranKey}\":\n")

            val answer = readln()
            logList.add(answer + "\n")
            if (mapOfCards[ranKey] == answer) {
                println("Correct!")
                logList.add("Correct!\n")

            } else {
                val intI = mapOfWrongCards[ranKey]
                if (intI != null) {
                    mapOfWrongCards[ranKey] = intI + 1
                }
                if (mapOfCards.values.contains(answer)) {
                    println(
                        "Wrong. The right answer is \"${mapOfCards[ranKey]}\"," +
                                " but your definition is correct" +
                                " for \"${mapOfCards.entries.first { x -> x.value == answer && ranKey != x.key }.key}\".\n"
                    )

                    logList.add(
                        "Wrong. The right answer is \"${mapOfCards[ranKey]}\"," +
                                " but your definition is correct" +
                                " for \"${mapOfCards.entries.first { x -> x.value == answer && ranKey != x.key }.key}\".\n"
                    )
                } else {
                    println("Wrong. The right answer is \"${mapOfCards[ranKey]}\".")
                    logList.add("Wrong. The right answer is \"${mapOfCards[ranKey]}\".\n")
                }

            }
            k++
        }
    }
    println()
}
