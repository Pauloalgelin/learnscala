class Point(val x: Int, val y: Int)

trait Rectangular {
    def topLeft: Point
    def bottomRight: Point
    def left = topLeft.x
    def right = bottomRight.x
    def width = right - left
}

abstract class Component extends Rectangular {
    // more methods
}

class Rectangle(val topLeft: Point, val bottomRight: Point)
    extends Rectangular {
        // some methods
    }

class Animal

trait Philosophical {
    def philosophize() = {
        println("I consume memory, therefore I am!")
    }
}

class Frog extends Animal with Philosophical {
    override def toString = "green"
    override def philosophize() = {
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

        val pt0 = new Point(1, 1)
        val pt1 = new Point(10, 10)
        val rec = new Rectangle(pt0, pt1)
        val recleft = rec.left
        println(s"rec.left = $recleft")
    }
}