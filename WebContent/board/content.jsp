<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board/table.css"> 
<script src="http://code.jquery.com/jquery.js"></script>
<script>
/*
 * window.onload=function(){} �� ��������
 */
 var i=0;
$(function(){
	$('#a_del').click(function(){
		if(i==0){
			$('#del').show();
			$('#a_del').value('�����ݱ�'');
			i=1;
		}else{
			$('#del').hide();
			i=0;
		}
	});
});
</script>

</head>
<body>
	<center>
		<h3>���뺸��</h3>
		<table id="table_content" width=500>
			<tr>
				<th width=20%>��ȣ</th>
				<td width=30% align=center>${vo.no }</td>
				<th width=20%>�ۼ���</th>
				<td width=30% align=center>${vo.day }</td>
			</tr>
			<tr>
				<th width=20%>�̸�</th>
				<td width=30% align=center>${vo.name }</td>
				<th width=20%>��ȸ��</th>
				<td width=30% align=center>${vo.hit }</td>
			</tr>
			<tr>
				<th width=20%>����</th>
				<td colspan="3" align=left>${vo.subject }</td>
			</tr>
			<tr>
				<td colspan="4" align=left valign=top height=200>${vo.content }</td>
			</tr>
		</table>
		<table id="table_content" width=500>
			<tr>
				<td align=right>
					<a href="reply.do?no=${vo.no}&page=${page }">�亯</a>&nbsp;
					<a href="update.do?no=${vo.no}&page=${page }">����</a>&nbsp;
					<a href="#" id="a_del">����</a>&nbsp;
					<a href="list.do?page=${page }">���</a>
				</td>
			</tr>
			<tr id="del" style="display:none">
				<td align=right>
					��й�ȣ:<input type="password" name="pwd" size="10">
					<input type="button" value="����">
				</td>
			</tr>
		</table>
	</center>
	

</body>
</html>