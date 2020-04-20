package com.atguigu.chapter17.observer.observepattern

trait ObServer {
  //抽象方法，等待其它的观察者实现
  def update(mTemperatrue: Float, mPressure: Float, mHumidity: Float)

}
