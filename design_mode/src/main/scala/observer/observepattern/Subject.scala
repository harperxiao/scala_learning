package com.atguigu.chapter17.observer.observepattern

//这个是Subject 是一个trait(接口)
trait Subject {

  //注册
  def registerObserver(o: ObServer)
  //remove
  def removeObserver(o: ObServer)
  //通知
  def notifyObservers()

}
