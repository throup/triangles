Feature: Classifying triangles
  As a user
  I want to input the sides of a triangle
  So that I can find out what type of triangle it is

  Scenario: Classifying an scalene triangle
    Given I have a triangle with no equal sides
     When I classify the triangle
     Then the result should be "scalene"

  Scenario: Classifying an isosceles triangle
    Given I have a triangle with two equal sides
     When I classify the triangle
     Then the result should be "isosceles"

  Scenario: Classifying an equilateral triangle
    Given I have a triangle with three equal sides
     When I classify the triangle
     Then the result should be "equilateral"

  Scenario: Classifying an impossible triangle
    Given I have a triangle which does not satisfy the triangle equalibrium
     When I classify the triangle
     Then there should be an error: "Side lengths do not make a real triangle."

  Scenario: Classifying a triangle with negative sides
    Given I have a triangle with negative side lengths
     When I classify the triangle
     Then there should be an error: "Side lengths must be positive."

  Scenario: Classifying a triangle with non-finite sides
    Given I have a triangle with non-finite side lengths
     When I classify the triangle
     Then there should be an error: "Side lengths must be finite numbers."