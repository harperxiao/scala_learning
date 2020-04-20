object AnonymouseFunction {
  def main(args: Array[String]): Unit = {
    //对匿名函数的说明
    //1. 不需要写 def 函数名
    //2. 不需要写返回类型，使用类型推导
    //3. =  变成  =>
    //4. 如果有多行，则使用{} 包括
    val triple = (x: Double) => {
      println("x=" + x)
      3 * x
    }
    println("triple" + triple(3)) // 9.0

  }
}