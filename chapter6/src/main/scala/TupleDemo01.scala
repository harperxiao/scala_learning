object TupleDemo01 {
  def main(args: Array[String]): Unit = {
    //创建
    //说明 1. tuple1 就是一个Tuple 类型是Tuple5
    //简单说明: 为了高效的操作元组 ， 编译器根据元素的个数不同，对应不同的元组类型
    // 分别 Tuple1----Tuple22

    val tuple1 = (1, 2, 3, "hello", 4)
    println(tuple1)

    println("==================访问元组=========================")
    //访问元组
    val t1 = (1, "a", "b", true, 2)
    println(t1._1) // 1 //访问元组的第一个元素 ，从1开始

    /*
     override def productElement(n: Int) = n match {
    case 0 => _1
    case 1 => _2
    case 2 => _3
    case 3 => _4
    case 4 => _5
    case _ => throw new IndexOutOfBoundsException(n.toString())
 }
     */
    println(t1.productElement(0)) // 0 // 访问元组的第一个元素，从0开始


    println("==================遍历元组=========================")
    //遍历元组, 元组的遍历需要使用到迭代器
    for (item <- t1.productIterator) {
      println("item=" + item)
    }


  }
}
