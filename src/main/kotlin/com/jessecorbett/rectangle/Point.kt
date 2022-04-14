package com.jessecorbett.rectangle

/**
 * Entity representing a point in space
 *
 * @property x X coordinate
 * @property y Y coordinate
 */
data class Point(val x: Int, val y: Int) {
    /**
     * Checks whether another point is below or level with this point
     */
    infix fun below(other: Point): Boolean {
        return y <= other.y
    }

    /**
     * Checks whether another point is above or level with this point
     */
    infix fun above(other: Point): Boolean {
        return y >= other.y
    }

    /**
     * Checks whether another point is left of or level with this point
     */
    infix fun leftOf(other: Point): Boolean {
        return x <= other.x
    }

    /**
     * Checks whether another point is right of or level with this point
     */
    infix fun rightOf(other: Point): Boolean {
        return x >= other.x
    }

    /**
     * Creates a line from this point and another
     */
    infix fun connectingTo(other: Point): Line {
        return Line(this, other)
    }
}
