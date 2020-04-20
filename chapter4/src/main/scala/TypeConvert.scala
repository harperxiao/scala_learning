
object TypeConvert {

  def main(args: Array[String]): Unit = {
    //isInstanceOf asInstanceOf
    var p1 = new Person200
    println(p1.name)
    var emp = new Emp200
    println(emp.name)

    //将子类引用给父类(向上转型,自动)
    p1 = emp
    println(p1.name)
    p1.printName()
    println("----------------")

    //将父类的引用重新转成子类引用(多态),即向下转型
    var  emp2 = p1.asInstanceOf[Emp200]
    emp2.printName()
  }
}
//Person类
class Person200 {
  val name: String = "tom"

  def printName() { //输出名字
    println("Person printName() " + name)
  }

  def sayHi(): Unit = {
    println("sayHi...")
  }
}

//这里我们继承Person
class Emp200 extends Person200 {
  override val name:String = "jack"
  //这里需要显式的使用override
  override def printName() {
    println("Emp printName() " + name)

  }

  def sayHello(): Unit = {

  }
}