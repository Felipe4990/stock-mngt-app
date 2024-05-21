#!/bin/bash



#mkdir tmp; cd tmp
#echo $(pwd)
#curl https://download.java.net/openjdk/jdk21/ri/openjdk-21+35_windows-x64_bin.zip -o /tmp/tmp.zip && unzip /tmp/tmp.zip && rm /tmp/tmp.zip
$(pwd)/tmp/jdk-21/bin/java.exe -version

$(pwd)/tmp/jdk-21/bin/java.exe -jar %home%/controle-estoque-app-0.0.1-SNAPSHOT.jar --spring.config.location=src/main/java/resources/application.yaml

