class Animal

trait Philosophical {
    def philosophize = {
        println("I consume memory, therefore I am!")
    }
}

class Frog extends Animal with Philosophical {
    override def toString = "green"
    override def philosophize = {
        println(s"It ain't easy being $toString!")
    }
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