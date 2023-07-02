import java.lang.Exception

const val MAX_SEATS = 60
val cinema: MutableList<MutableList<String>> = mutableListOf()
var countSoldTickets = 0;
var countTicketsInCinema: Int = 0
var currentIncome = 0;
var fullIncomeOfCinema: Int = 0

fun main() {
    println("Enter the number of rows:")
    val countRows = readln().toInt()
    println("Enter the number of seats in each row:")
    val countSeats = readln().toInt()
    createCinema(countRows, countSeats, cinema)
    countTicketsInCinema = countRows * countSeats
    totalIncomeCount(countRows, countSeats)
    println()
    println(
        "1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit"
    )

    var action = readln().toInt()
    while (action != 0) {
        println()
        when (action) {
            1 -> printCinema(cinema)
            2 -> buyTicket(countRows, countSeats)
            3 -> statistics()
            0 -> break
        }
        println()
        println(
            "1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit"
        )
        action = readln().toInt()
    }


}

fun statistics() {
    val percentageDouble = countSoldTickets.toDouble() / countTicketsInCinema * 100
    var percentage = "%.2f".format(percentageDouble)

    println(
        "Number of purchased tickets: $countSoldTickets\n" +
                "Percentage: $percentage%\n" +
                "Current income: \$$currentIncome\n" +
                "Total income: \$$fullIncomeOfCinema"
    )

}

fun buyTicket(countRows: Int, countSeats: Int) {
    var flag = false
    while (!flag){
        println("Enter a row number:")
        val choseRows = readln().toInt()
        println("Enter a seat number in that row:")
        val choseSeats = readln().toInt()
        try {
            if (cinema[choseRows - 1][choseSeats - 1] != "B") {
                cinema[choseRows - 1][choseSeats - 1] = "B"
                priceChoseSeat(countRows, countSeats, choseRows)
                countSoldTickets++
                flag = true
            } else {
                println("\nThat ticket has already been purchased!\n")

            }
        } catch (e: Exception) {
            println("\nWrong input!\n")

        }
    }



}

fun totalIncomeCount(countRows: Int, countSeats: Int) {
    val maxSeats = 60
    var totalIncome: Int
    val totalSeats = countRows * countSeats
    //println("Total income:")
    if (totalSeats < maxSeats) {
        totalIncome = totalSeats * 10
        //println("$$totalIncome")
        fullIncomeOfCinema = totalIncome
    } else {
        totalIncome = (countRows / 2) * countSeats * 10
        totalIncome += (countRows - countRows / 2) * countSeats * 8

        fullIncomeOfCinema = totalIncome
    }
}

fun createCinema(
    countRows: Int, countSeats: Int,
    cinema: MutableList<MutableList<String>>
) {
    //println()
    //println("Cinema:")
    for (i in 1 until countSeats + 1) {
        if (i == 1) {
            //print("  ")
        }
        //print("$Ex4.getI ")
    }
    //println()
    for (i in 1 until countRows + 1) {
        val row: MutableList<String> = mutableListOf()
        for (k in 1 until countSeats + 1) {
            if (k == 1) {
                //print("$Ex4.getI ")
            }
            row.add("S")
            //print("S ")
        }
        cinema.add(row)
        //println()
    }
}

fun priceChoseSeat(
    countRows: Int, countSeats: Int, choseRows: Int
) {
    val price: Int
    val totalSeats = countRows * countSeats

    price = if (totalSeats < MAX_SEATS) {
        10
    } else {
        if (choseRows <= (countRows / 2)) {
            10
        } else {
            8
        }

    }
    println()
    println("Ticket price: $$price")
    currentIncome += price
}

fun printCinema(cinema: MutableList<MutableList<String>>) {
    println("Cinema:")
    for (i in 1 until cinema[0].size + 1) {
        if (i == 1) {
            print("  ")
        }
        print("$i ")
    }
    println()
    for (i in 1 until cinema.size + 1) {
        for (k in 1 until cinema[0].size + 1) {
            if (k == 1) {
                print("$i ")
            }
            print("${cinema[i - 1][k - 1]} ")
        }
        println()
    }
}