set PUBLIC_PATH=C:\Users\Public
set PROJECT_NAME=stock-mngt

wmic process where "name like 'java.exe'" delete

del %HOMEDRIVE%%HOMEPATH%\Desktop\Estoque.lnk

set HOME=%PUBLIC_PATH%\%PROJECT_NAME%\git\home
set "MSYSTEM=MINGW64"
start %PUBLIC_PATH%\%PROJECT_NAME%\git\usr\bin\mintty /bin/bash -l -e '%~dsp0/assets/run-from-bash.sh'

exit 0