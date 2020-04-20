package abstractfactory.pizzastore.order



import abstractfactory.pizzastore.pizza.Pizza

import scala.io.StdIn
import scala.util.control.Breaks._

//OrderPizza ,当我们使用抽象工厂模式后，我们订购一个Pizza思路
//1.接收一个子工厂实例，根据该工厂的创建要求去实例
class OrderPizza {

  var absFactory: AbsFactory = _

  def this(absFactory: AbsFactory) {
    //多态
    this
    breakable {
      var orderType: String = null
      var pizza: Pizza = null
      do {
        println("请输入pizza的类型 ,使用抽象工厂模式...")
        orderType = StdIn.readLine()
        //使用简单工厂模式来创建对象.
        pizza = absFactory.createPizza(orderType)
        if (pizza == null) {
          break()
        }
        pizza.prepare()
        pizza.bake()
        pizza.cut()
        pizza.box()
      } while (true)
    }
  }

}
