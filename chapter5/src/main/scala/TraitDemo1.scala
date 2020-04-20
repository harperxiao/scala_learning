object TraitDemo1 {
  def main(args: Array[String]): Unit = {

  }
}

trait LoggerException extends Exception{
  def log(): Unit ={
    println(getMessage)
  }
}

class Unhappy extends LoggerException{
  override def getMessage: String = "错误消息"
}

// 如果混入该特质的类，已经继承了另一个类(A类)，则要求A类是特质超类的子类，
// 否则就会出现了多继承现象，发生错误。
class Unhappy2 extends IndexOutOfBoundsException with LoggerException{

}
class CCC {}

////错误的原因是 CCC 不是 Exception子类
//class UnhappyException3 extends CCC with LoggedException{
//  // 已经是Exception的子类了，所以可以重写方法
//  override def getMessage = "错误消息！"
//}

