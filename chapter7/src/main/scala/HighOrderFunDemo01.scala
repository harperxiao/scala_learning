
object HighOrderFunDemo01 {
  def main(args: Array[String]): Unit = {
//    val res = test(sum2,3.5)
//    println(res)

    val res = test(sum2 _, 3.5)

    println("res=" + res)

    //在scala中，可以把一个函数直接赋给一个变量,但是不执行函数
    val f1 = myPrint _

    f1() //执行


    test2(sayOK)
  }

  def myPrint(): Unit = {
    println("hello,world!")
  }

  //说明
  //1. test就是一个高阶函数
  //2. f: Double => Double 表示一个函数， 该函数可以接受一个Double,返回Double
  //3. n1: Double 普通参数
  //4. f(n1) 在test函数中，执行 你传入的函数
  def test(f: Double => Double, n1: Double) = {
    f(n1)
  }

  //普通的函数, 可以接受一个Double,返回Double
  def sum2(d: Double): Double = {
    println("sum2被调用")
    d + d
  }

  def test2(f: () => Unit) = {
    f()
  }

  def sayOK() = {
    println("sayOKKK...")
  }

  def sub(n1:Int): Unit = {

  }
}
