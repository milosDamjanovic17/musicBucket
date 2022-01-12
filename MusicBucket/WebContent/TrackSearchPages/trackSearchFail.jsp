<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>TRACK SEARCH</title>
	</head>
	<body>
	
	<h1>TRACK SEARCH FORM</h1>
	<h2>TRACK NOT FOUND</h2>
	
	<form action="../TrackSearchController" method="post">
		Artist:
		<input type="text" name="artist"><br>
		Title/Song name:
		<input type="text" name="title"><br>
		BPM:
		<input type="text" name="bpm"><br>
		Genre:
		<select name="genre">
			<option value="house">House</option>
			<option value="funkyHouse">Funky House</option>
			<option value="rnb">RNB</option>
			<option value="techno">Techno</option>
			<option value="trance">Trance</option>
			
		</select> <br>
		Label:
		<input type="text" name="label"><br>
		Year:
		<select name="year">
			<c:forEach var="i" begin="1980" end="2021">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select><br>
		
		<br><br>
		
		<input type="submit" value="SEARCH">
	
	
	</form>
	
	
	</body>
</html>