#!/bin/sh

invalid_java_home() {
  echo "JAVA_HOME is not set or does not point to a valid JDK installation."
  echo "Please set JAVA_HOME to a valid JDK 8 installation."
  /usr/libexec/java_home -V
  exit 1
}

# Check JAVA_HOME environment variable is set and points to a valid JDK version 8 exactly
if [ -z "$JAVA_HOME" ]; then
  invalid_java_home
fi
if [ ! -f "$JAVA_HOME/bin/java" ]; then
  invalid_java_home
fi
if [ "$(java -version 2>&1 | grep 'version "1\.8\.' | wc -l)" -ne 1 ]; then
  invalid_java_home
fi
export PATH=$JAVA_HOME/bin:$PATH
mvn clean deploy