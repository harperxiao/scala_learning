object ReduceDemo01 {
  def main(args: Array[String]): Unit = {
    /*
    使用化简的方式来计算list集合的和
     */
    val list = List(1, 20, 30, 4, 5)
    val res = list.reduceLeft(sum) //接收一个函数时，也可以直接传入一个匿名函数

    //执行的流程分析
    //步骤 1 (1 + 20)
    //步骤 2 (1 + 20) + 30
    //步骤 3 ((1 + 20) + 30) + 4
    //步骤 4 (((1 + 20) + 30) + 4) + 5 = 60

    println("res="+res) // 60

    println(list.reduce(min))
  }

  def min(n1: Int, n2: Int): Int = {
    if (n1 > n2) n2 else n1
  }
  def sum(n1: Int, n2: Int): Int = {
    println("sum被调用~~")
    n1 + n2
  }
}