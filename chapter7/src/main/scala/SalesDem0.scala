
object SalesDem0 {
  def main(args: Array[String]): Unit = {
    val sale = Bundle("书籍", 10,  Book("漫画", 40), Bundle("文学作品", 20, Book("《阳关》", 80), Book("《围城》", 30),Book("天龙八部", 100)))

    val res = sale match {
      case Bundle(_,_,Book(description,_),_*) => description
    }

    println(res)


    //通过@表示法将嵌套的值绑定到变量。_*绑定剩余Item到rest
    val res2 = sale match {
      case Bundle(_,_,art @ Book(_,_), rest @ _*) =>(art,rest)
    }

    println(res2)

    val res3 = sale match  {
      //如果我们进行对象匹配时，不想接受某些值，则使用_ 忽略即可，_* 表示所有
      case Bundle(_, _, art3 @ Book(_, _), rest3) => (art3, rest3)
    }
    println("res3=" + res3)

    println("price=" + price(sale)) // 120

  }

  def price(it:Item):Double={
    it match {
      case Book(_,p) => p
      case Bundle(_,disc,its @ _*) => its.map(price).sum - disc
    }
  }
}



//设计样例类
//sealed不能在类定义的文件之外定义任何新的子类
abstract sealed class Item // 项

case class Book(description: String, price: Double) extends Item
case class Food(description: String, price: Double) extends Item
//Bundle 捆 ， discount: Double 折扣 ， item: Item* ,
case class Bundle(description: String, discount: Double, item: Item*) extends Item

