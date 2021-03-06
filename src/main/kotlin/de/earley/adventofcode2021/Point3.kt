package de.earley.adventofcode2021

import kotlin.math.abs

data class Point3(
	val x: Int,
	val y: Int,
	val z: Int,
) {
	operator fun minus(other: Point3): Point3 = Point3(
		x - other.x,
		y - other.y,
		z - other.z
	)

	operator fun plus(other: Point3) = Point3(
		x + other.x,
		y + other.y,
		z + other.z
	)

	companion object {
		fun parse(s: String): Point3 = s.split(",", limit = 3).map(String::toInt).let { (x, y, z) ->
			Point3(x, y, z)
		}

		fun units() = sequence<Point3> {
			yield(Point3(1, 0, 0))
			yield(Point3(0, 1, 0))
			yield(Point3(0, 0, 1))
			yield(Point3(-1, 0, 0))
			yield(Point3(0, -1, 0))
			yield(Point3(0, 0, -1))
		}
	}
}

/**
 * if a unit vec, which axis is it
 * x -> 0, y -> 1, z -> 2
 */
fun Point3.axis(): Int = when {
	x != 0 -> 0
	y != 0 -> 1
	z != 0 -> 2
	else -> throw IllegalArgumentException("Must be a unit vec")
}

fun Point3.manhattanTo(other: Point3): Int = abs(x - other.x) + abs(y - other.y) + abs(z - other.z)
