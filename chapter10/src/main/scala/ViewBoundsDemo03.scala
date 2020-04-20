
object ViewBoundsDemo03 {
  def main(args: Array[String]): Unit = {
    val p1 = new Person3("汤姆", 13)
    val p2 = new Person3("杰克", 10)
    //引入隐式函数
    import MyImplicit._
    val compareComm3 = new CompareComm3(p1,p2)
    println(compareComm3.getter)

  }
}


class Person3(val name: String, val age: Int)  {
  //这里是重写toString,为了显示方便
  override def toString: String = this.name + "\t" + this.age
}


//说明
//1.  T <% Ordered[T] 表示T是Ordered子类型 java.lang.Comparable
//2.  这里调用的compareTo方法是 T这个类型的方法
class CompareComm3[T <% Ordered[T]](obj1: T, obj2: T) {
  def getter = if (obj1 > obj2) obj1 else obj2

  def geatter2 = if (obj1.compareTo(obj2) > 0) obj1 else obj2
}
