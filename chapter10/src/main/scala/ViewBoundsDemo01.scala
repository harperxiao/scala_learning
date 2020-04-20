object ViewBoundsDemo01 {
  def main(args: Array[String]): Unit = {
    //使用了隐式转换
    val compareComm01 = new CompareComm(1, 20)
    println(compareComm01.greater)

    val compareComm2 = new CompareComm(Integer.valueOf(20), Integer.valueOf(30))
    println(compareComm2.greater)

    //以前 <: 上界
    val compareComm4 = new CompareComm[java.lang.Float](201.9f, 30.1f)
    println(compareComm4.greater)
    //上面的小数比较，在视图界定的情况下，就可以这样写了
    //这里会进行隐式转换
    val compareComm5 =
      new CompareComm(201.9f, 310.1f)
    println(compareComm5.greater)

  }
}

//说明
//1. T <% Comparable[T] 说明 T是 Comparable子类型
//2.  T <% Comparable[T] 和  T <: Comparable[T] 区别就是视图界定支持隐式转换
//3. 视图界定不但支持以前上界的写法，同时支持简洁的写法val compareComm01 = new CompareComm(1, 20)

class CompareComm[T <% Comparable[T]](obj1: T, obj2: T) {
  def greater = if (obj1.compareTo(obj2) > 0) obj1 else obj2
}
