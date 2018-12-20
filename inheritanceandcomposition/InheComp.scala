abstract class Element {
    def contents: Array[String]
    def height: Int = contents.length
    def width: Int = if (height == 0) 0 else contents(0).length
}

class ArrayElement(conts: Array[String]) extends Element {
    def contents: Array[String] = conts
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
    }
}