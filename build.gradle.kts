plugins {
	id("org.jetbrains.kotlin.konan").version("0.8.2")
}

konanArtifacts {
	interop("glfw3")

	program("HelloWorld") {
		libraries {
			artifact("glfw3")
		}
	}
}
