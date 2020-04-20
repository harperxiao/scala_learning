package com.atguigu.chapter17.proxy.localcandymachine

class OnReadyState extends State {
  //说明:@transient注解将字段标记为瞬态的,即表示一个域不是该对象串行化的一部分
  @transient private   var  mCandyMachine:CandyMachine= _
  def this(mCandyMachine:CandyMachine) {
    this
    this.mCandyMachine=mCandyMachine
  }

  override def getstatename(): String = {
    "OnReadyState"
  }

  override def insertCoin(): Unit = {
    println("you have inserted a coin,next,please turn crank!")
    //同时给糖果机设置，有硬币的状态
    this.mCandyMachine.setState(mCandyMachine.mHasCoin)
  }

  override def printstate(): Unit = {
    println("***OnReadyState***")
  }

  override def returnCoin(): Unit = {
    println("you haven't inserted a coin yet!")
  }

  override def turnCrank(): Unit = {
    println("you turned,but you haven't inserted a coin!")
  }

  //在此状态下dispense没有业务逻辑
  override def dispense(): Unit = {

  }
}
