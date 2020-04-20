object VarDemo1 {
  def main(args: Array[String]): Unit = {
    var char: Char = 'a'
    var num = char + 1

    var char1: Cat = null

    println(char1)

    println(num)

    println(num.toDouble)
    println(num.toString)
    println(num.toDouble)

    var isPass = true
    println(isPass.toString)

    //    println(sayHello)


    sayHi()
    sayHi
  }

  def sayHi() = println("sayhello")

  def sayHello: Nothing = {
    throw new Exception("跑出异常")
  }

}

class Cat {

}
