object FlatMapDemo01 {
  def main(args: Array[String]): Unit = {
    val names = List("Alice", "Bob", "Nick")
    val names2: List[Char] = names.flatMap(upper)

    println(names2)
  }

  def upper(str: String):String={
    str.toUpperCase
  }
}
