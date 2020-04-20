object ProtectedDemo {
  def main(args: Array[String]): Unit = {
    val sub = new Sub
    sub.sayOk
//    sub.test100()
    //sub.test200() //编译器不让过.

  }

}

//父类(基类)
class Base {
  var n1: Int = 1 //public n1() , public n1_$eq()
  protected var n2: Int = 2
  private var n3: Int = 3 // private n3() , private n3_$eq()

  def test100(): Unit = { // 默认 public test100()
    println("base 100")
  }

  protected def test200(): Unit = { // public
    println("base 200")
  }

  private def test300(): Unit = { //private
    println("base 300")
  }
}

class Sub extends Base{
  def sayOk: Unit ={
    this.n1 = 20
    this.n2 = 30
    println("范围"+this.n1+this.n2)

    test100()
    test200()

  }
}
