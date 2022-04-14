package com.jessecorbett.rectangle

/**
 * Rectangle entity with points defined in clockwise order
 */
data class Rectangle(
    val topLeft: Point,
    val topRight: Point,
    val bottomRight: Point,
    val bottomLeft: Point
) {

    /**
     * Set of all corners belonging to this rectangle
     */
    val corners: Set<Point>
        get() = setOf(topLeft, topRight, bottomRight, bottomLeft)

    /**
     * Set of lines constructed from the corners of the rectangle
     */
    val edges: Set<Line>
        get() = setOf(
            topLeft connectingTo topRight,
            bottomLeft connectingTo topLeft,
            bottomLeft connectingTo bottomRight,
            bottomRight connectingTo topRight
        )

    /**
     * Checks whether all corners of another rectangle are inside the corners of this one
     *
     * Note: a performance increase would be to check only the outer bounds of each relevant point
     * but this is more legible and int comparisons are already really fast so gain is minimal
     */
    operator fun contains(other: Rectangle): Boolean {
        return other.corners.all { point ->
            topLeft above point && topLeft leftOf point
                    && topRight above point && topRight rightOf point
                    && bottomRight below point && bottomRight rightOf point
                    && bottomLeft below point && bottomLeft leftOf point
        }
    }

    /**
     * Checks whether this rectangle and another intersect
     *
     * @return the list of intersection points, or an empty list if there is no intersections
     */
    fun intersections(other: Rectangle): List<Point> {
        return edges.flatMap { line -> other.edges.mapNotNull { line.intersects(it) } }.distinct()
    }

    /**
     * Checks whether this rectangle and another are adjacent, having any overlapping edges
     */
    fun adjacent(other: Rectangle): Boolean {
        return edges.any { line -> other.edges.any { line.overlaps(it) } }
    }
}
