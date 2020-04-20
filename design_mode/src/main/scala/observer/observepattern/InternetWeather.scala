package com.atguigu.chapter17.observer.observepattern


object InternetWeather {
  def main(args: Array[String]): Unit = {

    //创建个月气象局的天气公告板
    val mCurrentConditions = new CurrentConditions()

    val mWeatherDataSt = new WeatherDataSt
    //mCurrentConditions 注册
    mWeatherDataSt.registerObserver(mCurrentConditions)

    //创建一个新浪的天气公告板
    val sinaCurrentConditions = new SinaCurrentConditions
    mWeatherDataSt.registerObserver(sinaCurrentConditions)


    //比如天气情况变化，这里设置最新数据
    mWeatherDataSt.setData(20, 150, 40)

    //java.util.Observable
  }
}
