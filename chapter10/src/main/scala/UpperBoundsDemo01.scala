object UpperBoundsDemo01 {
  def main(args: Array[String]): Unit = {

    val compareInt = new CompareInt(10,40)
    println(compareInt.greater) // 40

    //第一个用法
    val commonCompare1 = new CommonCompare(Integer.valueOf(10), Integer.valueOf(40))//Int
    println(commonCompare1.greater)
    //第二个用法
    val commonCompare2 = new CommonCompare(java.lang.Float.valueOf(1.1f), java.lang.Float.valueOf(2.1f))//Fl
    println(commonCompare2.greater)

    //第3种写法使用了隐式转换
    //implicit def float2Float(x: Float): java.lang.Float         = x.asInstanceOf[java.lang.Float]
    val commonCompare3 = new CommonCompare[java.lang.Float](10.1f, 21.1f)//
    println(commonCompare3.greater)
  }

}

/*
编写一个通用的类，可以进行Int之间、Float之间、等实现了Comparable接口的值直接的比较.//java.lang.Integer
分别使用传统方法和上界的方式来完成，体会上界使用的好处.

 */
//传统方法
class CompareInt(n1: Int, n2: Int) {
  //返回较大的值
  def greater = if(n1 > n2) n1 else n2
}

//使用上界(上限)来完成
//说明
//1. [T <: Comparable[T]] 表示T类型是Comparable 子类型
//2. 即你传入的T类要继承Comparable接口
//3. 这样就可以使用compareTo方法
//4. 这样的写法(使用上界的写法)通用性比传统的好
class CommonCompare[T <: Comparable[T]](obj1:T,obj2:T) {
  def greater = if (obj1.compareTo(obj2) > 0) obj1 else obj2
}


