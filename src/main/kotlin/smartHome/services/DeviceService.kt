package smartHome.services

import java.util.*

val protocol = 4
val codes_on = arrayOf("658800", "587188", "658812", "448418")
val codes_off = arrayOf("151184", "99108", "448428", "587186")


fun deviceOn(id : Int) {
  println("Device $id on")
  sendCode(codes_on[id])
}

fun deviceOff(id : Int) {
  println("Device $id off")
  sendCode(codes_off[id])
}

fun sendCode(code: String) {
  val proc = Runtime.getRuntime().exec("src/main/resources/codesend $code $protocol")
  Scanner(proc.inputStream).use {
    while (it.hasNextLine()) println(it.nextLine())
  }
}
