object ImplicitClassDemo {
  def main(args: Array[String]): Unit = {

    //DB1会对应生成隐式类
    //DB1是一个隐式类, 当我们在该隐式类的作用域范围，创建MySQL1实例
    //该隐式类就会生效, 这个工作仍然编译器完成
    //看底层..
    implicit class DB1(val m:MySQL1){
      def addSuffix():String = {
          m + "scala"
      }
    }

    val mySQL = new MySQL1
    mySQL.sayOk()
    mySQL.addSuffix()//研究 如何关联到 DB1$1(mySQL).addSuffix();

    implicit def f1(d:Double):Int={
      d.toInt
    }

    def test1(n1:Int): Unit = {
      println("ok")
    }
    test1(10.1)

    val num: Int = 3.5 // 底层编译 f1$1(3.5)
    println(num)



  }
}




class DB1 {}


class MySQL1 {
  def sayOk(): Unit = {
    println("sayOk")
  }
}
