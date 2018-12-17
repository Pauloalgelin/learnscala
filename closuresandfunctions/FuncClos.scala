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
    }
}