<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board/table.css">
</head>
<body>
	<center>
		<h3>�亯�ϱ�</h3>
		<form method="post" action="reply_ok.do">
		<table id="table_content" width=500>
			<tr>
				<td width=15%>�̸�</td>
				<td width=85%>
					<input type="text" name="name" size="12">
					<input type="hidden" name="pno" value="${no }">
					<input type="hidden" name="page" value="${page }">
				</td> 
			</tr>
			<tr>
				<td width=15%>����</td>
				<td width=85%>
					<input type="text" name="subject" size="50">
				</td> 
			</tr>
			<tr>
				<td width=15%>����</td>
				<td width=85%>
					<textarea rows="10" cols="55" name="content"></textarea>
				</td> 
			</tr>
			<tr>
				<td width=15%>��ȣ</td>
				<td width=85%>
					<input type="password" name="pwd" size="10">
				</td> 
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="�亯">
					<input type="button" value="���" onclick="javascript:history.back()">
				</td> 
			</tr>
		</table>
		</form>
	</center>
</body>
</html>