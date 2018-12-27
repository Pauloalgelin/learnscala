import Element.elem

abstract class Element {
    def contents: Array[String]
    def width: Int = contents(0).length
    def height: Int = contents.length
    def above(that: Element): Element = {
        val this1 = this widen that.width
        val that1 = that widen this.width
        elem(this1.contents ++ that1.contents)
    }
    def beside(that: Element): Element = {
        val this1 = this heighten that.height
        val that1 = that heighten this.height
        elem(
        for ((line1, line2) <- this1.contents zip that1.contents)
        yield line1 + line2)
    }
    def widen(w: Int): Element =
        if (w <= width) this
        else {
            val left = elem(' ', (w - width) / 2, height)
            val right = elem(' ', w - width - left.width, height)
            left beside this beside right
        }
    def heighten(h: Int): Element =
        if (h <= height) this
        else {
            val top = elem(' ', width, (h - height) / 2)
            val bot = elem(' ', width, h - height - top.height)
            top above this above bot
        }
    override def toString = contents mkString "\n"
}

object Element {
    private class ArrayElement(
        val contents: Array[String])
    extends Element

    private class ParametricArrayElement(
        val contents: Array[String],
        override val height: Int
    ) extends Element

    private class LineElement(private val s: String) extends ArrayElement(Array(s)) {
        override val height = 1
        override val width = s.length
    }

    private class UniformElement(
        ch: Char,
        override val height: Int,
        override val width: Int
    ) extends Element {
        private val line = ch.toString * width
        def contents = Array.fill(height)(line)
    }

    def elem(contents: Array[String]): Element =
        new ArrayElement(contents)

    def elem(ch: Char, width: Int, height: Int): Element =
        new UniformElement(ch = ch, width = width, height = height)

    def elem(line: String): Element =
        new LineElement(line)
}

object run {
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

        val aeabovee = ae above e
        println(aeabovee)

        val aebesidee = ae beside e
        println(aebesidee)

        val are = Array("este", "teste")
        val ear = elem(are)
        println(ear)

        val cc: Char = 'j'
        val wi = 3
        val he = 8
        val un = elem(cc, width = wi, height = he)
        println(un)

        val st = "salve regina"
        val li = elem(st)
        println(li)
        println
        val earbesideli = ear beside li
        println(earbesideli)
    }
}

object Spiral {
    val space = elem(" ")
    val corner = elem("+")
    def spiral(nEdges: Int, direction: Int): Element = {
        if (nEdges == 1)
            elem("+")
        else {
            val sp = spiral(nEdges - 1, (direction + 3) % 4)
            def verticalBar = elem('|', 1, sp.height)
            def horizontalBar = elem('-', sp.width, 1)
            if (direction == 0)
                (corner beside horizontalBar) above (sp beside space)
            else if (direction == 1)
                (sp above space) beside (corner above verticalBar)
            else if (direction == 2)
                (space beside sp) above (horizontalBar beside corner)
            else
                (verticalBar above corner) beside (space above sp)
        }
    }

    def main(args: Array[String]) = {
        val nSides = args(0).toInt
        println(spiral(nSides, 0))
    }
}