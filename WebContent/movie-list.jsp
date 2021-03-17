<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Movies</title>
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
				<td><b>Release Date</b></td>
				
			</tr>
			<c:forEach items="${requestScope.allMovies}" var="currentMovie">
				<tr>
					<td><input type="radio" name="id" value="${currentMovie.id}"></td>
					<td>${currentMovie.title}</td>
					<td>${currentMovie.genre}</td>
					<td>${currentMovie.director}</td>
					<td>${currentMovie.producer}</td>
					<td>${currentMovie.actors}</td>
					<td>${currentMovie.releaseDate}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToMovie"> 
		<input type="submit" value="delete" name="doThisToMovie"> 
		<input type="submit" value="add" name="doThisToMovie">
	</form>
</body>
</html>