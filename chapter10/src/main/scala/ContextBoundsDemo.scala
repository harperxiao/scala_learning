object ContextBoundsDemo {
  //这里我定义一个隐式值  Ordering[Person]类型
  implicit val personComparetor = new Ordering[Person4] {
    override def compare(p1: Person4, p2: Person4): Int =
      p1.age - p2.age
  }

  def main(args: Array[String]): Unit = {
    //
    val p1 = new Person4("mary", 30)
    val p2 = new Person4("smith", 35)
    val compareComm4 = new CompareComm4(p1, p2)
    println(compareComm4.geatter) // "smith", 35

    val compareComm5 = new CompareComm5(p1, p2)
    println(compareComm5.geatter) // "smith", 35

    println("personComparetor hashcode=" + personComparetor.hashCode())
    val compareComm6 = new CompareComm6(p1, p2)
    println(compareComm6.geatter) // "smith", 35

  }
}


//一个普通的Person类
class Person4(val name: String, val age: Int) {

  //重写toStirng
  override def toString = this.name + "\t" + this.age
}

//方式1
//说明：
//1. [T: Ordering] 泛型
//2. obj1: T, obj2: T 接受T类型的对象
//3. implicit comparetor: Ordering[T] 是一个隐式参数
class CompareComm4[T: Ordering](obj1: T, obj2: T)(implicit comparetor: Ordering[T]) {
  def geatter = if (comparetor.compare(obj1, obj2) > 0) obj1 else obj2
}

//方式2
//方式2,将隐式参数放到方法内
class CompareComm5[T: Ordering](o1: T, o2: T) {
  def geatter = {
    def f1(implicit cmptor: Ordering[T]) = cmptor.compare(o1, o2) //返回一个数字
    //如果f1返回的值>0,就返回o1,否则返回o2
    if (f1 > 0) o1 else o2
  }
  def lowwer = {
    def f1(implicit cmptor: Ordering[T]) = cmptor.compare(o1, o2) //返回一个数字
    //如果f1返回的值>0,就返回o1,否则返回o2
    if (f1 > 0) o2 else o1
  }
}

//方式3
//方式3,使用implicitly语法糖，最简单(推荐使用)
class CompareComm6[T: Ordering](o1: T, o2: T) {
  def geatter = {
    //这句话就是会发生隐式转换，获取到隐式值 personComparetor
    //底层仍然使用编译器来完成绑定(赋值的)工作
    val comparetor = implicitly[Ordering[T]]
    println("comparetor hashcode=" + comparetor.hashCode())
    if (comparetor.compare(o1, o2) > 0) o1 else o2
  }
}