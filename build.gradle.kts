plugins {
	id("org.jetbrains.kotlin.konan").version("0.8.2")
}

val glfwMingw = System.getProperty("user.home") + "/HelloWorld/src/main/c_interop/glfw-3.2.1"
val glfwMac = "/usr/local"

konanArtifacts {
	interop("glfw3") {
           target("macos") {
             compilerOpts("-I$glfwMac/include")
           }
           target("mingw") {
             compilerOpts("-I$glfwMingw/include")
           }
        }

	program("HelloWorld") {
                target("macos") {
                  linkerOpts("-L$glfwMac/lib")
                }
                target("mingw") {
                  linkerOpts("-L$glfwMingw/lib-mingw-w64")
                }
		libraries {
			artifact("glfw3")
		}
	}
}
