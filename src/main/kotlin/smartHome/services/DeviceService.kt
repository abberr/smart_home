package smartHome.services

import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

val protocol = 4
val codes_on = arrayOf("658800", "587188")
val codes_off = arrayOf("151184", "99108")


fun deviceOn(id : Int) {
  println("Device $id on")
  sendCode(codes_on[id])
}

fun deviceOff(id : Int) {
  println("Device $id off")
  sendCode(codes_off[id])
}

fun sendCode(code: String) {
  val proc = Runtime.getRuntime().exec("src/main/resources/codesend $code $protocol")  // testing on Windows 10
  Scanner(proc.inputStream).use {
    while (it.hasNextLine()) println(it.nextLine())
  }
}
