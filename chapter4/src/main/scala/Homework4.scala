
object Homework4 {
  def main(args: Array[String]): Unit = {
    println(Suits)

    println(Suits.isRed(Suits.Heart))
  }
}


object Suits extends Enumeration{
  type Suits = Value
  val Spade = Value("♠") //创建了一个Value 对象
  val Club = Value("♣") //...
  val Heart = Value("♥") //..
  val Diamond = Value("♦")

  //..
  override def toString(): String = { //重写toString方法
    Suits.values.mkString(",") // ♣,♦,♥,♠
  }

  def isRed(card:Suits)={
    card==Heart|| card==Diamond
  }
}
