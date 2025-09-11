package dev.httpmarco.polocube.cube

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class CubeData(val name: String)
