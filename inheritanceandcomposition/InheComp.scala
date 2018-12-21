abstract class Element {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length
}

class ArrayElement(conts: Array[String]) extends Element {
    def contents: Array[String] = conts
}

class ParametricArrayElement(
    val contents: Array[String],
    override val height: Int
) extends Element

class LineElement(private val s: String) extends ArrayElement(Array(s)) {
    override val height = 1
    override val width = s.length
}

object Element {
    def main(args: Array[String]): Unit = {
        val ar = Array("Hello", "world")
        val ae = new ArrayElement(ar)
        val aewidth = ae.width
        println(s"ae.width = $aewidth")

        val er = ("aehoo")
        val e: Element = new ArrayElement(Array(er))
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
    }
}