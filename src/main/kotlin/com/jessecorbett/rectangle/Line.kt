package com.jessecorbett.rectangle

/**
 * Line entity with points defined as start and finish
 *
 * It is assumed that [start] is always a lower value than [end]
 *
 * @property start The starting point of the line
 * @property end The ending point of the line
 */
data class Line(
    val start: Point,
    val end: Point
) {
    /**
     * Whether the line is horizontal
     */
    val horizontal: Boolean
        get() = start.y == end.y

    /**
     * Whether the line is vertical
     */
    val vertical: Boolean
        get() = start.x == end.x

    /**
     * Computes if a point is on the line
     *
     * Uses the classic equation of y = mx + c and then checks the bounds of the points
     */
    operator fun contains(point: Point): Boolean {
        return if (horizontal) {
            point.y == start.y && point.x in start.x..end.x
        } else {
            point.x == start.x && point.y in start.y..end.y
        }
    }

    /**
     * Checks if this line entirely contains another line
     */
    operator fun contains(line: Line): Boolean {
        return line.start in this && line.end in this
    }

    /**
     * Checks if two lines are parallel
     *
     * Overlapping lines are considered parallel
     *
     * @return True if the lines have the same slope and are parallel
     */
    infix fun parallelTo(line: Line): Boolean {
        return vertical == line.vertical
    }

    /**
     * Checks if the two lines have any overlapping points and are parallel
     *
     * @return True if the lines are parallel and have any overlapping points
     */
    infix fun overlaps(line: Line): Boolean {
        return this parallelTo line && (line.start in this || line.end in this || this.start in line || this.end in line)
    }

    /**
     * Checks if the two lines have any overlapping points and are not parallel
     *
     * @return The intersection point or null if the lines don't intersect
     */
    infix fun intersects(line: Line): Point? {
        if (this parallelTo line) return null
        val lines = setOf(this, line)

        val h = lines.first { it.horizontal }
        val v = lines.first { it.vertical }

        val doesIntersect = v.start.x in h.start.x..h.end.x && h.start.y in v.start.y..v.end.y

        return if (doesIntersect) {
            Point(v.start.x, h.start.y)
        } else null
    }
}
