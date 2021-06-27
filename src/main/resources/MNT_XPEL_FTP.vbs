'--------------------------------------------------------------------------- 
'-> Стартовая программа монитора связи с сервером FTP.XPEL.RU *** 14.01.2021 *** 
'-- *** КОРНЕВАЯ ПАПКА ПРОГРАММЫ    -> C:\Apps\Sprut4\XPEL_FTP     ( подсистема FTP-обмена с XPEL )
'-- ***          ПАПКА со скриптами -> C:\Apps\Sprut4\XPEL_FTP\PRG ( рабочие скрипты и копии рабочих программ )
'-- ***          ПАПКА с  архивами  -> C:\Apps\Sprut4\XPEL_FTP\ARX ( архивная папка, вложения - папки IN, OUT, BAD, PROCESSED ) 
'-- ***          РАБОЧАЯ ПАПКА      -> C:\Apps\Sprut4\XPEL_FTP\BOX ( буфер обмена,   вложения - папки IN, OUT, BAD, PROCESSED ) 
'-- ***          ЖУРНАЛЬНАЯ ПАПКА   -> C:\Apps\Sprut4\XPEL_FTP\LOG ( журналы FTP-сессий и общий журнал обработки заявок в ГС  )
'--------------------------------------------------------------------------    описание рабочих переменных
Dim objScr, objShl, objFSO,  dtNow, dtArx, dtDoc, arxMrk0, arxMrk1, objFolder, objFilelist, objFile, objSubFolderslist
Dim rs, objProcess, fs, ts
Dim wStr0, wStr1, wStr2 
Dim Ws0, Ws1, Ws2, Ws3 
Dim wi0, wi1  
Dim START_FLAG
Dim OraSession, OST1, OraDynaset, OraCLOB, buffer, amount_read, messages_id, messages_in, message_data, new_id   
'--------------------------------------------------------------------------    установка обработчика ошибок в режим перехода к очередному оператору
On Error Resume Next       
'--------------------------------------------------------------------------     Создание системных объектов 
Set objFSO = CreateObject("Scripting.FileSystemObject")
Set objShl = WScript.CreateObject("WScript.Shell")
'--------------------------------------------------------------------------    опредение пути к рабочей папке
	With  WScript
	  Ws0 = Mid( .ScriptFullName,1,instr(.ScriptFullName,.ScriptName) - 1 ) 
	End With
	Ws1 = Mid(Ws0,1, len(Ws0)- 1 )
'--------------------------------------------------------------------------    КОНТРОЛЬ ПОВТОРНОГО ЗАПУСКА   
wStr0 = "N"          '<- флажок повторного запуска монитора
Set objWMIService = GetObject("winmgmts:{impersonationLevel=impersonate}!\\.\root\cimv2")
Set colProcesses = objWMIService.ExecQuery("Select * from Win32_Process")
For Each objProcess in colProcesses   '<--- ЦИКЛ ПО СИСТЕМНЫМ ПРОЦЕССАМ !!! (анализ и защита от дублей процессов)
	' "ВНИМАНИЕ! Это для настроек ! -> MsgBox objProcess.CommandLine & " = " & objProcess.Name  & " = " & objProcess.ExecutablePath  
	If objProcess.Name = "MNT_XPEL_FTP.exe" and instr(objProcess.CommandLine, WScript.ScriptFullName) > 0 Then
		If wStr0 = "Y" Then
			rs = msgbox("ПАРАМЕТРЫ ПРОЦЕССА: " & chr(10) & chr(10) & " CommandLine -> " & objProcess.CommandLine & chr(10) & _
						" Process.Name -> " & objProcess.Name  & chr(10) & " ExecutablePath -> " & objProcess.ExecutablePath _
						& chr(10) & chr(10) & "ВЫ БУДЕТЕ ЗАПУСКАТЬ МОНИТОР ? " & chr(10) _
						, vbYesNo,"   ВНИМАНИЕ !!!  FTP-МОНИТОР << XPEL >> УЖЕ РАБОТАЕТ !!! ... " )
			If rs = vbNo Then    ' <- Отказ от запуска монитора ?
				Set objFile = Nothing
				Set objFolder = Nothing
				Set objFSO = Nothing
				Set objShl = Nothing
				Set objWMIService = Nothing
				Set colProcesses = Nothing
				Set objProcess = Nothing
				WScript.Quit
			End If
		Else
			wStr0 = "Y"
		End If
	Else
		If objProcess.Name = "cmd.exe" and instr(objProcess.CommandLine, "XPEL_FTP" ) > 0 Then
			objProcess.Terminate        '<- Завершение процесса  CMD 
		End If 
	End If
