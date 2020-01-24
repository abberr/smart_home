package smartHome.services

import java.util.*

const val PROTOCOL = 4
val CODES_ON = arrayOf("658800", "587188", "587196", "448418")
val CODES_OFF = arrayOf("151184", "99108", "448428", "587186")


fun deviceOn(id : Int) {
  println("Device $id on")
  sendCode(CODES_ON[id])
}

fun deviceOff(id : Int) {
  println("Device $id off")
  sendCode(CODES_OFF[id])
}

fun sendCode(code: String) {
  val proc = Runtime.getRuntime().exec("src/main/resources/codesend $code $PROTOCOL")
  Scanner(proc.inputStream).use {
    while (it.hasNextLine()) println(it.nextLine())
  }
}
