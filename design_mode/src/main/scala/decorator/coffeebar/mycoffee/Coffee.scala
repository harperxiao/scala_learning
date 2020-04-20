package com.atguigu.chapter17.decorator.coffeebar.mycoffee

import com.atguigu.chapter17.decorator.coffeebar.Drink


//在Drink 和  单品咖啡，我做了一个缓冲层
//这里是为了扩展，针对当前项目可以不要
class Coffee extends Drink{
  override def cost(): Float = {
    super.getPrice()
  }
}