Next
'!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
'-> НАЧАЛО << БЕСКОНЕЧНОГО >> ЦИКЛА !!!
'!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
START_FLAG = "0"                         '<- Первоначальная инициализация стартового флажка монитора !!!
While True
'-> VVV <-----------------------------------------------< ПРОВЕРКА условий для работы монитора
	wStr0 = "C:\Apps\Sprut4\XPEL_FTP\PRG\XPEL_SCP.scr" 
	If ( START_FLAG = "1" ) and ( not objFSO.FileExists(wStr0) ) Then '<- МОНИТОР ДОЛЖЕН ЗАВЕРШИТСЯ ?
		Set objFile = Nothing
		Set objFolder = Nothing
		Set objFSO = Nothing
		Set objShl = Nothing
		Set objWMIService = Nothing
		Set colProcesses = Nothing
		Set objProcess = Nothing
		msgbox chr(10) & chr(10) & "   ВНИМАНИЕ !!! " & _ 
				chr(10) & chr(10) & " FTP-МОНИТОР << XPEL >> ЗАВЕРШАЕТ РАБОТУ " & _
				chr(10) & "ПО КОМАНДЕ АДМИНИСТРАТОРА !!! ... " & chr(10) & chr(10) 
		WScript.Quit
	Else
		objFSO.DeleteFile wStr0, force        '<- РАБОЧЕЕ УДАЛЕНИЕ WinSCP-скрипта для МОНИТОРА
	End If
'-> VVV <-----------------------------------------------< НАЧАЛО РАБОЧЕГО ЦИКЛА !!!
	START_FLAG = "1" 
'-> VVV <-----------------------------------------------< построение временной метки для рабочего журнала и архивов 
	dtNow = NOW
	dtLog = DateAdd("d", -5, NOW)    '<-=   УДАЛЕНИЕ ВСЕХ ЖУРНАЛОВ, КОТОРЫЕ СТАРШЕ  5  СУТОК 
	dtArx = DateAdd("d", -10, NOW)   '<-=   УДАЛЕНИЕ ВСЕХ АРХИВОВ, КОТОРЫЕ СТАРШЕ  10  СУТОК 
	dtDoc = DateAdd("d", -10, NOW)   '<-=   УДАЛЕНИЕ ВСЕХ ДОКУМЕНТОВ-СПРАВОК, КОТОРЫЕ СТАРШЕ  10  СУТОК 
	dt100 = DateAdd("s", -100, NOW)  '<-=   УДАЛЕНИЕ ВСЕХ файлов, КОТОРЫЕ СТАРШЕ  100  сек 
	arxMrk0 = CStr(Year(dtNow)) & Right("00" & CStr(Month(dtNow)), 2) & Right("00" & CStr(Day(dtNow)), 2)
	arxMrk1 = Right("00" & CStr(Hour(dtNow)), 2) & Right("00" & CStr(Minute(dtNow)), 2) & Right("00" & CStr(Second(dtNow)), 2) 
	arxMrk0 = arxMrk0 & arxMrk1
'-> VVV ==========================================  ВЫГРУЗКА XML-ПАКЕТОВ  ИЗ ТАБЛИЦЫ << KB_HKM_OUT >>  ДЛЯ ПЕРЕДАЧИ НА FTP-СЕРВЕР 
	Set OraSession  = CreateObject("OracleInProcServer.XOraSession")
	Set OST1 = OraSession.OpenDatabase("RIFDB_RW","SPRUT4/GUADERA",0)
