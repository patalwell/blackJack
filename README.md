# BlackJack Simulator

Synopsis: This application allows the user to run a BlackJack simulator.

Deploying The Application as a Jar in Unix/Linux based systems:

1. Download the provided zip file and unzip it's contents
2. Create a parent directory called Development/ in your home directory and add a subdirectory called blackJack `mkdir ~/Development` `mkdir ~/Development/blackJack`
3. Navigate to your new project directory `cd ~/Development/blackJack`
4. Copy the `src` directory for the Java source code from your Downloads directory into the blackJack directory e.g. `cp -R ~/Downloads/src ~/Development/blackJack`
5. Create a build directory to house our binaries `mkdir build`
6. Prior to compiling our classes let's add our `com.palwell.games.utils` package to our class path. Type `CLASSPATH=.:~/Development/blackJack/src/` in the console and then `export CLASSPATH`. Running `echo $CLASSPATH` should reveal the class path we just configured.
7. Compile our utility classes and place the class files in our build directory by running `javac -d build/ src/com/palwell/games/util/*.java`
8. Compile our driver and place the class files in our build directory by running `javac -d build/ src/com/palwell/games/*.java`
9. Create a distribution directory for the  java archive (JAR) file we are about to make `mkdir dist`.
10. Navigate to our build directory `cd build`
8. Create a manifest file in our build directory so the compiler knows where our driver (main class) lives `vi manifest.txt`. Add the following entry `Main-Class: com.palwell.games.BlackJack`. Be sure to hit return after the line as the java CLI tools will expect a carriage or newline character at the end of the line.
9. Now that we have a manifest file we can run `jar -cfmv ~/Development/blackJack/dist/blackJack.jar manifest.txt com/palwell/games/` to create an executable jar.
10. You should now be able to run the application by submitting the following command `java -jar ~/Development/blackJack/dist/blackJack.jar`.
