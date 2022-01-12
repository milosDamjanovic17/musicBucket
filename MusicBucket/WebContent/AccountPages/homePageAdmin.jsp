<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "model.Account" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MuiscBucket | Home</title>
	</head>
	<body>
	
	<jsp:useBean id="accKey" scope="session" class="model.Account"></jsp:useBean>
	
	<h1>${accKey.username}'s HomePage</h1>
	
	
	<a href="addTracksAdmin.jsp">ADD TRACKS</a>
	
	
	</body>
</html>