'............................................................................-> Выборка пакета из БД
		Set OraDynaset = OST1.DbCreateDynaset( "SELECT * FROM KB_XPEL_OUT WHERE processing_date is Null and status = 'N' " ,0)
		while not OraDynaset.EOF
'............................................................................-> Выгрузка XML-пакета в файл
			Set OraCLOB = OraDynaset.Fields("xml_data").Value
				amount_read = OraCLOB.Read(buffer)
				Ws0 = "C:\Apps\Sprut4\XPEL_FTP\BOX\Out\" & OraDynaset.Fields("file_name").Value 
				OraCLOB.CopyToFile ws0
			Set OraCLOB = Nothing
			OraDynaset.MoveNext
		Wend
'............................................................................-> Отметка о выгрузке пакетов  	
		OST1.ExecuteSQL ( "UPDATE KB_XPEL_OUT SET processing_date = sysdate, status = 'S' WHERE processing_date is Null and status = 'N' " )  
'............................................................................-> Закрытие транзакции 	
	OraSession.CommitTrans  
'............................................................................-> Чистка системных объектных переменных
    Set OraDynaset = Nothing
    Set OST1 = Nothing
    Set OraSession = Nothing
'-> VVV <-----------------------------------------------< Подготовка сценария команд для клиента WinSCP 
   set fs = objFSO.OpenTextFile(wStr0, 2, 1) 
'                                            Открытие FTP-сессии
	   fs.WriteLine "option batch on"
	   fs.WriteLine "option confirm off" 
	   fs.WriteLine "open sftp://severtrans_it:SevTraIt20XX@176.118.31.139 -hostkey=""*"""
'                                            Прием  новых данных ( с УДАЛЕНИЕМ ! )   
'	   fs.WriteLine "cd /ftpserver/hellmann/prod/In"
'					     Change the working directory on the local computer to
'	   fs.WriteLine "lcd C:\Apps\Sprut4\XPEL_FTP\BOX\In" 
'	   fs.WriteLine "get -delete *.xml"
'                                            Передача данных (уведомлений)
	   fs.WriteLine "cd /Integration.V2/EXPELL/Outbound/Response"
	   fs.WriteLine "lcd C:\Apps\Sprut4\XPEL_FTP\BOX\Out"
	   fs.WriteLine "put *.xml" 
'                                            Закрытие сессии и завершение сеанса
	   fs.WriteLine "close" 
	   fs.WriteLine "exit" 
	   fs.Close 
	Set fs = Nothing
'-> VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV  <- Запускаем WinSCP-клиент с только что созданным сценарием 
'->
	objShl.Run "C:\Apps\Sprut4\SVT_FTP_MNT_ALL\PRG\WinSCP.exe /console /script=" & wStr0 _ 
	         & " /log=c:\Apps\Sprut4\XPEL_FTP\LOG\XPEL_SCP_" & arxMrk0 & ".log", 0 , True 
	WScript.Sleep 10000 				' <-  даём время для "сна" mlsek
'->
'-> VVV <-----------------------------------------------< копируем переданные xml-файлы в архив
	objFSO.CopyFile "C:\Apps\Sprut4\XPEL_FTP\BOX\Out\*.xml" , "C:\Apps\Sprut4\XPEL_FTP\ARX\Out" , OverwriteExisting
	objFSO.CopyFile "C:\Apps\Sprut4\XPEL_FTP\BOX\Bad\*.xml" , "C:\Apps\Sprut4\XPEL_FTP\ARX\Bad" , OverwriteExisting
