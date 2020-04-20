object LazyDemo1 {

  def main(args: Array[String]): Unit = {
    lazy val res = sum(10,20)
    print("-------")
    println(res)
  }

  def sum(n1: Int, n2: Int): Int = {
    println("sum() 执行了..") //输出一句话
    return n1 + n2
  }
}
