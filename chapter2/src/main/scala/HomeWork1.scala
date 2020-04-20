import scala.util.control.Breaks._

object HomeWork1 {

  def main(args: Array[String]): Unit = {
    var sum =0
    //breakable()函数
    //说明
    //1. breakable 是一个高阶函数：可以接收函数的函数就是高阶函数（后面详解）

    //2. def breakable(op: => Unit) {
    //    try {
    //      op
    //    } catch {
    //      case ex: BreakControl =>
    //        if (ex ne breakException) throw ex
    //    }
    //  }
    // (1) op: => Unit 表示接收的参数是一个没有输入，也没有返回值的函数
    // (2) 即可以简单理解可以接收一段代码块
    // 3. breakable 对break()抛出的异常做了处理,代码就继续执行
    // 4. 当我们传入的是代码块，scala程序员会将() 改成{}

    breakable{
      for(i<- 1 to 100){
        sum += i
        if (sum>20){
          println("中断")
          //2. def break(): Nothing = { throw breakException }
          break()
        }
      }
    }

    println("-------------")
    var loop = true
    var sum2 =0

    for(i<- 1 to 100 if loop == true){
      sum2 += i
      if (sum2>20){
        println("中断")
        loop = false
      }
    }

    for (i <- 1 to 10 if (i != 2 && i != 3)) {
      println("i=" + i)
    }

    val start = 1
    val end = 11
    //循环的范围是  start --- (end-1)
    for (i <- start until end) {
      println("hello, 尚硅谷" + i)
    }

    for(i <- 1 to 3; j = 4 - i) {
      print(j + " ")  // 3,2,1
    }

    for(i <- 1 to 3; j <- 1 to 3) {
      println(" i =" + i + " j = " + j) //输出即句 9
    }

    //Range(1,10,2)的对应的构建方法是
    //def apply(start: Int, end: Int, step: Int): Range = new Range(start, end, step)
    for (i <- Range(1, 11, 2)) {
      println("i=" + i)
    }

    for (i <- 1 to 3; j = i * 2) {
      println(" i= " + i + " j= " + j)
    }

    //说明 val res = for(i <- 1 to 10) yield i 含义
    //1. 对1 to 10 进行遍历
    //2. yield i 将每次循环得到i 放入到集合Vector中，并返回给res
    //3. i 这里是一个代码块，这就意味我们可以对i进行处理
    //4. 下面的这个方式，就体现出scala一个重要的语法特点，就是将一个集合中个各个数据
    //    进行处理，并返回给新的集合

    val res = for(i <- 1 to 10) yield {
      if (i % 2 == 0) {
        i
      }
    }
    println(res)


  }
}
