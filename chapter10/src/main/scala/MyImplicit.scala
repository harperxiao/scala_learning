
object MyImplicit {
  implicit def person3toOrderedPerson3(p3:Person3) = new Ordered[Person3] {
    override def compare(that: Person3) = { //是你自己的业务逻辑
      p3.age - that.age
    }
  }

}