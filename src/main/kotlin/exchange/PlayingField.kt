package exchange

object PlayingField {


    object Size {
        var width: Int = 0
        var height: Int = 0
    }

    fun changeSize(newWidth: Int, newHeight: Int) {
        PlayingField.Size.apply {
            width = newWidth
            height = newHeight
        }
    }


    fun getAllPlayers(): Array<Player> {
        return mutableListOf<Player>().toTypedArray()
    }

    fun isPlayerInGame(player: Player): Boolean {
        /* ... */
        return false
    }
}

fun main() {
    val v1 = listOf<String>()
    val v2 = listOf<String>("hgjhgjhg")
    val v = listOf<String>("hgjhgjhg", "j")
    /* prints 7 */
    println(Player.Properties.DEFAULT_SPEED)

    /* prints 13 */
//    Player.Factory.create(13).id
    val b = Player.Properties
println(b)
}

fun startNewGameTurn() {
    val players = PlayingField.getAllPlayers()
    if (players.size < 2) {
        return println("The game cannot be continued without players")
    }
    for (player in players) {
        nextPlayerTurn(player)
    }
}

fun nextPlayerTurn(player: Player) {
    if (!PlayingField.isPlayerInGame(player)) {
        return println("Current player lost. Next...")
    }
    /* Player actions here */
}

