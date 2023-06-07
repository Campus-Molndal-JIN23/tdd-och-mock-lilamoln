[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/-Un0hjO8)
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-7f7980b617ed060a017424585567c406b6ee15c891e84e1186181d67ecf80aa0.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=11285012)
# TDD Mockito WeatherService

## Description
JUnit tests for WeatherService using Mockito to mock a API call.

## Installation
Built with IntelliJ. maven and Java 19. Maven will download all dependencies.

## Usage
Run the tests in the test folder weather package.

## Credits
Third party assets
* [junit jupiter 5](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter/)
* [mockito core](https://mvnrepository.com/artifact/org.mockito/mockito-core/)
* [json](https://mvnrepository.com/artifact/org.json/json/)
* [jackson core](https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core)

* [ChatGPT](https://chat.openai.com/) for the formatting of a .md-table

## Test report
JDK 19, Junit 5.9.3, Mockito 5.3.1, Maven 4.0.0,
IntelliJ 2023.1.2 (Ultimate Edition)

| Test ID | Description                                        | Test Method           | Test Data      | Expected Result                          | Actual Result                            | Pass/Fail |
|---------|----------------------------------------------------|-----------------------|----------------|------------------------------------------|------------------------------------------|-----------|
| 1       | Get weather data for valid city                    | getWeatherValidCity   | "Gothenburg"   | Weather object with correct data         | Weather object with correct data         | <span style="color:green">Pass</span>       |
| 2       | Get coordinates for valid city                     | getCoordValidCity     | "Gothenburg"   | Coordinates object with correct data     | Coordinates object with correct data     | <span style="color:green">Pass</span>       |
| 3       | Get weather data for invalid city                  | getWeatherInvalidCity | "Narnia"       | Throws exception                         | Throws exception                         | <span style="color:green">Pass</span>       |
| 4       | Get coordinates for invalid city                   | getCoordInvalidCity   | "Narnia"       | Throws exception                         | Throws exception                         | <span style="color:green">Pass</span>       |
| 5       | Get weather data for city with special characters  | getWeatherSpecialCity | "Göteborg"     | Weather object with correct data         | Weather object with correct data         | <span style="color:green">Pass</span>       |
| 6       | Get coordinates for city with special characters   | getCoordSpecialCity   | "Göteborg"     | Coordinates object with correct data     | Coordinates object with correct data     | <span style="color:green">Pass</span>       |
| 7       | Get weather data with empty string                 | getWeatherEmptyString | ""             | Throws exception                         | Throws exception                         | <span style="color:green">Pass</span>       |
| 8       | Get coordinates with empty string                  | getCoordEmptyString   | ""             | Throws exception                         | Throws exception                         | <span style="color:green">Pass</span>       |
| 9       | Get weather data with null                         | getWeatherNull        | null           | Throws exception                         | Throws exception                         | <span style="color:green">Pass</span>       |
| 10      | Get coordinates with null                          | getCoordNull          | null           | Throws exception                         | Throws exception                         | <span style="color:green">Pass</span>       |
| 11      | Get weather data within 2 seconds                  | getWeatherTimeout     | "Gothenburg"   | Weather object with correct data         | Weather object with correct data         | <span style="color:green">Pass</span>       |

### Test results
All tests passed. 

Note: Tests performed with Mockito used to mock the API call (JSONGetter dependency). The API call is not tested.

## TDD & mock 
Tdd är en metod där test till koden skrivs före koden. Detta gör att en kan vara säker på att koden uppfyller de krav som finns på koden (så länge testerna är skrivna såpass omfattande att de svarar upp mot kraven på koden).

Mocking i tester är bra för att avlasta externa resurser vid testning. Det gör att man kan frikoppla kodens beroenden av exempelvis API:er, databaser eller andra resurser. Dels som sagt för att avlasta (t.ex. API:er), inte pajja grejer man inte borde röra (databaser) och säkerställa att fel inte finns i den egna koden - ligger felet externt får man lösa det på något annat vis men då vet man att den "egna" koden fungerar i alla fall.
