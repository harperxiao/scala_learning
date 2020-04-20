package com.atguigu.chapter17.remotecandymachine.client



import com.atguigu.chapter17.remotecandymachine.server.CandyMachineRemote

import scala.collection.mutable.ListBuffer

//本地的一个监控机
class Monitor {

  //如果是远程监控，这里我们放的是CandyMachineRemote,即糖果机的代理
  private val candyMachinelst: ListBuffer[CandyMachineRemote] = ListBuffer()

  //给监控器增加一个糖果机
  def addMachine(mCandyMachine:CandyMachineRemote) = {
    candyMachinelst.append(mCandyMachine)
  }

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
