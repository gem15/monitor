'--------------------------------------------------------------------------- 
'-> ��������� ��������� �������� ����� � �������� FTP.XPEL.RU *** 14.01.2021 *** 
'-- *** �������� ����� ���������    -> C:\Apps\Sprut4\XPEL_FTP     ( ���������� FTP-������ � XPEL )
'-- ***          ����� �� ��������� -> C:\Apps\Sprut4\XPEL_FTP\PRG ( ������� ������� � ����� ������� �������� )
'-- ***          ����� �  ��������  -> C:\Apps\Sprut4\XPEL_FTP\ARX ( �������� �����, �������� - ����� IN, OUT, BAD, PROCESSED ) 
'-- ***          ������� �����      -> C:\Apps\Sprut4\XPEL_FTP\BOX ( ����� ������,   �������� - ����� IN, OUT, BAD, PROCESSED ) 
'-- ***          ���������� �����   -> C:\Apps\Sprut4\XPEL_FTP\LOG ( ������� FTP-������ � ����� ������ ��������� ������ � ��  )
'--------------------------------------------------------------------------    �������� ������� ����������
Dim objScr, objShl, objFSO,  dtNow, dtArx, dtDoc, arxMrk0, arxMrk1, objFolder, objFilelist, objFile, objSubFolderslist
Dim rs, objProcess, fs, ts
Dim wStr0, wStr1, wStr2 
Dim Ws0, Ws1, Ws2, Ws3 
Dim wi0, wi1  
Dim START_FLAG
Dim OraSession, OST1, OraDynaset, OraCLOB, buffer, amount_read, messages_id, messages_in, message_data, new_id   
'--------------------------------------------------------------------------    ��������� ����������� ������ � ����� �������� � ���������� ���������
On Error Resume Next       
'--------------------------------------------------------------------------     �������� ��������� �������� 
Set objFSO = CreateObject("Scripting.FileSystemObject")
Set objShl = WScript.CreateObject("WScript.Shell")
'--------------------------------------------------------------------------    ��������� ���� � ������� �����
	With  WScript
	  Ws0 = Mid( .ScriptFullName,1,instr(.ScriptFullName,.ScriptName) - 1 ) 
	End With
	Ws1 = Mid(Ws0,1, len(Ws0)- 1 )
'--------------------------------------------------------------------------    �������� ���������� �������   
wStr0 = "N"          '<- ������ ���������� ������� ��������
Set objWMIService = GetObject("winmgmts:{impersonationLevel=impersonate}!\\.\root\cimv2")
Set colProcesses = objWMIService.ExecQuery("Select * from Win32_Process")
For Each objProcess in colProcesses   '<--- ���� �� ��������� ��������� !!! (������ � ������ �� ������ ���������)
	' "��������! ��� ��� �������� ! -> MsgBox objProcess.CommandLine & " = " & objProcess.Name  & " = " & objProcess.ExecutablePath  
	If objProcess.Name = "MNT_XPEL_FTP.exe" and instr(objProcess.CommandLine, WScript.ScriptFullName) > 0 Then
		If wStr0 = "Y" Then
			rs = msgbox("��������� ��������: " & chr(10) & chr(10) & " CommandLine -> " & objProcess.CommandLine & chr(10) & _
						" Process.Name -> " & objProcess.Name  & chr(10) & " ExecutablePath -> " & objProcess.ExecutablePath _
						& chr(10) & chr(10) & "�� ������ ��������� ������� ? " & chr(10) _
						, vbYesNo,"   �������� !!!  FTP-������� << XPEL >> ��� �������� !!! ... " )
			If rs = vbNo Then    ' <- ����� �� ������� �������� ?
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
			objProcess.Terminate        '<- ���������� ��������  CMD 
		End If 
	End If
