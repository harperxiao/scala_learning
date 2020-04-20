package com.atguigu.chapter17.remotecandymachine.server

import java.rmi.RemoteException
import java.rmi.server.UnicastRemoteObject

//糖果机状态..
class CandyMachine extends UnicastRemoteObject with CandyMachineRemote{

  var mSoldOutState: State = _
  var mOnReadyState: State = _
  var mHasCoin: State = _
  var mSoldState: State = _
  var mWinnerState: State = _
  private var location = ""
  private var state: State = _
  private var count = 0

  //需要抛出RemoteException 异常
  @throws(classOf[RemoteException])
  def this(location: String, count: Int) {
    this
    this.location = location
    this.count = count
    mSoldOutState = new SoldOutState(this);
    mOnReadyState = new OnReadyState(this);
    mHasCoin = new HasCoin(this);
    mSoldState = new SoldState(this);
    mWinnerState = new WinnerState(this);
    if (count > 0) {
      state = mOnReadyState;
    } else {
      state = mSoldOutState;
    }
  }

  //给糖果机设置状态
  def setState(state: State) = {
    this.state = state
  }
  def getLocation(): String = {
    location
  }

  def insertCoin() = {
    state.insertCoin()
  }

  def returnCoin() = {
    state.returnCoin()
  }

  def turnCrank() = {
    state.turnCrank()
    state.dispense()
  }

  def releaseCandy() = {

    if (count > 0) {
      count = count - 1
      println("a candy rolling out!");
    }

  }

  def getCount(): Int = {
    count
  }

  def printstate() = {
    state.printstate()
  }

  def getstate(): State = {
    state
  }
}
