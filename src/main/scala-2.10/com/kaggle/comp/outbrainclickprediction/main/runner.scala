package com.kaggle.comp.outbrainclickprediction.main

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by boma on 17/10/2016.
  */
object runner {

  def main(args: Array[String]): Unit = {
    val appName=args(0)
    val master=args(1)
    val input=args(2)
    val output=args(3)
    val sparkConfif=new SparkConf()
      sparkConfif.setAppName(appName).setMaster(master)
    val sc=new SparkContext(sparkConfif)

  }

}
