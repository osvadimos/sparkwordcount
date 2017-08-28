import org.apache.spark.{SparkConf, SparkContext}

object WordCountSpark {

  def main(args: Array[String]){
    println("Hello huj, ahuenna")
    val sc = new SparkContext(new SparkConf().setAppName("wordCount").setMaster("local"))
  }

}
