object CurryDemo {
  def main(args: Array[String]): Unit = {

    def eq(s1:String,s2:String):Boolean={
      s1.equals(s2)
    }

    implicit class TestEq(s:String){
      def check(ss:String)(f:(String,String) => Boolean): Boolean ={
        f(s.toLowerCase,ss.toLowerCase)
      }
    }

    val str1 = "hello"
    println(str1.check("Hello")(eq))

    println(str1.check("Hello")(_.equals(_)))
  }
}
