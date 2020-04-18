
#Check that downloded file exist

$d = Get-Date -format %d
$m = Get-Date -UFormat %m
$m = $m -as[int]
$y = Get-Date -UFormat %Y
$fileName= 'exported_'+$d+'.'+$m+'.'+$y

$fileName


$filePath = Get-ChildItem -Path C:\Users\company\Downloads -Recurse| where {$_.name -like $fileName+"*"} | % { $_.FullName }


$filePath

Test-Path -Path $filePath

Get-ChildItem -Path C:\Users\company\Downloads -Include * -File -Recurse | foreach { $_.Delete()}



