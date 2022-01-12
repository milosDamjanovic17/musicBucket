<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "model.Account" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>MusicBucket | Edit</title>
	</head>
	<body>
	
	<h1>FAILED PLEASE FILL ALL YOUR INPUTS</h1>
	
	<jsp:useBean id="accKey" scope="session" class = "model.Account"></jsp:useBean>
	
	<form action="../AccountDetailsController" method="get">
		
		Full name:
		<input type="text" name="name"><br>
		Dj name:
		<input type="text" name="djName"><br>
		BIO:
		<input type="text" name="description"><br>
		MixCloud/SoundCloud:
		<input type="text" name="url"><br>
		Prefered Genre:
		<select name="genre">
			<option value="house">House</option>
			<option value="funkyHouse">Funky House</option>
			<option value="rnb">RnB</option>
			<option value="techno">Techno</option>
			<option value="trance">Trance</option>
		</select>
		
		<input type="hidden" name="id" value="${accKey.accId}"><br><br>
		
		<input type="submit" value="UPDATE ACCOUNT">
	
	</form>
	</body>
</html>