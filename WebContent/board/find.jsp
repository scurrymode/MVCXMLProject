<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board/table.css">
</head>
<body>
	<center>
		<h3>�˻����</h3>
		<c:if test="${length==0 }">
			<table id="table_content" width=700>
				<tr>
					<td align=center>�˻������ �����ϴ�</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${length!=0 }">
			<table id="table_content" width=700>
				<tr>
					<th width=10%>��ȣ</th>
					<th width=45%>����</th>
					<th width=15%>�̸�</th>
					<th width=20%>�ۼ���</th>
					<th width=10%>��ȸ��</th>
				</tr>
				<c:forEach var="vo" items="${list }">
					<tr>
						<td width=10% align=center>${vo.no }</td>
						<td width=45%>${vo.subject }</td>
						<td width=15% align=center>${vo.name }</td>
						<td width=20% align=center>
						<fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd" /></td>
						<td width=10% align=center>${vo.hit }</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</center>

</body>
</html>