Next
'!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
'-> ������ << ������������ >> ����� !!!
'!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
START_FLAG = "0"                         '<- �������������� ������������� ���������� ������ �������� !!!
While True
'-> VVV <-----------------------------------------------< �������� ������� ��� ������ ��������
	wStr0 = "C:\Apps\Sprut4\XPEL_FTP\PRG\XPEL_SCP.scr" 
	If ( START_FLAG = "1" ) and ( not objFSO.FileExists(wStr0) ) Then '<- ������� ������ ���������� ?
		Set objFile = Nothing
		Set objFolder = Nothing
		Set objFSO = Nothing
		Set objShl = Nothing
		Set objWMIService = Nothing
		Set colProcesses = Nothing
		Set objProcess = Nothing
		msgbox chr(10) & chr(10) & "   �������� !!! " & _ 
				chr(10) & chr(10) & " FTP-������� << XPEL >> ��������� ������ " & _
				chr(10) & "�� ������� �������������� !!! ... " & chr(10) & chr(10) 
		WScript.Quit
	Else
		objFSO.DeleteFile wStr0, force        '<- ������� �������� WinSCP-������� ��� ��������
	End If
'-> VVV <-----------------------------------------------< ������ �������� ����� !!!
	START_FLAG = "1" 
'-> VVV <-----------------------------------------------< ���������� ��������� ����� ��� �������� ������� � ������� 
	dtNow = NOW
	dtLog = DateAdd("d", -5, NOW)    '<-=   �������� ���� ��������, ������� ������  5  ����� 
	dtArx = DateAdd("d", -10, NOW)   '<-=   �������� ���� �������, ������� ������  10  ����� 
	dtDoc = DateAdd("d", -10, NOW)   '<-=   �������� ���� ����������-�������, ������� ������  10  ����� 
	dt100 = DateAdd("s", -100, NOW)  '<-=   �������� ���� ������, ������� ������  100  ��� 
	arxMrk0 = CStr(Year(dtNow)) & Right("00" & CStr(Month(dtNow)), 2) & Right("00" & CStr(Day(dtNow)), 2)
	arxMrk1 = Right("00" & CStr(Hour(dtNow)), 2) & Right("00" & CStr(Minute(dtNow)), 2) & Right("00" & CStr(Second(dtNow)), 2) 
	arxMrk0 = arxMrk0 & arxMrk1
'-> VVV ==========================================  �������� XML-�������  �� ������� << KB_HKM_OUT >>  ��� �������� �� FTP-������ 
	Set OraSession  = CreateObject("OracleInProcServer.XOraSession")
	Set OST1 = OraSession.OpenDatabase("RIFDB_RW","SPRUT4/GUADERA",0)
'............................................................................-> ������� ������ �� ��
		Set OraDynaset = OST1.DbCreateDynaset( "SELECT * FROM KB_XPEL_OUT WHERE processing_date is Null and status = 'N' " ,0)
		while not OraDynaset.EOF
'............................................................................-> �������� XML-������ � ����
			Set OraCLOB = OraDynaset.Fields("xml_data").Value
				amount_read = OraCLOB.Read(buffer)
				Ws0 = "C:\Apps\Sprut4\XPEL_FTP\BOX\Out\" & OraDynaset.Fields("file_name").Value 
				OraCLOB.CopyToFile ws0
			Set OraCLOB = Nothing
			OraDynaset.MoveNext
		Wend
'............................................................................-> ������� � �������� �������  	
		OST1.ExecuteSQL ( "UPDATE KB_XPEL_OUT SET processing_date = sysdate, status = 'S' WHERE processing_date is Null and status = 'N' " )  
'............................................................................-> �������� ���������� 	
	OraSession.CommitTrans  
'............................................................................-> ������ ��������� ��������� ����������
    Set OraDynaset = Nothing
    Set OST1 = Nothing
    Set OraSession = Nothing
'-> VVV <-----------------------------------------------< ���������� �������� ������ ��� ������� WinSCP 
   set fs = objFSO.OpenTextFile(wStr0, 2, 1) 
'                                            �������� FTP-������
	   fs.WriteLine "option batch on"
	   fs.WriteLine "option confirm off" 
	   fs.WriteLine "open sftp://severtrans_it:SevTraIt20XX@176.118.31.139 -hostkey=""*"""
