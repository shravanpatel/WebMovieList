<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Application - View All Movies</title>
</head>
<body>
	<form action="navigationServlet" method="post">
		<table>
			<tr>
				<td></td>
				<td><b>Title</b></td>
				<td><b>Genre</b></td>
				<td><b>Director</b></td>
				<td><b>Producer</b></td>
				<td><b>Actors</b></td>
			</tr>
			<c:forEach items="${requestScope.allMovies}" var="currentmovie">
				<tr>
					<td><input type="radio" name="id" value="${currentmovie.id}"></td>
					<td>${currentmovie.title}</td>
					<td>${currentmovie.genre}</td>
					<td>${currentmovie.director}</td>
					<td>${currentmovie.producer}</td>
					<td>${currentmovie.actors}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToMovie"> 
		<input type="submit" value="delete" name="doThisToMovie"> 
		<input type="submit" value="add" name="doThisToMovie">
	</form>
</body>
</html>