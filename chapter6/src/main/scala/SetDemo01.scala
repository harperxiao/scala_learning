import scala.collection.mutable

object SetDemo01 {
  def main(args: Array[String]): Unit = {

    val set = Set(1, 2) //不可变
    println(set)


    val set2 = mutable.Set(1,2,"hello") //可变
    set2.add(3)
    println("set2" + set2)

    println(set.max)
    println(set.min)


  }
}