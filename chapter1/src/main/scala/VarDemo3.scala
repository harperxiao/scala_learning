object VarDemo3 {
  def main(args: Array[String]): Unit = {
    var r3: Double = 10.0 / 3
    println(r3.formatted("%.2f"))

    // ++ 和 --
    // 说明,在scala中没有 ++ 和 --， 而使用 +=1  和  -= 1
    var num = 1
    num += 1
    num -= 1
    println(num)

    val days = 97
    printf("统计结果是 %d个星期零%d天", days / 7, days % 7)

  }

}
