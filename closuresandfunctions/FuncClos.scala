import scala.io.Source

object LongLines {
    def processFile(filename: String, width: Int) = {
        val source = Source.fromFile(filename)
        for (line <- source.getLines())
            processLine(line)

        def processLine(line: String) = {
            if (line.length > width)
                println(filename + ": " + line.trim)
        }

    }

}

object FuncClos {
    def main(args: Array[String]): Unit = {
        // val width = args(0).toInt
        // for (arg <- args.drop(1))
        //     LongLines.processFile(arg, width)

        var increase = (x: Int) => x + 1
        val num2 = increase(1)
        println("increase(1): " + num2)

        increase = (x: Int) => x + 3
        val num3 = increase(1)
        println("increase(1): " + num3)

        val increasehello = (x: Int) => {
            println("Hello,")
            println("world!")
            x + 1
        }
        val num4 = increasehello(4)
        println("increasehello(4): " + num4)

        val myNums = List(-11, -10, -5, 0, 5, 10)
        println("myNums: " + myNums)
        myNums.foreach(x => print(x + " "))
        println("")

        val positives = myNums.filter(x => x > 0) // Target typing
        println("positives: " + positives)

        val newpositives = myNums.filter(_ > 0) // Placeholder syntax
        println("newpositives: " + newpositives)

        myNums.foreach(println _) // Partially applied function

        def sum(a: Int, b: Int, c: Int) = a + b + c
        val sum123 = sum(1, 2, 3)
        println("sum(1, 2, 3): " + sum123)

        val three = sum _
        val sumthree = three(1, 2, 3)
        println("three(1, 2, 3): " + sumthree)

        val sumto1and3 = sum(1, _: Int, 3)
        val sum2to1and3 = sumto1and3(2)
        println("sumto1and3(2): " + sum2to1and3)

        def increaser(more: Int) = (x: Int) => x + more
        val increaser1 = increaser(1)
        val increaser2 = increaser(2)
        val inc1of5 = increaser1(5)
        val inc2of5 = increaser2(5)
        println("increaser1(5): " + inc1of5)
        println("increaser2(5): " + inc2of5)

        def echo(args: String*) = args.foreach(println) // Repeated parameter
        echo("hi")
        echo("hi", "hi")
        val myL = List("hey", "hey", "hey")
        echo(myL: _*)
        echo()

        def speed(distance: Float, time: Float): Float = distance / time
        val speed0 = speed(100, 10)
        val speed1 = speed(distance = 100, time = 10)
        val speed2 = speed(time = 10, distance = 100)
        println("speed(100, 10): " + speed0)
        println("speed(distance = 100, time = 10): " + speed1)
        println("speed(time = 10, distance = 100): " + speed2)
    }
}