<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "model.Account" %>    
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MusicBucket | BALANCE</title>
	</head>
	<body>
	
	<h1>ADD BALANCE</h1>
	<h2>SERVER RESPONSE TIMED OUT TRY AGAIN</h2>
	
	<a href="../AccountPages/homePage.jsp">HOME</a>
	
	<form action="../AddBalanceController" method="get">
		
		<jsp:useBean id="accKey" scope="session" class="model.Account"></jsp:useBean>
		
		
		Card Number(please enter your card number with dashes after 4th digit):
		<input type="text" name="cardNumber"><br>
		How much do you want to add to your account($):
		<input type="text" name="amount">
		<input type="hidden" name="id" value="${accKey.accId }">
		
		<br><br>
		
		<input type="submit" value="ADD BALANCE">
	
	
	</form>
	</body>
</html>