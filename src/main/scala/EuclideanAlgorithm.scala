/**
  * Created by etuka on 24/07/2016.
  */
package EuclideanAlgorithm {

  object CommonPrimeDivisors {
    def solution(A: Array[Int], B: Array[Int]): Int = {
      // write your code in Scala 2.10
      def gcd(a: Int, b: Int): Int = {
        //assume a > b
        val d = a / b
        val r = a - d * b

        if (r == 0)
          b
        else
          gcd(b, r)
      }

      def samePrimesAsGCD(a: Int, div: Int): Boolean = {
        //assume a > b > 1 and b | a
        val aPrime = a / div
        if (aPrime == 1)
          true
        else {
          val divPrime = gcd(aPrime, div)
          if (divPrime == 1)
            false
          else
            samePrimesAsGCD(aPrime, divPrime)
        }
      }

      def samePrimes(a: Int, b: Int): Boolean = {
        //assume a > b
        val gd = gcd(a, b)
        samePrimesAsGCD(a, gd) && samePrimesAsGCD(b, gd)
      }

      val data = A zip B
      data.foldLeft(0) {
        (count, tpl) => tpl match {
          case (x, y) if (x == y) => count + 1
          case (x, y) if x > y => if (samePrimes(x, y) == true) count + 1 else count
          case (x, y) if y > x => if (samePrimes(y, x) == true) count + 1 else count
        }
      }
    }
  }

}
