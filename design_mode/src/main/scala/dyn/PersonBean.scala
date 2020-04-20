package com.atguigu.chapter17.dyn

//这个就是我们的Subject(是一个trait/Java中interface)
trait PersonBean {

  def getName(): String

  def getGender(): String

  def getInterests(): String

  def getScore(): Int

  def setName(name: String)

  def setGender(gender: String)

  def setInterests(interests: String)

  def setScore(score:Int)
}
