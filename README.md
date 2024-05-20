# stock-mngt-app

@echo off
cls
set home=echo %cd%

java -jar %home%/controle-estoque-app-0.0.1-SNAPSHOT.jar --spring.config.location=src/main/java/resources/application.yaml