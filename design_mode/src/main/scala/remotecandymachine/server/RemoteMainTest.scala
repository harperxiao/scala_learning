package com.atguigu.chapter17.remotecandymachine.server

import java.rmi.Naming
import java.rmi.registry.LocateRegistry

object RemoteMainTest {
  def main(args: Array[String]): Unit = {
    try {
      var service = new CandyMachine("candymachine1", 10)
//      LocateRegistry.createRegistry(6602)
//      Naming.rebind("candymachine1", service)
      Naming.rebind("rmi://127.0.0.1:6602/candymachine1", service)
      service.insertCoin()//故意改变下，糖果的初始状态，看是否在客户端(代理端)监控到
      service.turnCrank()
      println("服务器端两台糖果机开始运行,在6602端口监听..")
    } catch  {
      case ex : Exception => {
        ex.printStackTrace()
      }
    }
  }
}
