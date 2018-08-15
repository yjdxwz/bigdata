<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>iphone7</title>
<link href="..\css\mycss.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="..\js\js.js"></script>
</head>
<body>
	<div id="div1">
		welcome to iphone page!
	</div>
	<form action="<c:url value='/item/score'/>" onclick="this.submit();" method="post" target="_blank">
		<input type="hidden" name="itemId" value="1" />
		<input type="radio" name="score" value="1">很差<br>
		<input type="radio" name="score" value="2">不差<br>
		<input type="radio" name="score" value="3">还行<br>
		<input type="radio" name="score" value="4">不错<br>
		<input type="radio" name="score" value="5">很好<br>
	</form>
	<img src="..\images\iphone7.png" height="600" width="800" onclick="show()"><br>
	iphone7 : this is a description.
	￥:3500.
</body>
</html>