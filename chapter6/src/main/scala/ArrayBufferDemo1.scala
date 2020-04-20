import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

object ArrayBufferDemo1 {
  def main(args: Array[String]): Unit = {
    val arrayBuffer: ArrayBuffer[Int] = mutable.ArrayBuffer[Int]()

    arrayBuffer.append(1,2,3)
    println(arrayBuffer)


    val arr = ArrayBuffer("1", "2", "3")
    import scala.collection.JavaConversions.bufferAsJavaList
    val javaArr = new ProcessBuilder(arr) //为什么可以这样使用?
    // 这里arrList 就是java中的List
    val arrList = javaArr.command()

    /*
    implicit def asScalaBuffer[A](l : java.util.List[A]) : scala.collection.mutable.Buffer[A] = { /* compiled code */ }
     */
    import scala.collection.JavaConversions.asScalaBuffer
    import scala.collection.mutable
    // java.util.List ==> Buffer
    val scalaArr: mutable.Buffer[String] = arrList
    scalaArr.append("jack")
    scalaArr.append("tom")
    scalaArr.remove(0)


    //3. arrayBuffer本身没有任何变化
    val newArray = arrayBuffer.toArray

//    /说明
    //1. newArr.toBuffer 是把 Array->ArrayBuffer
    //2. 底层的实现
    /*
     override def toBuffer[A1 >: A]: mutable.Buffer[A1] = {
    val result = new mutable.ArrayBuffer[A1](size)
    copyToBuffer(result)
    result
  }
     */
    //3. newArr本身没变化
    val newArr2 = newArray.toBuffer
    newArr2.append(123)
    println(newArr2)

    val arr01 = new Array[Int](4)

    arr01
  }

}
