Set ArgObj = WScript.Arguments
path = ArgObj(0)
zip = ArgObj(1)

Set objShell = CreateObject( "Shell.Application" )

Set objSource = objShell.NameSpace(path & zip).Items()
Set objTarget = objShell.NameSpace(path)

intOptions = 256
objTarget.CopyHere objSource, intOptions

