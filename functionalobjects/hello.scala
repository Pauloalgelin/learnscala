import scala.language.implicitConversions

class ChecksumAccumulator {
    private var sum = 0
    def add(b: Byte) = sum += b
    def checksum() = ~ (sum & 0xFF) + 1
    def unary_!(): Int = 2
}

object ChecksumAccumulator {
    def main(args: Array[String]) = {
        val ar = new ChecksumAccumulator
        val ra   = new ChecksumAccumulator
        println(ar.sum)
        println(ra.sum)
        ar add 1
        println(ar == ra)
        val rt1 = new Rational(1, 3)
        val rt2 = new Rational(1, 2)
        val res1 = rt1 + rt2
        println(res1)
        val rt3 = new Rational(5, 10)
        println(rt3)
        val res2 = res1 * rt3
        println(res2)
        val res3 = rt1 + rt2 * rt3
        println(rt1 + " + " + rt2 + " * " + rt3 + " = " + res3)
        println("+" + res3 + " = " + +res3)
        val nega = new Rational(-3, 9)
        println(nega)
        val maisnega = +nega
        println("+" + nega + " = " + maisnega)
        val minusnega = -nega
        println("-" + nega + " = " + minusnega)
        val negamais2 = nega + 2
        println(nega + " + " + "2" + " = " + negamais2)
        implicit def intToRational(x: Int) = new Rational(x)
        val doismaisnega = 2 + nega
        println("2" + " + " + nega + " = " + doismaisnega)
        val rt1vezes4 = rt1 * 4
        println(rt1 + " * " + "4" + " = " + rt1vezes4)
        val rt1minusrt2 = rt1 - rt2
        println(rt1 + " - " + rt2 + " = " + rt1minusrt2)
        val rt2minusrt1 = rt2 - rt1
        println(rt2 + " - " + rt1 + " = " + rt2minusrt1)
        val rt1minus1 = rt1 - 1
        println(rt1 + " - " + "1" + " = " + rt1minus1)
        val threeminusnega = 4 - nega
        println("4 - " + nega + " = " + threeminusnega)
        val r1divnega = rt1 / nega
        println(rt1 + " / " + nega + " = " + r1divnega)
        val rt2div7 = rt2 / 7
        println(rt2 + " / " + "7" + " = " + rt2div7)
        val sixdivnega = 6 / nega
        println("6 / " + nega + " = " + sixdivnega)
    }
}