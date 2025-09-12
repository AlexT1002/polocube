package dev.httpmarco.polocube.cube

import java.io.File
import java.net.URLClassLoader

fun loadCubes(path: String): List<CubeSnapshot> {
    val snapshots = mutableListOf<CubeSnapshot>()

    val dir = File(path)
    if (!dir.exists() || !dir.isDirectory) {
        return emptyList()
    }

    val jars = dir.listFiles { f -> f.extension == "jar" } ?: return emptyList()
    val urls = jars.map { it.toURI().toURL() }.toTypedArray()

    val loader = URLClassLoader(urls, Cube::class.java.classLoader)

    for (jar in jars) {
        val jarFile = java.util.jar.JarFile(jar)
        val entries = jarFile.entries()

        while (entries.hasMoreElements()) {
            val entry = entries.nextElement()
            if (entry.name.endsWith(".class") && !entry.isDirectory) {
                val className = entry.name
                    .removeSuffix(".class")
                    .replace("/", ".")
                try {
                    val clazz = loader.loadClass(className)
                    if (Cube::class.java.isAssignableFrom(clazz) && !clazz.isInterface && !java.lang.reflect.Modifier.isAbstract(clazz.modifiers)) {
                        val annotation = clazz.getDeclaredAnnotation(CubeData::class.java)
                        if (annotation != null) {
                            snapshots.add(CubeSnapshot(annotation, clazz as Class<Cube>))
                        }
                    }
                } catch (_: Throwable) { }
            }
        }
    }

    return snapshots
}