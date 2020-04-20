package com.atguigu.chapter17.remotecandymachine.server

class SoldState extends State {
  //说明:@transient注解将字段标记为瞬态的,即表示一个域不是该对象串行化的一部分
  @transient private var mCandyMachine: CandyMachine = _

  def this(mCandyMachine: CandyMachine) {
    this
    this.mCandyMachine = mCandyMachine
  }

  override def getstatename(): String = {
    "SoldState"
  }

  //根据当前状态，我们的insertCoin有不同的业务逻辑
  //其它的方法同样存在这样的处理
  override def insertCoin(): Unit = {
    println("please wait!we are giving you a candy!")
  }

  override def printstate(): Unit = {
    println("******SoldState******")
  }

  override def returnCoin(): Unit = {
    println("you haven't inserted a coin yet!")

  }

  override def turnCrank(): Unit = {
    println("we are giving you a candy,turning another get nothing!")
  }

  override def dispense(): Unit = {
    // TODO Auto-generated method stub

    mCandyMachine.releaseCandy() //数量减去
    if (mCandyMachine.getCount() > 0) { //如果还有糖，则进入readystate
      mCandyMachine.setState(mCandyMachine.mOnReadyState);
    } else { // 没有糖，则进入soleoutstate
      println("Oo,out of candies");
      mCandyMachine.setState(mCandyMachine.mSoldOutState);
    }
  }
}
