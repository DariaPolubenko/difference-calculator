run-dist:
	make -C app run-dist

lint:
	make -C app lint

build:
	make -C app build

test:
	make -C app test

report:
	make -C app report

.PHONY: build
