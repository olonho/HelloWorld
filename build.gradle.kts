plugins {
	id("org.jetbrains.kotlin.konan").version("0.8.2")
}

konanArtifacts {
	interop("glfw3") {
           compilerOpts("-I/usr/local/include")
        }

	program("HelloWorld") {
                linkerOpts("-L/usr/local/lib")
		libraries {
			artifact("glfw3")
		}
	}
}
