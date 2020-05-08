class Test {
 /* val address = sc.textFile("/tmp/csv/address.csv").map(_.split(",")).keyBy(a => a(0)).cache()
  val person = sc.textFile("/tmp/csv/person.csv").map(_.split(",")).keyBy(p => p(0)).cache()

  val outE = sc.textFile("/tmp/csv/person_address.csv").map(_.split(",")).keyBy(e => e(0)).cache()
  val inE = outE.map(x => Array(x._2(1), x._2(0))).keyBy(e => e(0)).cache()

  val addressOutE = address.join(outE).mapValues(x => (x._1.slice(1, 3), x._2(1)))
  val personInE = person.join(inE).mapValues(x => (x._1.slice(1, 3), x._2(1)))

  val addressLines = addressOutE.map(a => Array("address", a._1, a._2._1.mkString(","), a._2._2).mkString(":"))
  val personLines = personInE.map(a => Array("person", a._1, a._2._1.mkString(","), a._2._2).mkString(":"))

  addressLines.union(personLines).saveAsTextFile("/tmp/csv/input")
  */
}
