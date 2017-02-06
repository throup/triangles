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