run-dist:
	./build/install/app/bin/app
.PHONY: build
build:
	gradle clean
	gradle installDist
	gradle test
	gradle checkstyleMain
report:
	@./gradlew jacocoTestReport