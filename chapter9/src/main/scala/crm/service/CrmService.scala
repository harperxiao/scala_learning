package crm.service
import util.control.Breaks._

import crm.bean.Customer

import scala.collection.mutable.ArrayBuffer
import scala.io.StdIn

class CrmService {


  var customernum = 1
  val customers = ArrayBuffer(new Customer(1, "tom", '男', 10, "110", "tom@sohu.com"))


  def list() :ArrayBuffer[Customer]= {
    this.customers
  }

  def add(customer: Customer) = {
    customernum += 1
    customer.id = customernum
    customers.append(customer)
  }


  def findIndexById(id: Int) = {
    var index = -1
    breakable {
      for (i <- 0 until customers.length) {
        if (customers(i).id == id) { //找到
          index = i
          break()
        }
      }
    }
    index
  }

  def del(id: Int): Boolean = {
    val index = findIndexById(id)
    if (index != -1) {
      //删除
      customers.remove(index)
      true
    }else {
      false
    }
  }


}