'                                            �����  ����� ������ ( � ��������� ! )   
'	   fs.WriteLine "cd /ftpserver/hellmann/prod/In"
'					     Change the working directory on the local computer to
'	   fs.WriteLine "lcd C:\Apps\Sprut4\XPEL_FTP\BOX\In" 
'	   fs.WriteLine "get -delete *.xml"
'                                            �������� ������ (�����������)
	   fs.WriteLine "cd /Integration.V2/EXPELL/Outbound/Response"
	   fs.WriteLine "lcd C:\Apps\Sprut4\XPEL_FTP\BOX\Out"
	   fs.WriteLine "put *.xml" 
'                                            �������� ������ � ���������� ������
	   fs.WriteLine "close" 
	   fs.WriteLine "exit" 
	   fs.Close 
	Set fs = Nothing
'-> VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV  <- ��������� WinSCP-������ � ������ ��� ��������� ��������� 
'->
	objShl.Run "C:\Apps\Sprut4\SVT_FTP_MNT_ALL\PRG\WinSCP.exe /console /script=" & wStr0 _ 
	         & " /log=c:\Apps\Sprut4\XPEL_FTP\LOG\XPEL_SCP_" & arxMrk0 & ".log", 0 , True 
	WScript.Sleep 10000 				' <-  ��� ����� ��� "���" mlsek
'->
'-> VVV <-----------------------------------------------< �������� ���������� xml-����� � �����
	objFSO.CopyFile "C:\Apps\Sprut4\XPEL_FTP\BOX\Out\*.xml" , "C:\Apps\Sprut4\XPEL_FTP\ARX\Out" , OverwriteExisting
	objFSO.CopyFile "C:\Apps\Sprut4\XPEL_FTP\BOX\Bad\*.xml" , "C:\Apps\Sprut4\XPEL_FTP\ARX\Bad" , OverwriteExisting
'-> VVV <-----------------------------------------------< ������� �� �������� ������� xml-����� ����������� � ������
	objFSO.DeleteFile "C:\Apps\Sprut4\XPEL_FTP\BOX\Out\*.xml",force
	objFSO.DeleteFile "C:\Apps\Sprut4\XPEL_FTP\BOX\Bad\*.xml",force
	objFSO.DeleteFile "C:\Apps\Sprut4\XPEL_FTP\BOX\processed\*.xml",force
'-> VVV <-----------------------------------------------< ������ � �������� ( ������ ������� � �������� )
	wi0 = 1 * mid( arxMrk1,1,4 )
	if (( 200 < wi0 ) and ( wi0 < 225 )) then   '<- ����� ��������� ( � 2,00 �� 2,30 ) ? 
		'VVVVVV - ������ ������ ��������
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
		'VVVVVV - ������ ������ �������
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
'-> VVV <-----------------------------------------------< ������ � ������ TEMP ( ������ ����� TEMP )
		Set objFilelist = objFSO.GetSpecialFolder(2).files               '<- ������ ������
		For Each objFile in objFilelist
			With objFile
				IF  .Attributes > 0 and .DateCreated < dt100 THEN
					.delete true
				end if
			End With
		Next
		Set objSubFolderslist = objFSO.GetSpecialFolder(2).SubFolders   '<- ������ �����
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
	
