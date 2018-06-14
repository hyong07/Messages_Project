<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
		<tr>
			<td>message_id</td>
			<td>name</td>
			<td>message</td>
		</tr>
		<c:choose>
			<c:when test="${select_result.size() == 0}">
				<tr><td>not exist</td></tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="msg" items="${select_result}">
					<tr>
					<td>${msg.message_id}</td>
					<td>${msg.name}</td>
					<td>${msg.message}</td>
					</tr>
				</c:forEach>
				
			</c:otherwise>
		</c:choose>
	</table>
	
</body>
</html>