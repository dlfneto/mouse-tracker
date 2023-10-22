JAVAC=javac
BIN=./bin
SRC=./src

all: compile

compile:
	javac -d $(BIN) -cp $(SRC) $(SRC)/Main.java

jar:    
	@echo "Manifest-Version: 1.0" > Manifest.txt
	@echo "Class-Path: ." >> Manifest.txt
	@echo "Main-Class: Main" >> Manifest.txt
	@echo "" >> Manifest.txt

	jar -cmf Manifest.txt MouseTracker.jar -C $(BIN) .

clean:
	rm -f *.class
	rm manifest.txt