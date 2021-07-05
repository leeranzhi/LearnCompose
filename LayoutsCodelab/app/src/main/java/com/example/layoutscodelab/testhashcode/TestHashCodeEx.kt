package com.example.layoutscodelab.testhashcode

class TestHashCodeEx {
    fun test1111() {
        var code = 0
        for (i in 0..5) {
            val newCode = Runnable {

            }.hashCode()

            val newCode2 = object : Runnable {
                override fun run() {
                }
            }.hashCode()

            val newCode3 = Runnable {
                code
            }.hashCode()

            println(newCode2)
            println(newCode3)

            if (code == newCode) {
                println("Key clash! : $code")
                return
            }
            code = newCode
        }
    }

    private fun b(param: Int = 0): TestHashCodeEx {

        a(fun(param: Int): String {
            return param.toString()
        })
        return TestHashCodeEx()
    }

    private fun a(function: (Int) -> String) {
        TODO("Not yet implemented")
    }


    val d = fun(param: Int): String {
        return param.toString()
    }

    val b: (Int) -> String = {
        it.toString() // it 可以被推断出是 Int 类型
    }
}