object ParDemo01 {
  def main(args: Array[String]): Unit = {

    (1 to 5).foreach(println(_))
    println()
    //这里输出的结果是无序的，说明是将println任务分配给不同cpu
    (1 to 5).par.foreach(println(_))

    val result1 = (0 to 100).map{case _ => Thread.currentThread.getName}.distinct
    val result2 = (0 to 100).par.map{case _ => Thread.currentThread.getName}.distinct
    println(result1) //非并行
    println("--------------------------------------------")
    println(result2) //并行


  }
}