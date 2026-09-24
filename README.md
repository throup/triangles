# Triangles

## Brief
Write a program that will determine the type of a triangle. It should take the
lengths of the triangle's three sides as input, and return whether the triangle
is equilateral, isosceles or scalene.We are looking for solutions that showcase
problem solving skills and structural considerations that can be applied to
larger and potentially more complex problem domains. Pay special attention to
tests, readability of code and error cases.

## How to use

### In Java code
The core functionality is implemented by the class
`eu.throup.triangles.domain.Triangle`. To use, simply instantiate a new
`Triangle` object and call its `classify()` method:

```java
import eu.throup.triangles.domain.Triangle;

class Example {
    public Example() {
        Triangle triangle = new Triangle(3, 4, 5);
        Triangle.Type result = triangle.classify();
        boolean rightAngled = triangle.isRightAngled();
    }
}
```

A `Triangle` object may be constructed with 3 `double` parameters (or anything
implictly convertable) representing the three side lengths.
`Triangle.classify()` will return an `Triangle.Type` from the following list:
 * `Triangle.Type.EQUILATERAL`
 * `Triangle.Type.ISOSCELES`
 * `Triangle.Type.SCALENE`

`Triangle.isRightAngled()` returns whether one of the triangle's angles is a
right angle. This is independent of `classify()`: a triangle with sides 3, 4
and 5 is scalene and right-angled, and one with sides 1, 1 and `Math.sqrt(2)`
is isosceles and right-angled. The longest side is compared with the length a
right angle would give it, and the two count as equal when they differ by less
than two units in the last place of a `double`. So the rounding in
`Math.sqrt(2)` does not prevent a match, while a side of `1.41421356` is not
right-angled. Because the tolerance is on length, not angle, a very thin
triangle can be reported as right-angled when it is not:
`3e-16, 1, 1.0000000000000002` has an angle of about 138°. A triangle with a
side of exactly zero length is never right-angled.

If invalid values are given in the constructor, an `IllegalArgumentException`
will be thrown during instantiation. The exception may take one of the
following specialisations:

| Exception                     | Reason                                                                                                              |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------|
| `ImpossibleTriangleException` | The given side lengths do not satisfy the [triangle inequality](https://en.wikipedia.org/wiki/Triangle_inequality). |
| `NegativeSideException`       | A given side length is negative.                                                                                    |
| `NonFiniteSideException`      | A given side length is infinite or not a number.                                                                    |

### As a web application
A simple web application can be deployed in the form of Java WAR package; for
example, running in Jetty or Tomcat.

A Maven goal exists to compile and launch the web application with Jetty:

```
$ ./mvnw jetty:run-war
```

This should lead to the application running on http://localhost:8080/ .
The page reports the classification, followed by "and right-angled" when the
triangle is right-angled; for example, "The triangle is scalene and
right-angled."

## Development
The project builds with JDK 25 through the Maven wrapper, so no Maven
installation is needed. The project includes a full set of JUnit tests and
Cucumber features. To execute the full test suite:

```
$ ./mvnw test
```

To compile and package as a WAR package:

```
$ ./mvnw package
```