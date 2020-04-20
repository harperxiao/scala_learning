object LowerBoundsDemo01 {
  def main(args: Array[String]): Unit = {
//    println("ok!")
//    //满足下界的约束
//    biophony(Seq(new Earth1, new Earth1)).map(_.sound())
//    //满足下界的约束
//    biophony(Seq(new Animal1, new Animal1)).map(_.sound())

    //这里我们不能使用上界的思路去推导，这里是可以运行
    //1.?
//    println("===================")
//    biophony(Seq(new Bird1, new Bird1)).map(_.sound())//

    //biophony(Seq(new Moon))

  }
  //下界
  def biophony[T >: Animal](things: Seq[T]) = things
}


class Earth1 { //Earth 类
  def sound(){ //方法
    println("hello !")
  }
}
class Animal1 extends Earth1{
  override def sound() ={ //重写了Earth的方法sound()
    println("animal sound")
  }
}
class Bird1 extends Animal1{
  override def sound()={ //将Animal的方法重写
    print("bird sounds")
  }
}
class Moon {
//  def sound()={ //将Animal的方法重写
//    print("bird sounds")
//  }
}
