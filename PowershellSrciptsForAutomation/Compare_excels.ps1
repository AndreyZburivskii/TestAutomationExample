
# compare to excel sheets(reports)

Function ExcelCompare ($FileName1,$SheetName1,$FileName2,$SheetName2)
{
	$config1 = Import-LocalizedData -BaseDirectory "C:\iosight\"  -FileName Main-Config.psd1
	. c:\iosight\Utils\Logger.ps1


	if ($FileName1 -eq "") 
	{
		throw "Please provide path to the Excel file"
		return
	}

	if (-not (Test-Path $FileName1))
	{
		throw "Path '$FileName1' does not exist."
        return

	}
	$objExcel1 = New-Object -ComObject Excel.Application
	$objExcel2 = New-Object -ComObject Excel.Application
	$objExcel1.Visible = $false
	$objExcel2.Visible = $false
	

	$FileName1 = Resolve-Path $FileName1
	$FileName2 = Resolve-Path $FileName2


	$Workbook1 = $objExcel1.workbooks.open($FileName1)
	$Workbook2 = $objExcel2.workbooks.open($FileName2) 
	


	if (-not $SheetName1) 
	{

		Logwrite -logstring "Defaulting to the first worksheet in workbook."
        $Worksheet1 = $Workbook1.Worksheets.Item(1)
		$SheetName1 = $Worksheet1.Name
	}
	else
	{
		$Worksheet1 = $Workbook1.Sheets.Item($SheetName1)

	}

	if (-not $SheetName2) 
	{
		
		Logwrite -logstring "Defaulting to the first worksheet in workbook."
        $Worksheet2 = $Workbook2.Worksheets.Item(1)
		$SheetName2 = $Worksheet2.Name
	} 
	else 
	{
		$Worksheet2 = $Workbook2.Sheets.Item($SheetName2)
	
	}
	
  
	$columns = $Worksheet1.range("A6:Z91").currentregion.Columns.count
	$lines = $Worksheet1.UsedRange.Rows.Count
  
	Logwrite -logstring "File $FileName1 Worksheet $SheetName1 contains $columns columns and $lines lines of data"
    $LASTEXITCODE = 0

	for ($line=5; $line -le $lines; $line++)
	{
		for ($column=1; $column -le $columns; $column++)
		{
			if($Worksheet1.Cells.Item($line,$column).Value() -ne $Worksheet2.Cells.Item($line,$column).Value())
			{
				$NoMatch = "Line " + $line + " Column " + $column + " NOT Matched in " + $FileName1
                LogWrite -logpath $config1.LogFile -logstring $NoMatch
                $LASTEXITCODE = 1
				
			}
        
			
		}
	}
	$End= "Finished checking " + $lines + " rows and " + $columns + " columns in " + $FileName1
    Logwrite -logstring $end
    $Workbook2.Close()
	$Workbook1.Close()
	$objExcel1.Quit()
	$objExcel2.Quit()
    taskkill /F /IM excel.exe
    exit $LASTEXITCODE

	
}