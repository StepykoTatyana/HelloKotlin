package exchange

class Superhero {
    private val power = 1000

    class MagicCloak {
        // you cannot access something from Superhero here
        val magicPower = 100
    }

    // you need to create a MagicCloak object to access its members
    val magicPower = power * MagicCloak().magicPower

    class Hammer {
        // you cannot access power property from Superhero here
        val mightPower = 100
    }

    val mightPower = power * Hammer().mightPower
}

fun main() {
    val cloak = Superhero.MagicCloak()
    val hammer = Superhero.Hammer()
}
