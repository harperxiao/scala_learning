import scala.beans.BeanProperty

object BeanPropertyDemo1 {
  def main(args: Array[String]): Unit = {
//    val car = new Car
//    car.name = "宝宝"
//    println(car.getName)
//    car.setName("巴巴")
//    println(car.name)


//    val person = new Person("jack",20)
//    println(person)
//    val p2 = new Person("tom")
//    println(p2)


//    val aa = new AA("jack")
    val worker = new Worker("smith")
    worker.name //不能访问 inName

    val worker4 = worker

    worker.name = "tom"
    println(worker.name)
    println(worker4.name)
    val worker2 = new Worker2("smith2")
    worker2.inName  //可以访问 inName
    println("hello!")

    val worker3 = new Worker3("jack")
    worker3.inName = "mary"
    println(worker3.inName)

  }
}

class Car{
  @BeanProperty var name :String =null
}

class Person(inName:String,inAge:Int){
  var name = inName
  var age = inAge

  age+=10

  override def toString: String = {
    "name=" + this.name + "\t age" + this.age
  }

  def this(name:String){
    this("jack",10)
    this.name = name
  }
}


class BB(){
  println("b______")
}

class AA extends BB{
  println("aaa")

  def this(name:String){
    this
    println("A this(name:String)")
  }
}

//1. 如果 主构造器是Worker(inName: String) ，那么  inName就是一个局部变量

class Worker(inName: String) {
  var name = inName
}
//. 如果 主构造器是Worker2(val inName: String) ，那么  inName就是Worker2的一个private的只读属性
class Worker2(val inName: String) {
  var name = inName
}

// 如果 主构造器是Worker3(var inName: String) ，那么  inName就是Worker3的一个
// 一个private 的可以读写属性
class Worker3(var inName: String) {
  var name = inName
}