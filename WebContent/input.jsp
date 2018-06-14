<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="input.do" method="get">
		<table border=1 align=center>
			<tr><td colspan=2 style="text-align:center">input information</td></tr>
			<tr>
			<td>Id</td>
			<td><input type="text" name="message_id"></td>
			</tr>
			<tr>
			<td>Name</td>
			<td><input type="text" name="name"></td>
			</tr>
			<tr>
			<td>Message</td>
			<td><input type="text" name="message"></td>
			</tr>
			<tr><td colspan=2 style="text-align:right"><input type="submit" value="submit"></td></tr>
		</table>
	</form>
	
</body>
</html>