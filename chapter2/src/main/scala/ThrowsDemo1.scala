
object ThrowsDemo1 {

  def test():Nothing = {
    throw new Exception("异常")
  }

  @throws(classOf[NumberFormatException])
  def test2() = {
    "abc".toInt
  }

  def main(args: Array[String]): Unit = {
    try {
      test()
    }catch {
      case ex: Exception => {
        println("捕获到异常" + ex.getMessage)
        println("xxxx")
      }
      case ex:ArithmeticException => println("得到一个算术异常~~")
    }finally {
      //写上对try{} 中的资源的分配
    }


    test2()
    println("ok~~~~~")
  }



}
