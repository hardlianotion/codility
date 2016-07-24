/**
  * Created by etuka on 24/07/2016.
  */
import org.scalatest._
import EuclideanAlgorithm.CommonPrimeDivisors

class EuclideanAlgorithm extends FunSuite {

  test("CommonPrimeDivisors should count pairs in arrays that have exactly the same distinct primes") {
    val A = Array(15, 10, 3)
    val B = Array(75, 30, 5)

    assert(CommonPrimeDivisors.solution(A, B) == 1)
  }
}
