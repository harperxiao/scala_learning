object HomeWork3 {
  def main(args: Array[String]): Unit = {
    val point = Point(3,4)
    println(point.x1)
  }
}

class Point(x:Int,y:Int){
  var x1 = x
  var y1 =y

}

object Point{
  def apply(x: Int, y: Int): Point = new Point(x, y)
}