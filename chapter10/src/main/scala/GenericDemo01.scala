
object GenericDemo01 {
  def main(args: Array[String]): Unit = {

    val intMessage = new IntMessage[Int](10)
    println(intMessage)
    val strMessage = new StringMessage[String]("hello")
    println(strMessage)



  }


}


abstract class Message[T](s:T) {
  def get = s
}

class IntMessage[Int](v:Int) extends Message(v)
class StringMessage[String](v:String) extends Message(v)



