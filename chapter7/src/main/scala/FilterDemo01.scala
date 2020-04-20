object FilterDemo01 {
  def main(args: Array[String]): Unit = {
    val names = List("Alice", "Bob", "Nick")
    val name2 = names.filter(startA)
    println(name2)
  }
  def startA(str: String):Boolean={
    str.startsWith("A")
  }
}
