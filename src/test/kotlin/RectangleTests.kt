import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RectangleTests {
    @Test
    fun `inner rectangle is contained`() {
        val outer = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val inner = Rectangle(
            Point(2, 8),
            Point(8, 8),
            Point(8, 2),
            Point(2, 2)
        )

        assertTrue(inner in outer)
    }

    @Test
    fun `outer rectangle is not contained`() {
        val inner = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val outer = Rectangle(
            Point(2, 8),
            Point(8, 8),
            Point(8, 2),
            Point(2, 2)
        )

        assertFalse(inner in outer)
    }

    @Test
    fun `equal rectangle is contained`() {
        val outer = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val inner = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )

        assertEquals(inner, outer)
        assertTrue(inner in outer)
    }

    @Test
    fun `overlapping rectangle is not contained`() {
        val outer = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val inner = Rectangle(
            Point(2, 12),
            Point(8, 12),
            Point(8, 2),
            Point(2, 2)
        )

        assertFalse(inner in outer)
    }

    // .intersections test
    @Test
    fun `overlapping rectangles have two intersections`() {
        val outer = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val inner = Rectangle(
            Point(2, 12),
            Point(8, 12),
            Point(8, 2),
            Point(2, 2)
        )

        val intersections = outer.intersections(inner)

        assertEquals(2, intersections.size)
        assertTrue(Point(2, 10) in intersections)
        assertTrue(Point(8, 10) in intersections)
    }

    @Test
    fun `equal rectangles have all four corners as intersections`() {
        val outer = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val inner = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )

        val intersections = outer.intersections(inner)

        assertEquals(4, intersections.size)
        assertTrue(outer.topLeft in intersections)
        assertTrue(outer.topRight in intersections)
        assertTrue(outer.bottomRight in intersections)
        assertTrue(outer.bottomLeft in intersections)
    }

    @Test
    fun `not touching rectangles have no intersections`() {
        val outer = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val inner = Rectangle(
            Point(20, 30),
            Point(30, 30),
            Point(30, 20),
            Point(20, 20)
        )

        val intersections = outer.intersections(inner)

        assertTrue(intersections.isEmpty())
    }

    // .adjacent tests
    @Test
    fun `touching sides is adjacent`() {
        val outer = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val inner = Rectangle(
            Point(10, 10),
            Point(20, 10),
            Point(20, 0),
            Point(10, 0)
        )

        assertTrue(outer.adjacent(inner))
    }

    @Test
    fun `touching sides inner rectangle is adjacent`() {
        val outer = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val inner = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )

        assertTrue(outer.adjacent(inner))
    }

    @Test
    fun `equal rectangles are adjacent`() {
        val outer = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val inner = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )

        assertEquals(outer, inner)
        assertTrue(outer.adjacent(inner))
    }

    @Test
    fun `non-touching sides are not adjacent`() {
        val outer = Rectangle(
            Point(0, 10),
            Point(10, 10),
            Point(10, 0),
            Point(0, 0)
        )
        val inner = Rectangle(
            Point(20, 10),
            Point(30, 10),
            Point(30, 0),
            Point(20, 0)
        )

        assertFalse(outer.adjacent(inner))
    }
}
