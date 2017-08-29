import org.apache.spark.{SparkConf, SparkContext}

object WordCountSpark {

  def main(args: Array[String]){
    println("Hello huj, ahuenna")
    val sc = new SparkContext(new SparkConf().setAppName("wordCount").setMaster("local"))
    //get threshold
    val threshold = args(1).toInt
    //read and split file
    val tokenized = sc.textFile(args(0)).flatMap(_.split(" "))
    //reduce
    val wordCounts = tokenized.map((_, 1)).reduceByKey(_ + _)
    val filtered = wordCounts.filter(_._2 >= threshold)
    //count characters
    val charCounts = filtered.flatMap(_._1.toCharArray).map((_, 1)).reduceByKey(_ + _)
    println(charCounts.collect().mkString(", "))
  }

}
