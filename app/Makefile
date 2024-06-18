run-dist:
	./build/install/app/bin/app

help:
	./build/install/app/bin/app -h

lint:
	./gradlew checkstyleMain

install:
	./gradlew clean install

build:
	./gradlew clean build

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

preset:
	./build/install/app/bin/app -f json src/test/resources/file1.json src/test/resources/file2.json

.PHONY: build

