package com.jessecorbett.rectangle

import org.junit.jupiter.api.Test
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PointTests {
    // .below tests
    @Test
    fun below() {
        val point = Point(Random().nextInt(), 5)
        val other = Point(Random().nextInt(), 0)

        assertTrue(other below point)
    }

    @Test
    fun `equal y counts as below`() {
        val point = Point(Random().nextInt(), 5)
        val other = Point(Random().nextInt(), 5)

        assertTrue(other below point)
    }

    @Test
    fun `not below`() {
        val point = Point(Random().nextInt(), 5)
        val other = Point(Random().nextInt(), 10)

        assertFalse(other below point)
    }

    // .above tests
    @Test
    fun above() {
        val point = Point(Random().nextInt(), 5)
        val other = Point(Random().nextInt(), 10)

        assertTrue(other above point)
    }

    @Test
    fun `equal y counts as above`() {
        val point = Point(Random().nextInt(), 5)
        val other = Point(Random().nextInt(), 5)

        assertTrue(other above point)
    }

    @Test
    fun `not above`() {
        val point = Point(Random().nextInt(), 5)
        val other = Point(Random().nextInt(), 0)

        assertFalse(other above point)
    }

    // .leftOf tests
    @Test
    fun left() {
        val point = Point(5, Random().nextInt())
        val other = Point(0, Random().nextInt())

        assertTrue(other leftOf point)
    }

    @Test
    fun `equal x counts as left`() {
        val point = Point(5, Random().nextInt())
        val other = Point(5, Random().nextInt())

        assertTrue(other leftOf point)
    }

    @Test
    fun `not left`() {
        val point = Point(5, Random().nextInt())
        val other = Point(10, Random().nextInt())

        assertFalse(other leftOf point)
    }

    // .rightOf tests
    @Test
    fun right() {
        val point = Point(5, Random().nextInt())
        val other = Point(10, Random().nextInt())

        assertTrue(other rightOf point)
    }

    @Test
    fun `equal x counts as right`() {
        val point = Point(5, Random().nextInt())
        val other = Point(5, Random().nextInt())

        assertTrue(other rightOf point)
    }

    @Test
    fun `not right`() {
        val point = Point(5, Random().nextInt())
        val other = Point(0, Random().nextInt())

        assertFalse(other rightOf point)
    }

    // .connectingTo tests
    @Test
    fun `connectingTo retains point data`() {
        val point = Point(Random().nextInt(), Random().nextInt())
        val other = Point(Random().nextInt(), Random().nextInt())
        val line = point connectingTo other

        assertEquals(point, line.start)
        assertEquals(other, line.end)
    }
}
