
object MixinTraitDemo1 {
  def main(args: Array[String]): Unit = {


    //研究第一个问题，当我们创建一个动态混入对象时，其顺序是怎样的
    //总结一句话
    //Scala在叠加特质的时候，(即从左到右)
    //1.Operate4...
    //2.Data4
    //3.DB4
    //4.File4
    val mysql = new MySQL4 with DB4 with File4
    println(mysql)

    //研究第2个问题，当我们执行一个动态混入对象的方法，其执行顺序是怎样的
    //顺序是，(1)从右到左开始执行 , (2)当执行到super时，是指的左边的特质 (3) 如果左边没有特质了，则super就是父特质
    //1. 向文件"
    //2. 向数据库
    //3. 插入数据 100
//    mysql.insert(100)

    println("===================================================")
    //练习题
    val mySQL4 = new MySQL4 with  File4 with DB4
    mySQL4.insert(999)
    //构建顺序
    //1.Operate4...
    //2.Data4
    //3.File4
    //4.DB4

    //执行顺序
    //1. 向数据库
    //2. 向文件
    //3. 插入数据 = 999
  }
}

trait Operate4 { //特点
  println("Operate4...")

  def insert(id: Int) //抽象方法
}

trait Data4 extends Operate4 { //特质，继承了Operate4
  println("Data4")

  override def insert(id: Int): Unit = { //实现/重写 Operate4 的insert
    println("插入数据 = " + id)
  }
}

trait DB4 extends Data4 { //特质，继承 Data4
  println("DB4")

  override def insert(id: Int): Unit = { // 重写 Data4 的insert
    println("向数据库")
    super.insert(id)
  }
}

trait File4 extends Data4 { //特质，继承 Data4
  println("File4")

  override def insert(id: Int): Unit = { // 重写 Data4 的insert
    println("向文件")
//    super.insert(id) //调用了insert方法(难点)，这里super在动态混入时，不一定是父类
    //如果我们希望直接调用Data4的insert方法，可以指定，如下
    //说明：super[?] ?的类型，必须是当前的特质的直接父特质(超类)
    super[Data4].insert(id)
  }
}

class MySQL4  {} //普通类

