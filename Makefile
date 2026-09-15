.PHONY: run test

run:
	javac Main.java && java Main

test:
	javac Player.java PlayerTest.java && java -ea PlayerTest