#!/bin/bash

PUBLIC_PATH="/c/Users/Public"
PROJECT_NAME=stock-mngt

wmic process where "name like 'java.exe'" delete
rm -rf $PUBLIC_PATH/$PROJECT_NAME
mkdir -p $PUBLIC_PATH/$PROJECT_NAME
curl https://download.java.net/openjdk/jdk21/ri/openjdk-21+35_windows-x64_bin.zip \
    -o $PUBLIC_PATH/$PROJECT_NAME/tmp.zip \
&& unzip $PUBLIC_PATH/$PROJECT_NAME/tmp.zip \
    -d $PUBLIC_PATH/$PROJECT_NAME \
&& rm -rf $PUBLIC_PATH/$PROJECT_NAME/tmp.zip
JAVA_HOME="$PUBLIC_PATH/$PROJECT_NAME/jdk-21"; PATH=$PATH:$JAVA_HOME/bin; echo $PATH; ./gradlew clean build
find "$(pwd)/build/libs/controle-estoque-app" \
    -type f \
    -print0 \
| xargs -0 mv -t $PUBLIC_PATH/$PROJECT_NAME
mv $PUBLIC_PATH/$PROJECT_NAME/controle-estoque-app $PUBLIC_PATH/$PROJECT_NAME/controle-estoque-app.jar
cp -r $(pwd)/src/main/resources $PUBLIC_PATH/$PROJECT_NAME
cp -r $(pwd)/front/ $PUBLIC_PATH/$PROJECT_NAME
rm -rf build
