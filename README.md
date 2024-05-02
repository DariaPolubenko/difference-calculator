[![Actions Status](https://github.com/DariaPolubenko/java-project-71/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/DariaPolubenko/java-project-71/actions)
[![Test Coverage](https://api.codeclimate.com/v1/badges/2e9106abf701b80f8eb4/test_coverage)](https://codeclimate.com/github/DariaPolubenko/java-project-71/test_coverage)
[![Maintainability](https://api.codeclimate.com/v1/badges/2e9106abf701b80f8eb4/maintainability)](https://codeclimate.com/github/DariaPolubenko/java-project-71/maintainability)
[![Action Test](https://github.com/DariaPolubenko/java-project-71/actions/workflows/main.yml/badge.svg)](https://github.com/DariaPolubenko/java-project-71/actions)


## Описание
**Differ** bla-bla-bla


## Установка
В консоль введите команду:
```bash
git clone git@github.com:DariaPolubenko/java-project-71.git
```


## Использование

### Для вывода справочной информации
Перейдите в поддиректорию проекта:
```bash
cd java-project-71/app
```

Введите следующую команду:
```bash
./build/install/app/bin/app -h
```
[![asciicast](https://asciinema.org/a/657385.svg)](https://asciinema.org/a/657385)



### Для сравнения двух файлов
Введите команду _./build/install/app/bin/app_ и укажите файлы, которые необходимо сравнить
```bash
./build/install/app/bin/app file1.json file2.json
```

**Сравнение файлов в формате .json**

[![asciicast](https://asciinema.org/a/657394.svg)](https://asciinema.org/a/657394)


**Сравнение файлов в формате .yml**

[![asciicast](https://asciinema.org/a/656766.svg)](https://asciinema.org/a/656766)



### Для вывода результата в формате _plain_ или _json_
Добавьте "-f plain" или "-f json" соответственно
```bash
./build/install/app/bin/app -f plain file1.json file2.json
```

**Вывод результата в форматах _stylish_ и _plain_** 

[![asciicast](https://asciinema.org/a/657005.svg)](https://asciinema.org/a/657005)

**Вывод результата в формате _json_** 

[![asciicast](https://asciinema.org/a/657254.svg)](https://asciinema.org/a/657254)


