# Pet Management Exercise

## Omschrijving

In deze oefening gaan we een  **Pet Management System** bouwen met behulp van **Spring Boot**. 
Het systeem biedt een reeks REST endpoints waarmee je virtuele huisdieren kan verzorgen.
Je kunt een huisdier aanmaken, met het huisdier spelen, het voeden en de status opvragen. 
Daarnaast leer je over **validatie**, **exception handling**, de **Java Streaming API** en het schrijven van **unit tests**.

### Functionaliteiten

1. **Een huisdier aanmaken**: Via een POST-request kan een gebruiker een huisdier aanmaken door de naam en het type (hond, kat, ...) met te geven in de request body. De naam moet minstens 2
karakters lang zijn. Het type is verplicht.
2. **Spelen met het huisdier**: Door met het huisdier te spelen, verliest het energie maar wordt het gelukkiger. Katten worden sneller moe dan honden.
3. **Het huisdier voeren**: Voer je een huisdier met het juiste voedsel, dan neemt de energie toe en vermindert de honger. Huisdieren kunnen allergisch zijn voor bepaalde voedingsmiddelen.
4. **Status opvragen**: Je kunt op elk moment de status van een huisdier opvragen.
5. **Stream API voorbeelden**: Met de Stream API filteren we huisdieren die energiek of hongerig zijn.

---

## Onderwerpen

### 1. Validatie en Exception Handling

**Validatie** is een essentieel onderdeel van elke API. In deze oefening gebruiken we Spring's validatiemechanismen om te controleren of de input correct is. Bijvoorbeeld, de naam van het huisdier mag niet leeg zijn. Dit doen we met annotaties zoals `@NotBlank`.

Daarnaast leren we hoe we **exceptions** kunnen afhandelen. Spring Boot maakt het eenvoudig om uitzonderingen te gooien en te beheren met behulp van annotaties zoals `@ResponseStatus`. We maken bijvoorbeeld gebruik van:

- **PetTooTiredException**: Een checked exception die gegooid wordt als een huisdier te moe is om te spelen.
- **WrongFoodException**: Een unchecked exception die gegooid wordt als het huisdier allergisch is voor het voedsel.

### 2. Java Streaming API
De Streaming API in Java maakt het eenvoudig om complexe bewerkingen op collecties uit te voeren, zoals filteren en transformeren. In deze oefening gebruiken we de Streaming API om een lijst van huisdieren te filteren en te transformeren.

```
List<Student> students = Arrays.asList(
    new Student("Alice", 22),
    new Student("Bob", 20),
    new Student("Charlie", 23)
);

// Filteren van studenten ouder dan 21 zonder lambdas
List<Student> filteredStudents = students.stream()
    .filter(new Predicate<Student>() {
        @Override
        public boolean test(Student student) {
            return student.getAge() > 21;
        }
    })
    .toList();
```

Met een lambda-expressies kunnen we de code veel leesbaarder en korter maken:

```
List<Student> students = Arrays.asList(
    new Student("Alice", 22),
    new Student("Bob", 20),
    new Student("Charlie", 23)
);

// Filteren en transformeren met lambdas
List<String> namesOfOlderStudents = students.stream()
    .filter(student -> student.getAge() > 21)
    .map(Student::getName)
    .toList();

System.out.println(namesOfOlderStudents);  // Output: [Alice, Charlie]
```

### 3. Unit Tests Schrijven
Het schrijven van unit tests is essentieel voor het waarborgen van de kwaliteit van je code. In deze oefening schrijven we tests voor de klasse Pet. We gebruiken JUnit 5 om te testen of de methoden correct werken en of uitzonderingen correct worden gegooid.
