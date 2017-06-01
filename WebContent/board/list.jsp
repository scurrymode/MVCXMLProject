<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="board/table.css">
</head>
<body>
	<center>
		<h3>�Խ��� ���</h3>
		<table id="table_content" width=700>
			<tr>
				<td align=left>
					<a href="insert.do">����</a>
				</td>
			</tr>
		</table>
		<table id="table_content" width=700>
			<tr>
				<th width=10%>��ȣ</th>
				<th width=45%>����</th>
				<th width=15%>�̸�</th>
				<th width=20%>�ۼ���</th>
				<th width=10%>��ȸ��</th>
			</tr>
			<c:forEach var="vo" items="${list}">
				<tr class="dataTr">
					<td width=10% align=center>${vo.no}</td>
					<td width=45%>
					<!-- �亯�̸� �亯 ǥ�� -->
					<c:if test="${vo.group_tab>0 }">
						<c:forEach var="i" begin="1" end="${vo.group_tab }">
						&nbsp;&nbsp;
						</c:forEach>
						<img src="image/icon_reply.gif">
					</c:if>
					<c:if test="${vo.subject!=msg }">
					<a href="content.do?no=${vo.no }&page=${curpage}">${vo.subject }</a> <!-- �󼼺��� -->
					</c:if>
					<c:if test="${vo.subject==msg }">
					<span style="color:gray">${vo.subject }</span>
					</c:if>
					<!-- ��ǥ�� -->
					<c:if test="${today==vo.day }">
						<sup><img src="image/new.gif"></sup> <!-- ���� �ø���� -->
					</c:if>
					</td>
					<td width=15% align=center>${vo.name}</td>
					<td width=20% align=center><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd" /></td>
					<td width=10% align=center>${vo.hit}</td>
				</tr>
			</c:forEach>
		</table>
		<table border=0 width=700>
			<tr>
			<!-- ã�� -->
				<td align=left>
				<form method="post" action="find.do">
					Search:<select name="fs"><!-- �÷��� -->
					<option value="name">�̸�</option>
					<option value="subject">����</option>
					<option value="content">����</option>
					</select>
					<input type="text" name="ss" size=10><!-- ã�� �� -->
					<input type="submit" value="�˻�">
					</form>
				</td>
				<!-- ������������ ���ٿ� -->
				<td align=right>
					<a href="list.do?page=${curpage>1?curpage-1:curpage}">
					<img src="image/prev_a.gif"></a>&nbsp;
					<a href="list.do?page=${curpage<totalpage?curpage+1:curpage}">
					<img src="image/next_a.gif"></a>&nbsp;&nbsp;
					${curpage} page / ${totalpage } pages
				</td>
			</tr>
		</table>
	</center>
</body>
</html>