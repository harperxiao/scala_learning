package com.atguigu.chapter17.simplefactory.pizzastore.order

import com.atguigu.chapter17.simplefactory.pizzastore.pizza.{CheesePizza, GreekPizza, PepperPizza, Pizza}

object SimpleFactory {

  //提供了一个创建Pizza的方法,有需要创建Pizza调用该方法即可
  def createPizza(t: String): Pizza = {
    var pizza: Pizza = null
    if (t.equals("greek")) {
      pizza = new GreekPizza
    } else if (t.equals("pepper")) {
      pizza = new PepperPizza
    } else if (t.equals("cheese")) {
      pizza = new CheesePizza
    }
    return pizza
  }

}
