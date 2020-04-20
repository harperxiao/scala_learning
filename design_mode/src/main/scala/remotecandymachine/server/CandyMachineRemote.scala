package com.atguigu.chapter17.remotecandymachine.server

import java.rmi.{Remote, RemoteException}

trait CandyMachineRemote extends Remote {

  @throws(classOf[RemoteException])
  def getLocation(): String

  @throws(classOf[RemoteException])
  def getCount(): Int

  @throws(classOf[RemoteException])
  def getstate(): State
}