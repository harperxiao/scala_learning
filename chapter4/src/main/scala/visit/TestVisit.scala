package visit

object TestVisit {
  def main(args: Array[String]): Unit = {
    val c = new Clerk()

    c.showInfo()
    Clerk.test(c)

    //创建一个Person对象
    val p1 = new Person
    println(p1.name)

}}
//类
class Clerk {
  var name: String = "jack" //
  private var sal: Double = 9999.9
  protected var age = 10
  var job : String = "大数据工程师"

  def showInfo(): Unit = {
    //在本类可以使用私有的
    println(" name " + name + " sal= " + sal)
  }
}

//当一个文件中出现了 class Clerk 和 object Clerk
//1. class Clerk 称为伴生类
//2. object Clerk 的伴生对象
//3. 因为scala设计者将static拿掉, 他就是设计了 伴生类和伴生对象的概念
//4. 伴生类 写非静态的内容 伴生对象 就是静态内容
//5.
object Clerk {
  def test(c: Clerk): Unit = {
    //这里体现出在伴生对象中，可以访问c.sal
    println("test() name=" + c.name + " sal= " + c.sal )
  }
}

class Person {
  //这里我们增加一个包访问权限
  //下面private[visit] ： 1，仍然是private 2. 在visit包(包括子包)下也可以使用name ,相当于扩大访问范围

  protected[visit] val name = "jack"
}
