wmic process where "name like 'java.exe'" delete

del %HOMEDRIVE%%HOMEPATH%\Desktop\Estoque.lnk

set HOME=C:\Users\Public\stock-mngt\git\home
set "MSYSTEM=MINGW64"
start C:\Users\Public\stock-mngt\git\usr\bin\mintty /bin/bash -l -e '%~dsp0/assets/run-from-bash.sh'

exit 0