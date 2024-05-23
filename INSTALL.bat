wmic process where "name like 'java.exe'" delete
wmic process where "name like 'mysqld.exe'" delete

del %HOMEDRIVE%%HOMEPATH%\Desktop\Estoque.lnk

@RD /S /Q "C:\Users\Public\stock-mngt\"
mkdir C:\Users\Public\stock-mngt

curl -L https://github.com/git-for-windows/git/releases/download/v2.45.1.windows.1/PortableGit-2.45.1-64-bit.7z.exe -o "C:\Users\Public\stock-mngt\git.exe"

start /b /wait C:\Users\Public\stock-mngt\git.exe -o C:\Users\Public\stock-mngt\git -y

if not exist "C:\Users\Public\stock-mngt\git\home\" mkdir C:\Users\Public\stock-mngt\git\home\

del "C:\Users\Public\stock-mngt\git.exe"

set HOME=C:\Users\Public\stock-mngt\git\home
set "MSYSTEM=MINGW64"
start C:\Users\Public\stock-mngt\git\usr\bin\mintty /bin/bash -l -e '%~dsp0/assets/install-from-bash.sh'

exit 0