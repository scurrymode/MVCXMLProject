<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
	<c:when test="${bCheck==true }">
		<c:redirect url="list.do?page=${page }"/>
	</c:when>
	<c:otherwise>
		<script>
		alert("��й�ȣ�� Ʋ���ϴ�");
		history.back();
		</script>
	</c:otherwise>
</c:choose>