package com.atguigu.chapter17.singleton

object TestSingleTon {
  def main(args: Array[String]): Unit = {
    val instance1 = SingleTon.getInstance
    val instance2 = SingleTon.getInstance
    if (instance1 == instance2) {
      println("相等")
    }
  }
}

//将SingleTon的构造方法私有化
class SingleTon private() {}

//懒汉式
//看底层
/*
  public SingleTon getInstance() {
    if (s() == null) {
      s_$eq(new SingleTon());
    }
    return s();
  }
 */
object SingleTon { //SingleTon$
  private var s: SingleTon = null

  def getInstance = {
    if (s == null) {
      s = new SingleTon
    }
    s
  }
}

