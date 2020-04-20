object HigherOrderFunction {
  def main(args: Array[String]): Unit = {
    def test(f: Double => Double, f2: Double =>Int ,  n1: Double) = {
      f(f2(n1)) // f(0)
    }
    def sum(d: Double): Double = {
      d + d
    }

    def mod(d:Double): Int = {
      d.toInt % 2
    }

    println(test(sum,mod,5.0))

    def minusxy(x: Int) = {
      (y: Int) => x - y //匿名函数
    }
    val f1 = minusxy(3)
    println("f1的类型=" + f1)
    println(f1(1)) //  2
    println(f1(9)) //  -6

    //也可以一步到位的调用
    println(minusxy(4)(9)) // -5


  }
}
