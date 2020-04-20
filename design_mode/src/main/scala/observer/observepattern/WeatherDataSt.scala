package com.atguigu.chapter17.observer.observepattern

import scala.collection.mutable.ListBuffer

class WeatherDataSt extends Subject {

  private var mTemperature: Float = _
  private var mPressure: Float = _
  private var mHumidity: Float = _
  //集合，用于管理所有的观察者
  private val mObservers: ListBuffer[ObServer] = ListBuffer()

  def getTemperature() = {
    mTemperature
  }

  def getPressure() = {
    mPressure
  }

  def getHumidity() = {
    mHumidity
  }

  def dataChange() = {
    //一旦天气变化，就通知所有观察者
    notifyObservers()
  }

  //天气变化
  def setData(mTemperature: Float, mPressure: Float, mHumidity: Float) = {
    this.mTemperature = mTemperature
    this.mPressure = mPressure
    this.mHumidity = mHumidity
    dataChange()
  }

  //注册
  override def registerObserver(o: ObServer): Unit = {
    //加入到mObservers
    mObservers.append(o)
  }

  //移除,比如某个第三方不想接入
  override def removeObserver(o: ObServer): Unit = {
    if (mObservers.contains(o)) {
      mObservers -= o
    }
  }
  //通知，天气情况变化了，我们就通知所有的观察者
  override def notifyObservers(): Unit = {
    for(observer <- mObservers) {
      observer.update(mTemperature,mPressure,mHumidity)
    }
  }
}
