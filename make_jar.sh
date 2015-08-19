#!/bin/bash

if (( $# != 1 ))
then
    echo "Usage: make_jar <main_class>"
    exit
fi

MAIN_CLASS=$1
DATE=$(date +"%Y%m%d%H%M")
JAR_DIR=./jar_$DATE
CURRENT_DIR="$(pwd)"
DIST_DIR=$CURRENT_DIR/dist
JAR_FILE=$DIST_DIR/kbase-enigma-metals-0.1.jar
SRC_DIR=./src
LIB_DIR=/kb/deployment/lib/jars
CLASSES_DIR=$JAR_DIR
CLASSPATH="-classpath $LIB_DIR/apache_commons/commons-cli-1.2.jar:$LIB_DIR/ini4j/ini4j-0.5.2.jar:$LIB_DIR/jackson/jackson-annotations-2.2.3.jar:$LIB_DIR/jackson/jackson-core-2.2.3.jar:$LIB_DIR/jackson/jackson-databind-2.2.3.jar:$LIB_DIR/jetty/jetty-all-7.0.0.jar:$LIB_DIR/jna/jna-3.4.0.jar:$LIB_DIR/kbase/auth/kbase-auth-0.3.1.jar:$LIB_DIR/kbase/common/kbase-common-0.0.10.jar:$LIB_DIR/servlet/servlet-api-2.5.jar:$LIB_DIR/syslog4j/syslog4j-0.9.46.jar:$LIB_DIR/kbase/workspace/WorkspaceClient-0.2.0.jar"

test -d "$DIST_DIR" || mkdir "$DIST_DIR"

mkdir $JAR_DIR

JAVA_FILE=${MAIN_CLASS//\./\/}
javac -sourcepath $SRC_DIR $CLASSPATH -d $JAR_DIR -g $SRC_DIR/$JAVA_FILE.java


cat > $JAR_DIR/Manifest.txt <<EOF
Main-Class: $MAIN_CLASS
Class-Path: $LIB_DIR/apache_commons/commons-cli-1.2.jar $LIB_DIR/ini4j/ini4j-0.5.2.jar
 $LIB_DIR/jackson/jackson-annotations-2.2.3.jar $LIB_DIR/jackson/jackson-core-2.2.3.jar
 $LIB_DIR/jackson/jackson-databind-2.2.3.jar $LIB_DIR/jetty/jetty-all-7.0.0.jar 
 $LIB_DIR/jna/jna-3.4.0.jar $LIB_DIR/kbase/auth/kbase-auth-0.3.1.jar 
 $LIB_DIR/kbase/common/kbase-common-0.0.10.jar $LIB_DIR/servlet/servlet-api-2.5.jar
 $LIB_DIR/syslog4j/syslog4j-0.9.46.jar $LIB_DIR/kbase/workspace/WorkspaceClient-0.2.0.jar
EOF


if [ -f $JAR_FILE ]
then
    rm $JAR_FILE
fi

cd $JAR_DIR
jar cfm $JAR_FILE Manifest.txt *

cd ..
rm -rf $JAR_DIR


