package com.atguigu.chapter17.proxy.localcandymachine

object TestCanyMachine {
  def main(args: Array[String]): Unit = {
    //创建一个监控器
    val mMonitor = new Monitor()

    //北京-海淀区糖果机，有6颗糖
    var mCandyMachine = new CandyMachine("北京-海淀区", 6)
    //将糖果机加入监控器
    mMonitor.addMachine(mCandyMachine)

    mCandyMachine = new CandyMachine("北京-昌平区~", 4)
    mCandyMachine.insertCoin()
    mMonitor.addMachine(mCandyMachine)

    mCandyMachine = new CandyMachine("北京-朝阳区", 14);
    //这里故意修改了北京-朝阳区状态
    mCandyMachine.insertCoin()
    mCandyMachine.turnCrank()//转动曲柄，出糖
    mMonitor.addMachine(mCandyMachine)
    //输出监控器管理的所有糖果机情况
    mMonitor.report()
  }
}
