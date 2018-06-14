<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script>
	$(document).ready(function(){
		$("#input").click(function(){
			$(location).attr("href","input.jsp");
		})
		$("#output").click(function(){
			$(location).attr("href","output.do");
		})
	})
</script>
</head>
<body>
	<table border=1 align=center>
		<tr><td colspan=2 style="text-align:center">messages</td></tr>
		<tr>
		<td><button id=input>input</button></td>
		<td><button id=output>output</button></td>
		</tr>
	</table>
</body>
</html>