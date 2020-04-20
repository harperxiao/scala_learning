
object MatchObject {
  def main(args: Array[String]): Unit = {

    // 模式匹配使用：
    val number: Double = 36.0// 36.0 //

    number match {
      //说明 case Square(n) 的运行的机制
      //1. 当匹配到 case Square(n)
      //2. 调用Square 的 unapply(z: Double),z 的值就是 number
      //3. 如果对象提取器 unapply(z: Double) 返回的是Some(6) ,则表示匹配成功，同时
      //   将6 赋给 Square(n) 的n
      //4.  果对象提取器 unapply(z: Double) 返回的是None ,则表示匹配不成功
      case Square(n) => println("匹配成功 n=" + n)
      case _ => println("nothing matched")
    }

    val namesString = "Bob,Thomas" //字符串
    //说明
    namesString match {
      // 当 执行   case Names(first, second, third)
      // 1. 会调用 unapplySeq（str）,把 "Alice,Bob,Thomas" 传入给 str
      // 2. 如果 返回的是 Some("Alice","Bob","Thomas"),分别给 （first, second, third）
      //    注意，这里的返回的值的个数需要和 （first, second, third）要一样
      // 3. 如果返回的None ,表示匹配失败

      case Names(first, second, third) => {
        println("the string contains three people's names")
        // 打印字符串
        println(s"$first $second $third")
      }
      case _ => println("nothing matched")
    }


    val (x, y, z) = (1, 2, "hello")
    println("x=" + x)
    val (q, r) = BigInt(10) /% 3 //说明  q = BigInt(10) / 3 r = BigInt(10) % 3
    val arr = Array(1, 7, 2, 9)
    val Array(first, second, _*) = arr // 提出arr的前两个元素
    println(first, second)

    List(1, 3, 5, 9) match { //修改并测试
      //1.两个元素间::叫中置表达式,至少first，second两个匹配才行.
      //2.first 匹配第一个 second 匹配第二个, rest 匹配剩余部分(5,9)
      case first :: second :: rest => println(first + " " + second  + " "+ rest.length + " " + rest) //
      case _ => println("匹配不到...")
    }

  }
}

//说明

object Square {
  //说明
  //1. unapply方法是对象提取器
  //2. 接收z:Double 类型
  //3. 返回类型是Option[Double]
  //4. 返回的值是 Some(math.sqrt(z)) 返回z的开平方的值，并放入到Some(x)
  def unapply(z: Double): Option[Double] = {
    println("unapply被调用 z 是=" + z)
    Some(math.sqrt(z))
    //None
  }
  def apply(z: Double): Double = z * z
}

//object
object Names {
  //当构造器是多个参数时，就会触发这个对象提取器
  def unapplySeq(str: String): Option[Seq[String]] = {
    if (str.contains(",")) Some(str.split(","))
    else None
  }
}