<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Account" %>
<%@ page import="model.AccountDetails" %>
<%@ page import="model.Tracks" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>CHECKOUT</title>
	</head>
	<body>
	<h1>PURCHASE INFO</h1>
	
	<jsp:useBean id="accKey" scope="session" class="model.Account"></jsp:useBean>
	<jsp:useBean id="trackKey" scope="request" class="model.Tracks"></jsp:useBean>
	<jsp:useBean id="accDetailsKey" scope="request" class="model.AccountDetails"></jsp:useBean>
	
	<p>BUYER INFO</p>
	<p>BUYER: ${accKey.username }</p>
	<p>BALANCE: ${accDetailsKey.balance }$</p>
	
	<br>
	
	<p>TRACK INFO</p>
	<p>Artist: ${trackKey.artist }</p>
	<p>Title: ${trackKey.title }</p>
	<p>Label: ${trackKey.label }</p>
	<p>Genre: ${trackKey.genre }</p>
	<p>Price: ${trackKey.price }</p>
	
	<br>
	
	<form action="PurchaseController" method="get">
		<input type="hidden" name="accDetailsId" value="${accDetailsKey.idAccDetails }">
		<input type="hidden" name="trackId" value="${trackKey.idTrack }">
		<input type="submit" value="PURCHASE">
	
	</form>
	
	</body>
</html>