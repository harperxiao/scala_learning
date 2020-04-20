object ParameterDemo1 {

  def mysqlCon(add:String = "loaclhost",port:Int = 3306,user:String ="root",pwd:String = "root" ): Unit = {
    println("add=" + add)
    println("port=" + port)
    println("user=" + user)
    println("pwd=" + pwd)
  }

  def test(str: String, tiger: Tiger): Tiger = {
    tiger.name = str
    tiger
  }

  def main(args: Array[String]): Unit = {

    mysqlCon()
    mysqlCon(user="xx")

    val tiger = new Tiger
    val tiger2: Tiger = test("jack",tiger)
    println(tiger2.name) // jack
    println(tiger.name) // jack
    println(tiger.hashCode() + " " + tiger2.hashCode())


  }



}

class Tiger{
  var name=""
}
