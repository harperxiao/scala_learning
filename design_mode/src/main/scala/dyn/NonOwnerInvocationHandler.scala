package com.atguigu.chapter17.dyn

import java.lang.reflect.{InvocationHandler, Method}

//其它用户调用的
class NonOwnerInvocationHandler extends InvocationHandler {

  var person: PersonBean = _

  //构造器
  def this(person: PersonBean) {
    this
    this.person = person
  }

  //说明
  //1.这里的proxy就是和NonOwnerInvocationHandler合作的代理
  @throws(classOf[Throwable])
  override def invoke(proxy: scala.Any, method: Method, args: Array[AnyRef]): AnyRef = {
    //如果是get方法就直接调用
    if (method.getName().startsWith("get")) {
      return method.invoke(person)
      //其它用户可以调用setHotOrNotRating,进行评分
    } else if (method.getName().equals("setScore")) {
      return method.invoke(person, Integer.valueOf(args(0).toString))

      //其它用户不能调用set方法
    } else if (method.getName().startsWith("set")) {
      return new IllegalAccessException()
    }

    null
  }
}
