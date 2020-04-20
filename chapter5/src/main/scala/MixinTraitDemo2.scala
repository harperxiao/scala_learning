
object MixinTraitDemo2 {
  def main(args: Array[String]): Unit = {
    //在不修改 类的定义基础，让他们可以使用trait方法
    val oracleDB = new OracleDB with Operate3
    oracleDB.insert(100) //

    val mySQL = new MySQL3 with Operate3
    mySQL.insert(200)

    //如果一个抽象类有抽象方法，如何动态混入特质
    val mySql_ = new MySQL3_ with Operate3 {
      override def say(): Unit = {
        println("say")
      }
    }
    mySql_.insert(999)
    mySql_.say()
  }}

trait Operate3 { //特质
  def insert(id: Int): Unit = { //方法（实现）
    println("插入数据 = " + id)
  }
}

class OracleDB { //空
}
abstract class MySQL3 { //空
}

abstract class MySQL3_ { //空
  def say()
}

