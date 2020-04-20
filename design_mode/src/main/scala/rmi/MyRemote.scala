package com.atguigu.chapter17.rmi

import java.rmi.{Remote, RemoteException}

//这是一个接口文件.该文件会给远程端和本地端是使用
trait MyRemote extends Remote{

  //一个抽象方法
  @throws(classOf[RemoteException])
  def sayHello(): String //throws RemoteException

}
