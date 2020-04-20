

object StdInDemo1 {
  def main(args: Array[String]): Unit = {
//    println("请输入姓名")
//
//    val name = StdIn.readLine();
//
//    println("请输入年龄")
//    val age = StdIn.readInt()
//    println("请输入薪水")
//    val sal = StdIn.readDouble()
//    printf("用户的信息为 name=%s age=%d sal=%.2f", name, age, sal)

    AA.sayHi
    AA.sayHello
  }
}


trait A{
  def sayHello(): Unit ={
    println("A say HEllo")
  }
}

object AA extends A{
  def sayHi: Unit ={
    println("小狗")
  }
}