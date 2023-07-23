package exchange

class Cat(val name: String, val color: String) {
    fun sayMeow() {
        println("$name says: \"Meow\".")
    }

    inner class Bow(private val color: String) {
        fun putOnABow() {
            sayMeow()
            println("The bow is on!")
        }

        fun printColor() {
            println("The cat named $name is ${this@Cat.color} and has a $color bow.")
        }
    }

    val catBow = Bow("Green")
}

fun main() {
    val cat: Cat = Cat("Bob", "grey")
    val bow: Cat.Bow = cat.Bow("red")

    bow.printColor()
//    The cat named Bob has a red bow.
    println()


    val cat2: Cat = Cat("Princess", "white")
    val bow2: Cat.Bow = cat2.Bow("golden")

    bow2.printColor()
    bow2.putOnABow()
//
//    The cat named Princess has a golden bow.
//    Princess says: "Meow".
//    The bow is on!

}