'-> VVV <-----------------------------------------------< удаляем из выходных буферов xml-файлы сохраненные в архиве
	objFSO.DeleteFile "C:\Apps\Sprut4\XPEL_FTP\BOX\Out\*.xml",force
	objFSO.DeleteFile "C:\Apps\Sprut4\XPEL_FTP\BOX\Bad\*.xml",force
	objFSO.DeleteFile "C:\Apps\Sprut4\XPEL_FTP\BOX\processed\*.xml",force
'-> VVV <-----------------------------------------------< РАБОТА С АРХИВАМИ ( ЧИСТКА АРХИВОВ И ЖУРНАЛОВ )
	wi0 = 1 * mid( arxMrk1,1,4 )
	if (( 200 < wi0 ) and ( wi0 < 225 )) then   '<- время архивации ( с 2,00 до 2,30 ) ? 
		'VVVVVV - чистка старых журналов
		Set objFolder = objFSO.GetFolder("c:\Apps\Sprut4\XPEL_FTP\LOG")
		Set objFilelist = objFolder.files
		For Each objFile in objFilelist
			With objFile
				IF Right(.name,4) = ".log" and .DateCreated < dtLog THEN
					.Delete True
				END IF
			End With
		Next
		Set objFolder = Nothing
		Set objFilelist = Nothing
		'VVVVVV - чистка старых архивов
		for wi0 = 0 to 2
			ws2 = mid("BADOUTIN", 3 * wi0 + 1, 3)
			Set objFolder = objFSO.GetFolder( "c:\Apps\Sprut4\XPEL_FTP\ARX\" & ws2 )
			Set objFilelist = objFolder.files
			For Each objFile in objFilelist
				With objFile
					IF Right(.name,4) = ".xml" and .DateCreated < dtArx THEN
						.Delete True
					END IF
				End With
			Next
			Set objFolder = Nothing
			Set objFilelist = Nothing
		Next
'-> VVV <-----------------------------------------------< РАБОТА С ПАПКОЙ TEMP ( ЧИСТКА ПАПКИ TEMP )
		Set objFilelist = objFSO.GetSpecialFolder(2).files               '<- чистка файлов
		For Each objFile in objFilelist
			With objFile
				IF  .Attributes > 0 and .DateCreated < dt100 THEN
					.delete true
				end if
			End With
		Next
		Set objSubFolderslist = objFSO.GetSpecialFolder(2).SubFolders   '<- чистка папок
		For Each objFolder in objSubFolderslist
			With objFolder
				IF  .Attributes > 0 and .DateCreated < dt100 THEN
					.delete true
				end if
			End With
		Next
		Set objFolder = Nothing
		Set objFilelist = Nothing
		Set objSubFolderslist = Nothing 
	end If
	
'-> VVV <-----------------------------------------------< ОБРАБОТКА И ЗАГРУЗКА В ТАБЛИЦУ << KB_HKM_IN >> ПОЛУЧЕННЫХ С ftp-СЕРВЕРА ФАЙЛОВ (ПАКЕТОВ) :
	Set objFolder = objFSO.GetFolder("C:\Apps\Sprut4\XPEL_FTP\BOX\In")
	Set objFilelist = objFolder.files
	'.........................................................................->  Подготовка и создание сессии с БД 
	Set OraSession  = CreateObject("OracleInProcServer.XOraSession")
	Set OST1 = OraSession.OpenDatabase("RIFDB_RW","SPRUT4/GUADERA",0)
	'.........................................................................->  Цикл по принятым файлам  
	For Each objFile in objFilelist
		With objFile
			IF Ucase(Right(.name,4)) = ".XML" THEN  '<- Это посылка(ПАКЕТ) ? 
				IF .Size < 10 THEN                  '<- 1) бракуем "пустышки" ( Какова минимальная длина посылки XPEL-FTP ? )
					.Move( "C:\Apps\Sprut4\XPEL_FTP\BOX\Bad\" + .name ) 
				ELSE                                '<- 2) бракуем "пустышки" ( Какова минимальная длина посылки XPEL-FTP ? )
					Set messages_id  = OST1.CreateDynaset( "select SEQ_KB_XPEL_IN.NextVal as new_id FROM DUAL" , 0)
				'.........................................................................->  Получение нового ИД  
					new_id = messages_id.Fields("new_id").Value 
				'.........................................................................->  Вставка(добавление) новой строки в таблицу KB_HKM_IN 
					Ws2 = "C:\Apps\Sprut4\XPEL_FTP\BOX\In\"
					Ws0 = "insert into KB_XPEL_IN( message_id, message_data, message_name, message_delivery_date, message_status ) values( " _ 
					                              & new_id & " , empty_clob(), '" & Ws2 & .name & "', sysdate, 'N' )" 
	''' For TEST ->				msgbox " SQL 0 ->" & Ws0 
					OST1.ExecuteSQL ( Ws0 )  
					'.....................................................................->  Выбор добавленной в таблицу KB_HKM_IN записи	 
						Ws0 = "select * from KB_XPEL_IN where message_id = " & new_id 
						Set messages_in  = OST1.CreateDynaset( Ws0 , 0)
						Set message_data = messages_in.Fields("message_data").Value
					'-> VVV <-------------------------------------------------------------->  Загрузка XML-пакета из указанного файла в CLOB-поле  
							'Ws2 = "C:\Apps\Sprut4\XPEL_FTP\BOX\In\" 
							Ws3 = Ws2 & "XML_for_Load.xml"  
							'.............................................................->  УДАЛЕНИЕ файла для загрузки, если он есть 
							If ( objFSO.FileExists(Ws3) ) Then 
								objFSO.DeleteFile Ws3, force   
							End If
							'.............................................................->  Преобразуем << UTF-8 -> Win1251 >> 
							objShl.Run "C:\Apps\Sprut4\SVT_FTP_MNT_ALL\PRG\utf8_1251.exe " & Ws2 & .name & " " & Ws3 , 0 , True 
							WScript.Sleep 1500 				' <-  даём время для "сна" mlsek
							'.............................................................->  Загрузка XML-пакета из указанного файла в CLOB-поле  
							messages_in.Edit
							message_data.CopyFromFile Ws3  
							messages_in.Update
							'.............................................................->  УДАЛЕНИЕ файла для загрузки, если он есть 
							If ( objFSO.FileExists(Ws3) ) Then 
								objFSO.DeleteFile Ws3, force   
							End If
					Set message_data  = Nothing
					Set messages_id  = Nothing
					Set messages_in = Nothing
				END IF 
			END IF
		End With
	Next
'-> VVV <-----------------------------------------------< Закрытие транзакции 	
	OraSession.CommitTrans           
'-> VVV <-----------------------------------------------< копируем принятые xml-файлы в архив 
	objFSO.CopyFile "C:\Apps\Sprut4\XPEL_FTP\BOX\In\*.xml" , "C:\Apps\Sprut4\XPEL_FTP\ARX\In" , OverwriteExisting
'-> VVV <-----------------------------------------------< удаляем принятые xml-файлы в архив 
	objFSO.DeleteFile "C:\Apps\Sprut4\XPEL_FTP\BOX\In\*.xml",force
'-> VVV <-----------------------------------------------< Чистка системных объектных переменных
	Set OST1  = Nothing
	Set OraSession  = Nothing
	Set objFolder = Nothing
	Set objFilelist = Nothing
	Set objFile = Nothing  
	Set objWMIService = Nothing 
	Set colProcesses = Nothing 
	Set objProcess = Nothing 
'->
'-> VVV <-----------------------------------------------< Ожидание начала следующего обащения к FTP.XPEL_FTP.RU
'->
	WScript.Sleep 60000  '<- даём время для "сна" ( 1 минута ) ' <-  даём время для "сна" (10 минут) 600000 mlsek
''''''msgbox "*** ПРИВЕТ ! -> 01 ! ***",,"*** ТЕСТ ! ***"  ' <-  для отладки  
Wend
'!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
'-> КОНЕЦ << БЕСКОНЕЧНОГО >> ЦИКЛА !!!
'!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!