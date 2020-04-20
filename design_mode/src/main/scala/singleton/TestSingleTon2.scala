package com.atguigu.chapter17.singleton

object TestSingleTon2 {
  def main(args: Array[String]): Unit = {
    val instance1 = SingleTon2.getInstance
    val instance2 = SingleTon2.getInstance
    if (instance1 == instance2) {
      println("相等~~~")
    }
  }
}


//将SingleTon的构造方法私有化
class SingleTon2 private() {}

//饿汉式
//看底层
/*
public SingleTon2 getInstance() {
    return s();
  }
 */
object SingleTon2 { //SingleTon$
  private val s: SingleTon2 = new SingleTon2

  def getInstance = {
    s
  }
}