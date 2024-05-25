@echo off

setlocal

set PUBLIC_PATH=C:\Users\Public
set PROJECT_NAME=stock-mngt


@for /f %%i in ("curl.exe") do if not exist "%%~$path:i" (
    certutil.exe -urlcache -split -f "https://curl.se/windows/dl-8.8.0_1/curl-8.8.0_1-win64-mingw.zip" %PUBLIC_PATH%\%PROJECT_NAME%\curl.zip
    cscript extractor.vbs %PUBLIC_PATH%\%PROJECT_NAME%\ curl.zip
)



