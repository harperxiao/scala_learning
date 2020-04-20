import scala.collection.mutable.ListBuffer

object ListDemo1 {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 2, 3, "abc")
    val list5 = 4 :: 5 :: 6  :: list1 :: Nil
    println(list5)

    val list2 = list1 :+ 4
    println(list2)

    val list3 = 10 +: list1 // (10,1, 2, 3, "abc")
    println("list3=" + list3)

    val list6 = 4 :: 5 :: 6 :: list1 ::: Nil
    println("list6=" + list6)

    val lst0 = ListBuffer[Int](1, 2, 3)
    val lst1 = new ListBuffer[Int] //空的ListBuffer
    lst1 += 4 // lst1 (4)
    lst1.append(5) // list1(4,5)
    println("lst1=" + lst1)

    lst0 ++= lst1 // lst0 (1, 2, 3,4,5)
    println("lst0=" + lst0)



  }
}
