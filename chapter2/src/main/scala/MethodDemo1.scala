object MethodDemo1 {

  def main(args: Array[String]): Unit = {
    val i: Int = sum(1,2,3,4)

    println(i)
  }

  def sum(n1:Int,args:Int*):Int={
    println(args.length)
    var sum = n1
    for (elem <- args) {
      sum+=elem
    }
    sum
  }
}
