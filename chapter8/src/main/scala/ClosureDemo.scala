
object ClosureDemo {
  def main(args: Array[String]): Unit = {


    //使用并测试
    val f = makeSuffix(".jpg")
    println(f("dog.jpg")) // dog.jpg
    println(f("cat")) // cat.jpg

  }
  def makeSuffix(suffix: String) = {
    //返回一个匿名函数，回使用到suffix
    (filename:String) => {
      if (filename.endsWith(suffix)) {
        filename
      } else {
        filename + suffix
      }
    }
  }
}