import scala.collection.mutable

object QueueDemo01 {
  def main(args: Array[String]): Unit = {

    //创建队列
    val q1 = new mutable.Queue[Int]
    println(q1)

    //给队列增加元素
    q1 += 9 // (9)
    println("q1=" + q1) // (9)
    q1 ++= List(4,5,7) // 默认值直接加在队列后面
    println("q1=" + q1) //(9,4,5,7)


    //dequeue 从队列的头部取出元素 q1本身会变
    val queueElement = q1.dequeue()
    println("queueElement=" + queueElement + "q1="+q1)

    //enQueue 入队列，默认是从队列的尾部加入. Redis
    q1.enqueue(100,10,100,888)
    println("q1=" + q1) // Queue(4, 5, 7, 100,10,100,888)


    println("============Queue-返回队列的元素=================")
    //队列 Queue-返回队列的元素

    //1. 获取队列的第一个元素
    println(q1.head) // 4, 对q1没有任何影响
    //2. 获取队列的最后一个元素
    println(q1.last) // 888, 对q1没有任何影响
    //3. 取出队尾的数据 ,即：返回除了第一个以外剩余的元素，可以级联使用
    println(q1.tail) // (5, 7, 100,10,100,888)
    println(q1.tail.tail.tail.tail) // (10,100,888)

  }
}
