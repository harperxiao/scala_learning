package abstractfactory.pizzastore.order

import abstractfactory.pizzastore.pizza.Pizza


trait AbsFactory {

  //一个抽象方法
  def  createPizza(t : String ): Pizza

}
