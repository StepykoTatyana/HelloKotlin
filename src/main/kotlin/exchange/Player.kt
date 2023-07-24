package exchange


class Player(val id: Int) {


    object Properties {

        init {
            val playerId =
                5
            val  a = 0
            var ddd = 5
            var str = "dsfs"
        }
        /* Default player speed in playing field – 7 cells per turn */
        const val DEFAULT_SPEED = 7

        fun calcMovePenalty(cell: Int): Int {
            return 20
        }
        val superSpeed = Properties.DEFAULT_SPEED * 2 // 14
    }


    object Factory {
        fun create(playerId: Int): Player {
            check(playerId>0)
            return Player(playerId)
        }
    }


}


