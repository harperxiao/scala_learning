package abstractfactory.pizzastore.order

import abstractfactory.pizzastore.pizza.{BJCheesePizza, BJPepperPizza, Pizza}


//这时一个实现了AbsFacotory的一个子工厂类
//如果我们希望订购北京的Pizza就使用该工厂子类
class BJFactory extends AbsFactory {
  override def createPizza(t: String): Pizza = {
    var pizza: Pizza = null
    if (t.equals("cheese")) {
      pizza = new BJCheesePizza
    } else if (t.equals("pepper")) {
      pizza = new BJPepperPizza
    }
    return pizza
  }
}
