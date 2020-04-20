package com.atguigu.chapter17.decorator.coffeebar

//说明
//1. Drink 是表示饮品，是一个抽象类
abstract class Drink {
  var description = ""
  private var price = 0.0f

  def setDescription(description: String): Unit = {
    this.description = description
  }

  def getDescription(): String = {
    description + " 价格: " + this.getPrice()
  }

  def getPrice(): Float = {
    price
  }

  def setPrice(price: Float): Unit = {
    this.price = price
  }
  //将计算成本的方法做成一个抽象方法cost
  def cost(): Float
}
