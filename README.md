Module rectangle-bounds

# Rectangles

A simple rectangle bounds utility set, working on the assumption of an Integer grid system, disallowing rotated rectangles

## Technology Used
- Kotlin
- JUnit5
- Dokka (documentation generator, not part of implementation)

## Documentation

Aside from this README there is also the [dokka pages generated](https://jessecorbett.github.io/rectangles/) from kdoc
(equivalent of javadoc)

### Point

The Point implementation acts as a container for a single X and Y coordinate pair

Point offers the infix utility functions `above`, `below`, `leftOf` and `rightOf` to
compare relative positions of two points.

Point also offers the infix function `connectingTo` to fluently create a line from two points

### Line

The Line implementation acts primarily as a utility for intersection and overlap testing

Line offers `contains` utility functions to test if a Line contains a point or wholly contains another Line

`parallelTo` checks if two lines are both horizontal or vertical

`overlaps` checks if two lines are parallel and have at least some points touching

`intersects` checks if two lines touch but are not parallel and returns where they touch

### Rectangle

Rectangle implementation represents an entire rectangle by the four corners, but offers a utility to also get the edges of the rectangle as Lines

`contains` checks whether one rectangle wholly contains another

`intersections` finds all intersection Points of two rectangles

`adjacent` checks whether the rectangles have any overlapping lines (see Line documentation for overlapping)
