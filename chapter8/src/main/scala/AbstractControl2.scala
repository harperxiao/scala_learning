object AbstractControl2 {

  def main(args: Array[String]): Unit = {
    var x = 10
    def myWhile(condition: => Boolean)(block: => Unit): Unit = {
      if (!condition){
        println(condition)
        block
//        println(block)
        myWhile(condition)(block)
      }
    }


    myWhile(x == 0){
      x -= 1
      println(x)
    }
  }




}
