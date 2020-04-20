import scala.collection.mutable.ArrayBuffer

object MatchDemo01 {
  def main(args: Array[String]): Unit = {
    val arrs2 = Array(Array(0), Array(1, 0), Array(0, 1, 0),
      Array(1, 1, 0), Array(1, 1, 0, 1))

    for (arr <- arrs2) {
      val result = arr match {
        //case Array(0) => "0"
        case Array(x, y) => ArrayBuffer(y, x) //Array(y,x).toBuffer //? ArrayB(y,x)
        //case Array(0, _*) => "以0开头和数组"
        case _ => "不处理~~"
      }

      println("res=" + result) //ArrayBuffer(0,1)
    }


    for (ch <- "3") {
      var sign = 0
      var digit = 0
      ch match {
        case _ if ch.toString.equals("3") => digit = 3
        case _ if (ch < 120) => println("ch > 10")
        case '+' => sign = 1
        case '-' => sign = -1
        // 说明..
        case _ => println("没有任何匹配~~~")
      }
      println(ch + " " + sign + " " + digit)
    }

    for (list <- Array(List(0), List(1, 0), List(88), List(0, 0, 0), List(1, 0, 0))) {
      val result = list match {
        case 0 :: Nil => "0" //
        case x :: y :: Nil => x + " " + y //
        case 0 :: tail => "0 ..." //
        case x :: Nil => x
        case _ => "something else"
      }
      //1. 0
      //2. 1 0
      //3. 0 ...
      //4. something else
      println(result)
    }
  }
}
