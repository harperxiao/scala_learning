
object recursionDemo1 {

  def main(args: Array[String]): Unit = {
    println("桃子个数=" + peach(1)) // 1534

  }


  def peach(day:Int): Int ={
    if(day==10){
      1
    }else{
      2*(peach(day+1)+1)
    }

  }
}
