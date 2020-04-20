import scala.collection.mutable.ArrayBuffer

object FoldDemo01 {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)
    def minus( num1 : Int, num2 : Int ): Int = {
      num1 - num2
    }

    //步骤  (5-1)
    //步骤  ((5-1) - 2)
    //步骤  (((5-1) - 2) - 3)
    //步骤  ((((5-1) - 2) - 3)) - 4 = - 5

    println(list.foldLeft(5)(minus))

    ////理解 list.foldRight(5)(minus) 理解成 list(1, 2, 3, 4, 5) list.reduceRight(minus)
    // 步骤 (4 - 5)
    // 步骤 (3- (4 - 5))
    // 步骤 (2 -(3- (4 - 5)))
    // 步骤 1- (2 -(3- (4 - 5))) = 3
    println(list.foldRight(5)(minus)) //

    val list4 = List(1, 9)

    var i6 = (1 /: list4) (minus) // =等价=> list4.foldLeft(1)(minus)
    println("i6=" + i6)


    i6 = (list4 :\ 10) (minus) // list4.foldRight(10)(minus)
    println(i6) // 输出? 2

    val sentence = "AAAAAAAAAABBBBBBBBCCCCCDDDDDDD"
    val arrayBuffer = new ArrayBuffer[Char]()
    //理解折叠的第一个传入的arrayBuffer 含义.
    sentence.foldLeft(arrayBuffer)(putArray)
    println("arrayBuffer=" + arrayBuffer)


  }
  def putArray(arr:ArrayBuffer[Char],c:Char): ArrayBuffer[Char] = {
    //将c 放入到arr 中
    arr.append(c)
    println(arr)
    arr
  }
}
