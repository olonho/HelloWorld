//import glfw3.*
import kotlinx.cinterop.refTo
import kotlinx.cinterop.toKString
import platform.posix.*

fun main(args: Array<String>) {
	println("Hello, Native World!")


//	println(glfwGetVersionString()?.toKString())

	readFile()
	printDir()
}

fun readFile() {
	val file = fopen("test.txt", "r")
	if (file == null) {
		perror("RIP")
		return
	}

	try {
		val buffer = ByteArray(64 * 1024)
		var res = fgets(buffer.refTo(0), buffer.size, file)?.toKString()
		while (res != null) {
			print(res)
			res = fgets(buffer.refTo(0), buffer.size, file)?.toKString()
		}
	} finally {
		fclose(file)
	}
}

fun printDir() {
	val dp = opendir ("./")

	if (dp != null) {
		var ep = readdir(dp)
		while (ep != null) {
//            println(ep.pointed.d_name.toKString())
			ep = readdir(dp)
		}
		closedir(dp)
	} else {
		perror("Couldn't open the directory")
	}
}
