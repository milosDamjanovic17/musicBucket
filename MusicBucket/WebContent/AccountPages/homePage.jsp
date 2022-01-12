<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "model.Account" %>
<%@ page import = "model.AccountDetails" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MusicBucket | Home</title>
	</head>
	<body>
	
	<jsp:useBean id="accKey" scope="session" class="model.Account"></jsp:useBean>

	
	<h1>${accKey.username}'s HomePage</h1>
	
	<a href="accountDetailsEdit.jsp">EDIT ACCOUNT DETAILS</a><br>
	<a href="../BalancePages/balance.jsp">CLICK HERE TO ADD BALANCE FOR FURTHER PURCHASE</a><br>
	<a href="../TrackSearchPages/trackSearch.jsp">SEARCH HERE</a>
	
	
	
	</body>
</html>