'-> VVV <-----------------------------------------------< ��������� � �������� � ������� << KB_HKM_IN >> ���������� � ftp-������� ������ (�������) :
	Set objFolder = objFSO.GetFolder("C:\Apps\Sprut4\XPEL_FTP\BOX\In")
	Set objFilelist = objFolder.files
	'.........................................................................->  ���������� � �������� ������ � �� 
	Set OraSession  = CreateObject("OracleInProcServer.XOraSession")
	Set OST1 = OraSession.OpenDatabase("RIFDB_RW","SPRUT4/GUADERA",0)
	'.........................................................................->  ���� �� �������� ������  
	For Each objFile in objFilelist
		With objFile
			IF Ucase(Right(.name,4)) = ".XML" THEN  '<- ��� �������(�����) ? 
				IF .Size < 10 THEN                  '<- 1) ������� "��������" ( ������ ����������� ����� ������� XPEL-FTP ? )
					.Move( "C:\Apps\Sprut4\XPEL_FTP\BOX\Bad\" + .name ) 
				ELSE                                '<- 2) ������� "��������" ( ������ ����������� ����� ������� XPEL-FTP ? )
					Set messages_id  = OST1.CreateDynaset( "select SEQ_KB_XPEL_IN.NextVal as new_id FROM DUAL" , 0)
				'.........................................................................->  ��������� ������ ��  
					new_id = messages_id.Fields("new_id").Value 
				'.........................................................................->  �������(����������) ����� ������ � ������� KB_HKM_IN 
					Ws2 = "C:\Apps\Sprut4\XPEL_FTP\BOX\In\"
					Ws0 = "insert into KB_XPEL_IN( message_id, message_data, message_name, message_delivery_date, message_status ) values( " _ 
					                              & new_id & " , empty_clob(), '" & Ws2 & .name & "', sysdate, 'N' )" 
	''' For TEST ->				msgbox " SQL 0 ->" & Ws0 
					OST1.ExecuteSQL ( Ws0 )  
					'.....................................................................->  ����� ����������� � ������� KB_HKM_IN ������	 
						Ws0 = "select * from KB_XPEL_IN where message_id = " & new_id 
						Set messages_in  = OST1.CreateDynaset( Ws0 , 0)
						Set message_data = messages_in.Fields("message_data").Value
					'-> VVV <-------------------------------------------------------------->  �������� XML-������ �� ���������� ����� � CLOB-����  
							'Ws2 = "C:\Apps\Sprut4\XPEL_FTP\BOX\In\" 
							Ws3 = Ws2 & "XML_for_Load.xml"  
							'.............................................................->  �������� ����� ��� ��������, ���� �� ���� 
							If ( objFSO.FileExists(Ws3) ) Then 
								objFSO.DeleteFile Ws3, force   
							End If
							'.............................................................->  ����������� << UTF-8 -> Win1251 >> 
							objShl.Run "C:\Apps\Sprut4\SVT_FTP_MNT_ALL\PRG\utf8_1251.exe " & Ws2 & .name & " " & Ws3 , 0 , True 
							WScript.Sleep 1500 				' <-  ��� ����� ��� "���" mlsek
							'.............................................................->  �������� XML-������ �� ���������� ����� � CLOB-����  
							messages_in.Edit
							message_data.CopyFromFile Ws3  
							messages_in.Update
							'.............................................................->  �������� ����� ��� ��������, ���� �� ���� 
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
'-> VVV <-----------------------------------------------< �������� ���������� 	
	OraSession.CommitTrans           
'-> VVV <-----------------------------------------------< �������� �������� xml-����� � ����� 
	objFSO.CopyFile "C:\Apps\Sprut4\XPEL_FTP\BOX\In\*.xml" , "C:\Apps\Sprut4\XPEL_FTP\ARX\In" , OverwriteExisting
'-> VVV <-----------------------------------------------< ������� �������� xml-����� � ����� 
	objFSO.DeleteFile "C:\Apps\Sprut4\XPEL_FTP\BOX\In\*.xml",force
'-> VVV <-----------------------------------------------< ������ ��������� ��������� ����������
	Set OST1  = Nothing
	Set OraSession  = Nothing
	Set objFolder = Nothing
	Set objFilelist = Nothing
	Set objFile = Nothing  
	Set objWMIService = Nothing 
	Set colProcesses = Nothing 
	Set objProcess = Nothing 
'->
'-> VVV <-----------------------------------------------< �������� ������ ���������� �������� � FTP.XPEL_FTP.RU
'->
	WScript.Sleep 60000  '<- ��� ����� ��� "���" ( 1 ������ ) ' <-  ��� ����� ��� "���" (10 �����) 600000 mlsek
''''''msgbox "*** ������ ! -> 01 ! ***",,"*** ���� ! ***"  ' <-  ��� �������  
Wend
'!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
'-> ����� << ������������ >> ����� !!!
'!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!