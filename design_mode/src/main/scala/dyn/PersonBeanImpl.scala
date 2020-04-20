package com.atguigu.chapter17.dyn


//这个是要被调用的对象.
class PersonBeanImpl extends PersonBean {

  var name = ""
  var gender = ""
  var interests = ""

  var score :Int = _ // 评分值


  override def getName(): String = {
    return name
  }

  override def getGender(): String = {
    gender
  }

  override def getInterests(): String = {
    interests
  }




  override def setName(name: String): Unit = {
    this.name = name
  }

  override def setGender(gender: String): Unit = {
    this.gender = gender
  }

  // 自己可以调用
  // 其它用户不能调用
  override def setInterests(interests: String): Unit = {
    this.interests = interests
  }


  override def getScore(): Int = {
    score
  }

  //自己不能调用
  //其它用户可以调
  override def setScore(score: Int): Unit = {
    this.score = score
  }
}
