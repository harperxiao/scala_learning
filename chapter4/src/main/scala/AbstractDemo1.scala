object AbstractDemo1 {
  def main(args: Array[String]): Unit = {
    val animal = new Animal
    animal.sayHello()
    println(animal.food)

    val animal1:AnimalDemo1_1 = new Animal
    animal1.sayHello()
    println(animal.food)
  }

}

abstract class AnimalDemo1{
  def sayHi(): Unit ={
    println("AnimalDemo1")
  }
}

abstract class AnimalDemo1_1 {
  def sayHello()

  var food: String
}

class Animal extends AnimalDemo1_1{
  override def sayHello(): Unit = println("我是动物")

  override var food: String = "啥都吃"
}