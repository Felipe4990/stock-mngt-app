#!/bin/bash

PUBLIC_PATH="/c/Users/Public"
PROJECT_NAME=stock-mngt

wmic process where "name like 'java.exe'" delete

mkdir -p $PUBLIC_PATH/$PROJECT_NAME/log
JAVA_HOME="$PUBLIC_PATH/$PROJECT_NAME/jdk-21"; PATH=$PATH:$JAVA_HOME/bin; echo $PATH; nohup java \
    -jar $PUBLIC_PATH/$PROJECT_NAME/controle-estoque-app.jar --spring.config.location=$PUBLIC_PATH/$PROJECT_NAME/resources/application.yaml > $PUBLIC_PATH/$PROJECT_NAME/log/output.log 2>&1 &

cp $(pwd)/assets/create-shortcut.bat $PUBLIC_PATH/$PROJECT_NAME
chmod +x $PUBLIC_PATH/$PROJECT_NAME/create-shortcut.bat
$PUBLIC_PATH/$PROJECT_NAME/create-shortcut.bat