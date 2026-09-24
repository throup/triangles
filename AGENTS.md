# AGENTS.md

## Before review

A change must pass this command, run from the repository root on JDK 25:

```
./mvnw -B clean verify
```

It compiles, runs the JUnit tests and the Cucumber scenarios in
`src/test/resources/features`, and writes the JaCoCo report. Use the wrapper;
the build does not rely on a Maven installation.

## Tickets

Tickets for this repository are GitHub issues on
[`throup/triangles`](https://github.com/throup/triangles/issues).
