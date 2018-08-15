/**
  * Created by Administrator on 2017/3/2.
  */

import org.apache.spark.SparkConf
import org.apache.spark.ml.evaluation.RegressionEvaluator
import org.apache.spark.ml.recommendation.ALS
import org.apache.spark.sql.SparkSession
import org.apache.spark.ml.recommendation.ALSModel

object Recomm {
    case class Rating(userId: Int, itemId: Int, score: Int)
    def doRecomm() = {
        def parseRating(str: String): Rating = {
            val fields = str.split(",")
            assert(fields.size == 4)
            Rating(fields(0).toInt, fields(1).toInt, fields(2).toInt)
        }

        val spark = SparkSession.builder.master("spark://s201:7077").appName("Recomm").getOrCreate()
        import spark.implicits._
        val model = ALSModel.load("hdfs://s201/user/centos/eshop/model/rec.mod")
        val test = spark.sparkContext.textFile("hdfs://s201/user/centos/eshop/recommends/testdata.txt").map(parseRating).toDF();
        val predictions = model.transform(test)
        predictions.foreach(e=>{
            print(e.get(0))
        })
    }

    def main(args: Array[String]): Unit = {
        doRecomm()
    }
}
