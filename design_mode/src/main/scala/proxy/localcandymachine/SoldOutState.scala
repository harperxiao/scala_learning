package com.atguigu.chapter17.proxy.localcandymachine

//销售完的状态
class SoldOutState extends State {
  //说明:@transient注解将字段标记为瞬态的,即表示一个域不是该对象串行化的一部分
  @transient private   var  mCandyMachine:CandyMachine= _
  def this(mCandyMachine:CandyMachine) {
    this
    this.mCandyMachine=mCandyMachine
  }

  override def getstatename(): String = {
    "SoldOutState"
  }

  override def insertCoin(): Unit = {
    println("you can't insert coin,the machine sold out!")
  }

  override def printstate(): Unit = {
    println("***SoldOutState***")
  }

  override def returnCoin(): Unit = {
    println("you can't return,you haven't inserted a coin yet!")
  }

  override def turnCrank(): Unit = {
    println("you turned,but there are no candies!")
  }
  //没有业务逻辑
  override def dispense(): Unit = {

  }
}
