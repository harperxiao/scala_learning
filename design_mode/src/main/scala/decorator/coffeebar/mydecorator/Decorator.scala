package com.atguigu.chapter17.decorator.coffeebar.mydecorator

import com.atguigu.chapter17.decorator.coffeebar.Drink

//这个就是Decorator装饰者
class Decorator extends Drink {

  //obj就是被装饰的对象Drink
  //obj可以是单品咖啡，也可以是单品咖啡+调料的组合
  private var obj: Drink = null

  def this(obj: Drink) {
    this
    this.obj = obj
  }
  //这里我们实现了cost,这里使用了递归方式
  override def cost(): Float = {

    super.getPrice() + obj.cost()
  }
  //获取信息时，也需要递归获取
  override def getDescription(): String = {

    super.getDescription() + "&&" + obj.getDescription()
  }
}
