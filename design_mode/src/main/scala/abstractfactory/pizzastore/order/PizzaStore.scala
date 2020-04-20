package abstractfactory.pizzastore.order

object PizzaStore {
  def main(args: Array[String]): Unit = {
    new OrderPizza(new BJFactory)
    //new OrderPizza(new LDFactory)
  }
}
