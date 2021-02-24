<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application - Edit Movie</title>
</head>
<body>
	<form action="editItemServlet" method="post">
		Title: <input type="text" name="title" value="${movieToEdit.title}" /> <br /> 
		Genre: <input type="text" name="genre" value="${movieToEdit.genre}" /> <br /> 
		Director: <input type="text" name="director" value="${movieToEdit.director}" /> <br /> 
		Producer: <input type="text" name="producer" value="${movieToEdit.producer}" /> <br /> 
		Actors: <input type="text" name="actors" value="${movieToEdit.actors}" /> <br /> 
		<input type="hidden" name="id" value="${movieToEdit.id}"> 
		<input type="submit" value="Save Edited Movie">
	</form>
</body>
</html>