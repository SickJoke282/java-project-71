run-dist:
	./build/install/app/bin/app

build:
	gradle clean
	gradle installDist
	gradle test
	gradle checkstyleMain

report:
	./gradlew jacocoTestReport

.DEFAULT_GOAL := build-run

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run:
	./gradlew run

test:
	./gradlew test

lint:
	./gradlew checkstyleMain checkstyleTest

update-deps:
	./gradlew useLatestVersions

build-run: build run

.PHONY: build
