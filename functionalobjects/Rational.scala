class Rational(n: Int, d: Int) {
    
    require(d != 0)
    
    private val g = gcd(n.abs, d.abs)
    
    val numer: Int = n / g
    val denom: Int = d / g

    def this(n: Int) = this(n, 1)

    def +(that: Rational): Rational = {
        new Rational(
            this.numer * that.denom + that.numer * this.denom,
            this.denom * that.denom
        )
    }

    def +(i: Int): Rational = {
        new Rational(
            this.numer + i * this.denom,
            this.denom
        )
    }

    def -(that: Rational): Rational = {
        new Rational(
            this.numer * that.denom - that.numer * this.denom,
            this.denom * that.denom
        )
    }

    def -(i: Int): Rational = {
        new Rational(
            this.numer - i * this.denom,
            this.denom
        )
    }

    def *(that: Rational): Rational = {
        new Rational(
            this.numer * that.numer,
            this.denom * that.denom
        )
    }

    def *(i: Int): Rational = {
        new Rational(
            this.numer * i,
            this.denom
        )
    }

    def /(that: Rational): Rational = {
        new Rational(
            this.numer * that.denom,
            this.denom * that.numer
        )
    }

    def /(i: Int): Rational = {
        new Rational(
            this.numer,
            this.denom * i
        )
    }

    def unary_+(): Rational = this

    def unary_-(): Rational = {
        if(this.numer < 0 || this.denom < 0)
            new Rational(this.numer.abs, this.denom.abs)
        else
            this
    }


    def lessThan(that: Rational): Boolean = {
        this.numer * that.denom < that.numer * this.denom
    }

    def max(that: Rational): Rational = {
        if(this.lessThan(that)) that else this
    }

    override def toString = numer + "/" + denom
    
    private def gcd(a: Int, b: Int): Int =
        if (b == 0) a else gcd(b, a % b)
}