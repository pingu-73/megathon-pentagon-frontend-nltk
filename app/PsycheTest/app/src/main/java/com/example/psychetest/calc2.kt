package com.example.psychetest

class calc2 (var O : Int, var C : Int, var E : Int, var A : Int, var N : Int) {
    public fun addValues(o: Int, c: Int, e: Int, a: Int, n: Int) {
        this.O += o
        this.C += c
        this.E += e
        this.A += a
        this.N += n
    }

    fun subtractValue(o: Int, c: Int, e: Int, a: Int, n: Int) {
        this.O -= o
        this.C -= c
        this.E -= e
        this.A -= a
        this.N -= n
    }
}

object CALC2 {
    var O : Int = 0
    var C : Int = 0
    var E : Int = 0
    var A : Int = 0
    var N : Int = 0

    public fun addValues(o: Int, c: Int, e: Int, a: Int, n: Int) {
        this.O += o
        this.C += c
        this.E += e
        this.A += a
        this.N += n
    }

    fun subtractValue(o: Int, c: Int, e: Int, a: Int, n: Int) {
        this.O -= o
        this.C -= c
        this.E -= e
        this.A -= a
        this.N -= n
    }
}