# Рефакторинг проекта Калькулятор согласно принципам SOLID

## S - Single Responsibility Principle (Принцип единственной ответственности)

В контроллере создаю:
- контроллер для бинарного калькулятора BinaryController
- контроллер для калькулятора списков ListController
- контроллер приложения AppController
## O - Open Closed Principle (Принцип открытости/закрытости)

В моделе расширяю класс Calculator классом ListCalculator

## L - Liskov’s Substitution Principle (Принцип подстановки Барбары Лисков)

В моделе класс ListCalculator является наследником класса Calculator, но расширяемые им методы sum, product, div возвращают тот же тип Double

## I - Interface Segregation Principle (Принцип разделения интерфейса)

В моделе, разделяю интерфейс Calculator на:
- общее свойство iCalculator
- интерфейс реализующий бинарный калькулятор iBinaryCalculator
- интерфейс реализующий калькулятор списков iListCalculator

## D - Dependency Inversion Principle (Принцип инверсии зависимостей)

Классы контроллеры Binarycontroller и ListController не зависят от конкретных реализаций модели и вьювера.
А класс AppController в свою очередь не зависит от конкретных реализаций BinaryController и ListController