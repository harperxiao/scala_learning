object StreamDemo01 {
  def main(args: Array[String]): Unit = {
    //创建Stream
    def numsForm(n: BigInt) : Stream[BigInt] = n #:: numsForm(n + 1)
    val stream1 = numsForm(5)
    println(stream1) // (1,?)
    //取出第一个元素
    println("head=" + stream1.head) // 1
    println(stream1.tail) // 2
    println(stream1) //? (1,2,...)

    //看一个应用案例
    def multi(x:BigInt) : BigInt = {
      x * x
    }
    println(numsForm(5).map(multi)) //(25, ?)

  }
}