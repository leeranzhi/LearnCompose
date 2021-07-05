package com.example.layoutscodelab

import androidx.lifecycle.LifecycleObserver
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        var code = 0
        for (i in 0..5) {
//            val newCode = object : TestInterface {
//                override fun test() {
//
//                }
//            }.hashCode()
//
            val newCode = Runnable {

            }.hashCode()

            val newCode2 = object : Runnable {
                override fun run() {
                }
            }.hashCode()

            val newCode3 = Runnable {
                code
            }.hashCode()

            println()

            if (code == newCode) {
                println("Key clash! : $code")
                return
            }
            code = newCode
        }
    }

    @Test
    fun test() {
        val testInterfaceIntegerHashMap = HashMap<TestInterface, Int>()
        for (i in 0..9999) {
            testInterfaceIntegerHashMap[object : TestInterface {
                override fun test(`var`: String?, var2: String?) {

                }
            }] = i
        }
        println(testInterfaceIntegerHashMap.size)

    }
    fun tsets(param: Int): String {
        return param.toString()
    }
}