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

# Projektrapport
### Kristoffer Larsson

### Beskrivning av projektet
Ännu ett testprojekt där Mockito används för att mocka ett API och avlasta det under testning med JUnit.

## Arbetet och dess genomförande

### Vad som varit svårt
Att hantera JSON är alltid lite stökigt, men [JSONtoPOJO](https://json2csharp.com/code-converters/json-to-pojo) och [Jackson](https://github.com/FasterXML/jackson) är grymt.

### Beskriv lite olika lösningar du gjort
Se ovan, JSON genom Jackson blir en DAO som kan skickas vidare och plockas ur data ur.

## Slutsatser

### Vad gick bra
Fick ihop ett projekt och kunde testa det ganska så fort.

### Vad gick dåligt
I början var det lite stökigt att förstå vad i WeatherService som skulle testas, egentligen testades bara Mockito (dvs. får jag tillbaka strängen jag just skickade in i Mockito) men när jag insåg att jag var tvungen att fake:a en separat API-klass blev det rimligare (det stod inte i beskrivningen av uppgiften från början).

### Vad har du lärt dig
Att använda Mockito i praktiken.

### Vad hade ni gjort annorlunda om ni gjort om projektet
Hade antagligen velat ha in lite mer logik i WeatherService som hade varit roligare att testa.

### Vilka möjligheter ser du med de kunskaper du fått under kursen.
Att kunna testa program som jobbar mot API:er och databaser utan att belasta / vara beroende av dessa.
