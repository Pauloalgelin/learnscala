abstract class Element {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length
    def demo() = {println("Element's implementation invoked")}
    def above(that: Element): Element =
        new ArrayElement(this.contents ++ that.contents)
    def beside(that: Element): Element =
        new ArrayElement(
            for(
                (line0, line1) <- this.contents zip that.contents
            ) yield line0 + line1
        )
    override def toString = contents mkString "\n"
}

class ArrayElement(conts: Array[String]) extends Element {
    def contents: Array[String] = conts
    override def demo() = {println("ArrayElement's implementation invoked")}
}

class ParametricArrayElement(
    val contents: Array[String],
    override val height: Int
) extends Element

class LineElement(private val s: String) extends ArrayElement(Array(s)) {
    override val height = 1
    override val width = s.length
    override def demo() = {println("LineElement's implementation invoked")}
}

class UniformElement(
    ch: Char,
    override val height: Int,
    override val width: Int
) extends Element {
    private val line = ch.toString * width
    def contents = Array.fill(height)(line)
}

object Element {
    def main(args: Array[String]): Unit = {
        val ar = Array("Hello", "world")
        val ae = new ArrayElement(ar)
        val aewidth = ae.width
        println(s"ae.width = $aewidth")

        val er = ("aehoo")
        val e: Element = new ArrayElement(Array(er, er))
        val eheight = e.height
        println(s"e.height = $eheight")

        val wr = Array("123", "jdjd. jj", "dududu")
        val w = new ParametricArrayElement(wr, 1)
        val wcontents0 = w.contents(0)
        val wheight = w.height
        println(s"w.contents(0) = $wcontents0")
        println(s"w.height = $wheight")

        val lr = "Paulo"
        val le = new LineElement(lr)
        val lewidth = le.width
        println(s"le.width = $lr.length = $lewidth")

        val c: Char = 'a'
        val hei = 10
        val wid = 2
        val ue = new UniformElement(c, hei, wid)
        val uecontents = ue.contents
        println("ue.contents =");
        ue.contents.foreach(println)

        def invokedDemo(e: Element) = {
            e.demo()
        }

        print("ArrayElement: "); invokedDemo(new ArrayElement(Array("eu")))
        print("LineElement: "); invokedDemo(new LineElement("moo"))
        print("UniformElement: "); invokedDemo(new UniformElement('a', 3, 4))

        val aeabovee = ae above e
        println(aeabovee)

        val aebesidee = ae beside e
        println(aebesidee)
    }
}