run-dist:
	./build/install/app/bin/app

lint:
	./gradlew checkstyleMain

build:
	./gradlew clean build

test:
	./gradlew test

report:
	make -C app report

.PHONY: build
