package com.atguigu.chapter17.decorator.coffeebar.mydecorator

import com.atguigu.chapter17.decorator.coffeebar.Drink


class Soy(obj: Drink) extends Decorator(obj) {
  setDescription("Soy")
  setPrice(1.5f)
}
