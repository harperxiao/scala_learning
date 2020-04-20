object ViewBoundsDemo02 {
  def main(args: Array[String]): Unit = {
    val p1 = new Person("tom", 10)
    val p2 = new Person("jack", 20)
    val compareComm2 = new CompareComm2(p1, p2)
    println(compareComm2.getter.name)// jack

    val cat1 = new Cat("smith")
    val cat2 = new Cat("tom")

    println(new CompareComm2(cat1,cat2).getter.name) // smith
  }
}



class Person(val name: String, val age: Int) extends Ordered[Person] {
  //重写了Ordered 的方法compare
  //override def compare(that: Person): Int = this.age - that.age
  override def compare(that: Person): Int = {
    this.age - that.age
  }
  //这里是重写toString,为了显示方便
  override def toString: String = this.name + "\t" + this.age
}
//比较Cat的名字的长度大小
class Cat(val name:String) extends Ordered[Cat] {
  override def compare(that: Cat): Int = {
    this.name.length - that.name.length
  }
}

//说明
//1.  T <% Ordered[T] 表示T是Ordered子类型 java.lang.Comparable
//2.  这里调用的compareTo方法是 T这个类型的方法
class CompareComm2[T <% Ordered[T]](obj1: T, obj2: T) {
  def getter = if (obj1 > obj2) obj1 else obj2

  def geatter2 = if (obj1.compareTo(obj2) > 0) obj1 else obj2
}
