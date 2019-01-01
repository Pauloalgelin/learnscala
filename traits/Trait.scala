class Animal

trait Philosophical {
    def philosophize = {
        println("I consume memory, therefore I am!")
    }
}

trait HasLegs

class Frog extends Animal with Philosophical with HasLegs {
    override def toString = "green"
}

object run {
    def main(args: Array[String]): Unit = {
        val fo0 = new Frog
        println(fo0)
        fo0.philosophize

        val fo1: Philosophical = new Frog
        println(fo1)
        fo1.philosophize
    }
}