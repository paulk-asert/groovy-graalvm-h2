# groovy-graalvm-h2

## Setup

Install GraalVM (shown using [sdkman](https://sdkman.io/) for Unix-like systems):

```
$ sdk install java 22.2.r17-grl

$ sdk use  java 22.2.r17-grl

$ gu install native-image
```

But see commented out sections in the `build.gradle` file if you want to use toolchains. 

## Running the application using "normal" Java

Create and run the application using:

```
$ ./gradlew run
```

## Running as a native application

Create and run the application natively using:

```
$ ./gradlew nativeRun
```

Once built, you can run it directly:

```
$ time build/native/nativeCompile/H2Demo 
Substrate VM, GraalVM 22.2.0 Java 17 CE, Oracle Corporation
[ID:1, NAME:Lord Archimonde]
[ID:2, NAME:Arthur]
[ID:3, NAME:Gilbert]
[ID:4, NAME:Grug]

real	0m0.026s
user	0m0.020s
sys	0m0.000s
```