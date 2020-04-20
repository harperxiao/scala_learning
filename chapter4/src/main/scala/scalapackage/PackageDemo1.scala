
////代码说明
//1. package com.atguigu{}  表示我们创建了包 com.atguigu ,在{}中
//   我们可以继续写它的子包 scala //com.atguigu.scala, 还可以写类,特质trait,还可以写object
//2. 即sacla支持，在一个文件中，可以同时创建多个包，以及给各个包创建类,trait和object


package com.atguigu { //包 com.atguigu

  //  class User { // 在com.atguigu包下创建个 User类
  //    def sayHello(): Unit = {
  //      //想使用 com.atguigu.scala2包下的 Monster
  //      import com.atguigu.scala2.Monster
  //      val monster = new Monster()
  //    }
  //  }
  //
  //  package scala2 { // 创建包 com.atguigu.scala2
  //    class User { // 在com.atguigu.scala2 包下创建个 User类
  //   }
  //
  //    class Monster { //
  //
  //    }
  //
  //  }


  //
  //说明
  //1. 在包中直接写方法，或者定义变量，就错误==>使用包对象的技术来解决
  //2. package object scala 表示创建一个包对象 scala, 他是 com.atguigu.scala这个包对应的包对象
  //3. 每一个包都可以有一个包对象
  //4. 包对象的名字需要和子包一样
  //5. 在包对象中可以定义变量，方法
  //6. 在包对象中定义的变量和方法，就可以在对应的包中使用
  //7. 在底层这个包对象会生成两个类 package.class  和 package$.class
  package object scala {
    var name = "king"

    def sayHiv(): Unit = {
      println("package object scala sayHI~")
    }
  }


  package scala { //包 com.atguigu.scala

    class Person { // 表示在 com.atguigu.scala下创建类 Person
      val name = "Nick"

      def play(message: String): Unit = {
        println(this.name + " " + message)
      }
    }

    class User {
      def testUser(): Unit = {
        println("name = " + name)
        sayHiv()
      }
    }

    object Test100 { //表示在 com.atguigu.scala 创建object Test
      def main(args: Array[String]): Unit = {

        println("name=" + name)
        name = "yy"
        sayHiv()

        //        println("ok")
        //        //我们可以直接使用父包的内容
        //        //1.如果有同名的类，则采用就近原则来使用内容(比如包)
        //        //2.如果就是要使用父包的类，则指定路径即可
        //        val user = new User
        //        println("user=" + user) //
        //        val user2 = new com.atguigu.User()
        //        println("user2" + user2)

      }
    }

  }

}

