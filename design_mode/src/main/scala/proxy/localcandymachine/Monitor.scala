package com.atguigu.chapter17.proxy.localcandymachine

import scala.collection.mutable.ListBuffer

//这个是监控糖果的类
class Monitor {

  //监控多台糖果机
  private val candyMachinelst: ListBuffer[CandyMachine] = ListBuffer()

  //给监控器增加一个糖果机
  def addMachine(mCandyMachine:CandyMachine) = {
    candyMachinelst.append(mCandyMachine)
  }

  //输出该监控器，管理的各个糖果机的信息
  def  report() = {
    //var mCandyMachine:CandyMachine = null
    for (mCandyMachine <- this.candyMachinelst) {
      println("----------------------------------------")
      println("Machine Loc:" + mCandyMachine.getLocation())
      println("Machine Candy count:" + mCandyMachine.getCount())
      println("Machine State:" + mCandyMachine.getstate().getstatename())
    }
  }

}
