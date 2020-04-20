package com.atguigu.chapter17.dyn

import java.lang.reflect.Proxy

class MatchService {

  //创建了一个Person
  val tom = getPersonInfo("tom", "男", "爱好编程")


  //得到一个给自己调用的代理对象，它替代被调用的对象
  val OwnerProxy = getOwnerProxy(tom)


  println("Name is " + OwnerProxy.getName()) // tom
  println("Interests is " + OwnerProxy.getInterests()) // 爱好编程

  OwnerProxy.setInterests("爱好淘宝~")
  println("Interests is " + OwnerProxy.getInterests()) // 爱好淘宝~
  //自己给自己设置评分，通过代理控制，不能成功
  OwnerProxy.setScore(100) //刷分不成功!
  println("Score is " + OwnerProxy.getScore()) //分值仍然为 0





  println("****测试NonOwnerInvocationHandler**********")

  val mary = getPersonInfo("mary", "女", "爱好购物...")

  //返回一个其用户调用的代理对象
  val nonOwnerProxy = getNonOwnerProxy(mary)
  println("Name is " + nonOwnerProxy.getName()) // mary
  println("Interests is " + nonOwnerProxy.getInterests()) // 爱好购物...
  //其它人不能修改兴趣，通过代理进行控制不能调用setInterests
  nonOwnerProxy.setInterests("爱好小猫咪~~") //失败，在动态代理控制
  println("Interests is " + nonOwnerProxy.getInterests()) //爱好购物...
  nonOwnerProxy.setScore(68) //其它人可以评分ok
  println("score is " + nonOwnerProxy.getScore()) // 68

  def getPersonInfo(name: String, gender: String, interests: String): PersonBean = {
    val person = new PersonBeanImpl()
    person.setName(name)
    person.setGender(gender)
    person.setInterests(interests)
    person
  }

  def getOwnerProxy(person: PersonBean): PersonBean = {


    Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OwnerInvocationHandler(person)).asInstanceOf[PersonBean]

  }

  def getNonOwnerProxy(person: PersonBean): PersonBean = {

    Proxy.newProxyInstance(person.getClass()
      .getClassLoader(), person.getClass().getInterfaces(),
      new NonOwnerInvocationHandler(person)).asInstanceOf[PersonBean]
  }
}
