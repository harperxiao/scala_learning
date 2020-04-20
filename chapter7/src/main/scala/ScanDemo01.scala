object ScanDemo01 {
  def main(args: Array[String]): Unit = {
    //普通函数
    def minus( num1 : Int, num2 : Int ) : Int = {
      num1 - num2
    }

    //5 (1,2,3,4,5) =>(5, 4, 2, -1, -5, -10) //Vector(5, 4, 2, -1, -5, -10)
    val i8 = (1 to 5).scanLeft(5)(minus) //IndexedSeq[Int]
    println("i8=" + i8)

    //普通函数
    def add( num1 : Int, num2 : Int ) : Int = {
      num1 + num2
    }
    //(1,2,3,4,5) 5 => (20,19,17,14, 10,5)
    val i9 = (1 to 5).scanRight(5)(add) //IndexedSeq[Int]
    println("i9=" + i9)

  }
}
