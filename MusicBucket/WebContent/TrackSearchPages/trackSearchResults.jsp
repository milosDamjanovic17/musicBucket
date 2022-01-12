<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Account" %>
<%@ page import="model.Tracks" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>SEARCH RESULTS</title>
	</head>
	<body>
	<jsp:useBean id="accKey" scope="session" class="model.Account"></jsp:useBean>
	<jsp:useBean id="trackListKey" scope="request" class="java.util.ArrayList"></jsp:useBean>
	
	<h2>${accKey.username } SEARCH LIST</h2>
	
	<table border="1px">
	
		<tr>
			<th>ARTIST</th>
			<th>TITLE</th>
			<th>BPM</th>
			<th>GENRE</th>
			<th>LABEL</th>
			<th>YEAR</th>
			<th>PRICE($)</th>
		</tr>
		
		<c:forEach var="tl" items="${trackListKey}">
			<tr>
				<td>${tl.artist}</td>
				<td>${tl.title}</td>
				<td>${tl.bpm}</td>
				<td>${tl.genre}</td>
				<td>${tl.label}</td>
				<td>${tl.year}</td>
				<td>${tl.price}</td>
				
				<!-- BUY BUTTON I PRENOS ID BUYERA -->
				<td>
					<c:url var="checkOutLink" value="CheckOutController">
							<c:param name="idTrack" value="${tl.idTrack }"></c:param>
							<c:param name="accId" value="${accKey.accId }"></c:param>
					</c:url>
					
					<a href="${checkOutLink }"><button>BUY</button></a>
					
				</td>
				
			</tr>

		
		</c:forEach>

	</table>
	</body>
</html>