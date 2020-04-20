package com.atguigu.chapter17.decorator.coffeebar

import com.atguigu.chapter17.decorator.coffeebar.mycoffee.{DeCaf, LongBlack}
import com.atguigu.chapter17.decorator.coffeebar.mydecorator.{Chocolate, Milk, NewMilk}


object CoffeeBar {
  def main(args: Array[String]): Unit = {
    println("咖啡bar..")

    val order: Drink = new DeCaf //点DeCaf单品咖啡
    println("order1 price:" + order.cost()) //3.0
    println("order1 desc:" + order.getDescription())

    println("------------------------------------------")
//  点一份LongBlack,并加入1份Milk 和 2份Chocolate
    var order2: Drink = new LongBlack //5.0
    order2 = new Milk(order2) //2.0
    order2 = new Chocolate(order2)//3.0
    order2 = new Chocolate(order2)//3.0
    order2 = new NewMilk(order2)
//
    println("order2 price:"+order2.cost()); //
    println("order2 desc:"+order2.getDescription())
//
    //java.io.FilterInputStream
  }
}
