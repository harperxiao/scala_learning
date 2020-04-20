object AbstractControl {
  def main(args: Array[String]): Unit = {
    //myRunInThread 就是一个抽象控制
    //是没有输入， 也没有输出的函数 f1: () => Unit
    def myRunInThread(f : ()=>Unit) = {
      new Thread{
        override def run(): Unit = {
          f()
        }
      }.start()
    }


    myRunInThread{
      () => {
        println("干活")
        Thread.sleep(5)
        println("干完")
      }
    }

    def myRunInThread1(f : =>Unit) = {
      new Thread{
        override def run(): Unit = {
          f
        }
      }.start()
    }
    myRunInThread1 {
      println("干活咯！5秒完成...~~~")
      Thread.sleep(5000)
      println("干完咯！~~~")
    }

  }

}
