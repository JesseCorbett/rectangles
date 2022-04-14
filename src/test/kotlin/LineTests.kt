import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class LineTests {
    @Test
    fun `horizontal and vertical`() {
        val hLine = Line(Point(0, 0), Point(10, 0))
        assertTrue(hLine.horizontal)
        assertFalse(hLine.vertical)

        val vLine = Line(Point(0, 0), Point(0, 10))
        assertTrue(vLine.vertical)
        assertFalse(vLine.horizontal)
    }

    // .contains tests
    @Test
    fun `horizontal lines inner contains`() {
        val line = Line(Point(0, 0), Point(10, 0))
        val other = Line(Point(2, 0), Point(8, 0))
        assertTrue(other in line)
    }

    @Test
    fun `horizontal lines equals contains`() {
        val line = Line(Point(0, 0), Point(10, 0))
        val other = Line(Point(0, 0), Point(10, 0))
        assertEquals(other, line)
        assertTrue(other in line)
    }

    @Test
    fun `horizontal lines overlaps not contains`() {
        val line = Line(Point(0, 0), Point(10, 0))
        val other = Line(Point(5, 0), Point(15, 0))
        assertTrue(line.overlaps(other))
        assertFalse(other in line)
    }

    // .parallelTo tests
    @Test
    fun `parallel horizontal`() {
        val line = Line(Point(0, 0), Point(10, 0))
        val other = Line(Point(5, 5), Point(15, 5))
        assertTrue(line parallelTo other)
    }

    @Test
    fun `parallel vertical`() {
        val line = Line(Point(0, 0), Point(10, 8))
        val other = Line(Point(0, 5), Point(10, 10))
        assertTrue(line parallelTo other)
    }

    // .overlaps tests
    @Test
    fun `inner lines overlap`() {
        val line = Line(Point(0, 0), Point(0, 8))
        val other = Line(Point(0, 2), Point(0, 8))
        assertTrue(other overlaps line)
    }

    @Test
    fun `equal lines overlap`() {
        val line = Line(Point(0, 0), Point(0, 8))
        val other = Line(Point(0, 0), Point(0, 8))
        assertTrue(other overlaps line)
    }

    @Test
    fun `partial overlap lines overlap`() {
        val line = Line(Point(0, 0), Point(6, 0))
        val other = Line(Point(4, 0), Point(10, 0))
        assertTrue(other overlaps line)
    }

    // .intersects tests
    @Test
    fun `crossing lines intersect`() {
        val line = Line(Point(0, 5), Point(10, 5))
        val other = Line(Point(5, 0), Point(5, 10))
        val intersection = other intersects line
        assertNotNull(intersection)
        assertEquals(5, intersection.x)
        assertEquals(5, intersection.y)
    }

    @Test
    fun `meeting lines intersect`() {
        val line = Line(Point(0, 0), Point(10, 0))
        val other = Line(Point(5, 0), Point(5, 10))
        val intersection = other intersects line
        assertNotNull(intersection)
        assertEquals(5, intersection.x)
        assertEquals(0, intersection.y)
    }
}
