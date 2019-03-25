package smartHome.services

import java.io.File
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
  Runtime.getRuntime().exec("src/main/resources/codesend.sh $code $protocol")
}

//fun String.runCommand(workingDir: File) {
//  ProcessBuilder(*split(" ").toTypedArray())
//    .directory(workingDir)
//    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
//    .redirectError(ProcessBuilder.Redirect.INHERIT)
//    .start()
//    .waitFor(60, TimeUnit.MINUTES)
//}
