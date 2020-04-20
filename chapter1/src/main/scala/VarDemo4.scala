object VarDemo4 {
  def main(args: Array[String]): Unit = {
    var num = 2
    num <<= 2 // num = 8

    println("num=" + num)

    num >>= 3 // num = 4

    println("num=" + num)


    val res ={
      if (num>1) "hello" else  100
    }
    println(res)
  }
}
