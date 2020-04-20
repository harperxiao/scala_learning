object PartialFun {
  def main(args: Array[String]): Unit = {

    val list = List(1, 2, 3, 4, "hello")
    //定义一个偏函数
    //1. PartialFunction[Any,Int] 表示偏函数接收的参数类型是Any,返回类型是Int
    //2. isDefinedAt(x: Any) 如果返回true ,就会去调用 apply 构建对象实例,如果是false,过滤
    //3. apply 构造器 ,对传入的值 + 1,并返回（新的集合）

    val partfun = new PartialFunction[Any,Int] {
      override def isDefinedAt(x: Any): Boolean = {
        x.isInstanceOf[Int]
      }

      override def apply(v1: Any): Int = {
        v1.asInstanceOf[Int]+1
      }
    }

    val list2 = list.collect(partfun)
    println(list2)

    val list3 = list.collect{
      case i:Int => i + 1
      case j:Double => (j * 2).toInt
      case k:Float => (k * 3).toInt
    }
    println("list3=" + list3) // (2,3,4,5)



  }
}
