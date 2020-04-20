object ImplicitClassDemo1 {
  def main(args: Array[String]): Unit = {
    implicit def addDelete(m:MySQL):DB={
      new DB
    }

    val mySQL = new MySQL
    mySQL.delete()
    mySQL.update()
  }
}

class MySQL {
  def insert(): Unit = {
    println("insert")
  }
}

class DB {
  def delete(): Unit = {
    println("delete")
  }

  def update(): Unit = {
    println("update")
  }
}