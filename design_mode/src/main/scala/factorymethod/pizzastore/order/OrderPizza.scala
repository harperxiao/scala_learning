package factorymethod.pizzastore.order



import factorymethod.pizzastore.pizza.Pizza

import scala.io.StdIn
import scala.util.control.Breaks._

//这里我们将OrderPizza 做成抽象类
abstract class OrderPizza {


  breakable {
    var orderType: String = null
    var pizza: Pizza = null
    do {
      println("请输入pizza的类型 使用工方法模式~~")
      orderType = StdIn.readLine()
      pizza = createPizza(orderType)
      if (pizza == null) {
        break()
      }
      pizza.prepare()
      pizza.bake()
      pizza.cut()
      pizza.box()
    } while (true)
  }

  //抽象的方法，createPizza(orderType),让各个子类的实现Order
  def createPizza(t:String):Pizza
}
