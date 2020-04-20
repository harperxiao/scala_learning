import com.sun.prism.shader.DrawPgram_LinearGradient_REPEAT_AlphaTest_Loader

object VarDemo {
  def main(args: Array[String]): Unit = {
    var age: Int = 10
    var sal: Double = 10.9
    var name: String = "tom"
    var isPass: Boolean = true
    var score: Float = 70.9f
    println(s"${age+1} ${isPass}")
    println("名字是%s",name)
    println(age.isInstanceOf[Int])

    val num2 = 30
    val dog=new Dog
    dog.age=10
    dog.name="小花"
    print(dog)

    var arr = new Array[Int](10)

    for (elem <- arr) {
      print(elem)
    }
  }

}

class Dog{
  var age: Int=0
  var name:String=""

  override def toString: String ={
    this.age+""+this.name
  }
}
