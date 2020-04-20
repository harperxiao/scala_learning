object AccompanyObject {
  def main(args: Array[String]): Unit = {

    println(ScalaPerson.sex) //true 在底层等价于 ScalaPerson$.MODULE$.sex()
    ScalaPerson.sayHi()//在底层等价于 ScalaPerson$.MODULE$.sayHi()
  }
}

//说明
//1. 当在同一个文件中，有 class ScalaPerson 和 object ScalaPerson
//2. class ScalaPerson 称为伴生类,将非静态的内容写到该类中
//3. object ScalaPerson 称为伴生对象,将静态的内容写入到该对象(类)
//4. class ScalaPerson 编译后底层生成 ScalaPerson类 ScalaPerson.class
//5. object ScalaPerson 编译后底层生成 ScalaPerson$类 ScalaPerson$.class
//6. 对于伴生对象的内容，我们可以直接通过 ScalaPerson.属性 或者方法

//伴生类
class ScalaPerson { //
  var name : String = _
}

//伴生对象
object ScalaPerson { //
  var sex : Boolean = true
  def sayHi(): Unit = {
    println("object ScalaPerson sayHI~~")
  }
}