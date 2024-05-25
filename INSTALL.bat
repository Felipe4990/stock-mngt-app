set PUBLIC_PATH=C:\Users\Public
set PROJECT_NAME=stock-mngt

wmic process where "name like 'java.exe'" delete
wmic process where "name like 'mysqld.exe'" delete

del %HOMEDRIVE%%HOMEPATH%\Desktop\Estoque.lnk





@RD /S /Q "%PUBLIC_PATH%\%PROJECT_NAME%\"
mkdir %PUBLIC_PATH%\%PROJECT_NAME%

curl -L https://github.com/git-for-windows/git/releases/download/v2.45.1.windows.1/PortableGit-2.45.1-64-bit.7z.exe -o "%PUBLIC_PATH%\%PROJECT_NAME%\git.exe"

start /b /wait %PUBLIC_PATH%\%PROJECT_NAME%\git.exe -o %PUBLIC_PATH%\%PROJECT_NAME%\git -y

if not exist "%PUBLIC_PATH%\%PROJECT_NAME%\git\home\" mkdir %PUBLIC_PATH%\%PROJECT_NAME%\git\home\

del "%PUBLIC_PATH%\%PROJECT_NAME%\git.exe"

set HOME=%PUBLIC_PATH%\%PROJECT_NAME%\git\home
set "MSYSTEM=MINGW64"
start %PUBLIC_PATH%\%PROJECT_NAME%\git\usr\bin\mintty /bin/bash -l -e '%~dsp0/assets/install-from-bash.sh'

exit 0