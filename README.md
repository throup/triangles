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
    }
}
```

A `Triangle` object may be constructed with 3 `double` parameters (or anything
implictly convertable) representing the three side lengths.
`Triangle.classify()` will return an `Triangle.Type` from the following list:
 * `Triangle.Type.EQUILATERAL`
 * `Triangle.Type.ISOSCELES`
 * `Triangle.Type.SCALENE`

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
$ mvn jetty:run-war
```

This should lead to the application running on http://localhost:8080/ .

## Development
The project includes a full set of JUnit tests and Cucumber features. To execute the full test suite, you may use Maven:

```
$ mvn test
```

To compile and package as a WAR package:

```
$ mvn package
```