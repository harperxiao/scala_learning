package com.atguigu.chapter17.decorator.coffeebar.mycoffee

//这个是单品咖啡，在装饰者设计模式中ConcreteComponent
class Espresso extends Coffee {
  //使用主构造器
  super.setDescription("Espresso")

  super.setPrice(6.0f)
}
