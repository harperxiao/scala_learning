package com.atguigu.chapter17.rmi

import java.rmi.Naming

class MyRemoteClient {
  def go() = {
    val service = Naming.lookup("rmi://127.0.0.1:9999/RemoteHello").asInstanceOf[MyRemote]
    val str = service.sayHello()
    println("str = " + str)
  }
}

object MyRemoteClient {
  def main(args: Array[String]): Unit = {
    new MyRemoteClient().go()
  }
}

