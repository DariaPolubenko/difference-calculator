[![Actions Status](https://github.com/DariaPolubenko/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/DariaPolubenko/java-project-71/actions)
[![Test Coverage](https://api.codeclimate.com/v1/badges/2e9106abf701b80f8eb4/test_coverage)](https://codeclimate.com/github/DariaPolubenko/java-project-71/test_coverage)
[![Maintainability](https://api.codeclimate.com/v1/badges/2e9106abf701b80f8eb4/maintainability)](https://codeclimate.com/github/DariaPolubenko/java-project-71/maintainability)
[![Action Test](https://github.com/DariaPolubenko/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/DariaPolubenko/java-project-71/actions)


## Описание
**Differ - утилита:**
сравнивает файлы .JSON и .YML и выводит разницу в виде строки.
Утилита умеет работать с простыми и вложенными структурами, выводить результат в STYLISH (по умолчанию), PLAIN или JSON формате.
Данную утилиту также можно установить как зависимость и использовать в любом другом пакете.

### Технологический стек:
Java, Gradle, IntelliJ IDEA, Picocli, Jackson, JUnit, Checkstyle, Make,
Git, GitHub Actions (CI), Code Climate, Jacoco

## Установка
В консоль введите команду:
```bash
git clone git@github.com:DariaPolubenko/difference-calculator.git
```


## Использование

### Для вывода справочной информации
Введите следующие команды:
```bash
cd difference-calculator/app
make install
```

Затем введите команду:
```bash
./build/install/app/bin/app -h
```
[![asciicast](https://asciinema.org/a/657399.svg)](https://asciinema.org/a/657399)



### Для сравнения файлов
Введите команду _./build/install/app/bin/app_, укажите относительные или абсолютные пути до файлов, которые необходимо сравнить
```bash
./build/install/app/bin/app file1.json file2.json
```

_Сравнение файлов .json_

[![asciicast](https://asciinema.org/a/657400.svg)](https://asciinema.org/a/657400)


_Сравнение файлов .yml_

[![asciicast](https://asciinema.org/a/657401.svg)](https://asciinema.org/a/657401)


_Сравнение файлов с вложенной структурой_

[![asciicast](https://asciinema.org/a/657397.svg)](https://asciinema.org/a/657397)



### Для вывода результата в форматах _stylish_, _plain_ или _json_
Вывод автоматически выводится в формате _stylish_.
Чтобы изменить формат на _plain_ или _json_  добавьте "-f plain" или "-f json" соответственно
```bash
./build/install/app/bin/app -f plain file1.json file2.json
```

_Вывод результата в формате 'stylish'_

[![asciicast](https://asciinema.org/a/657402.svg)](https://asciinema.org/a/657402)

_Вывод результата в формате 'plain'_

[![asciicast](https://asciinema.org/a/657404.svg)](https://asciinema.org/a/657404)

_Вывод результата в формате 'json'_

[![asciicast](https://asciinema.org/a/657405.svg)](https://asciinema.org/a/657405)




