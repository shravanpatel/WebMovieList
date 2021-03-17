<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add a Movie List</title>
</head>
<body>
<form action="createNewMovieListServlet" method="post">
		Movie list name: <input type="text" name="listName">
		<br /> 
		Theater: <input type="text" name="theaterName">
		<br /> 
		Movies available: <br/>
		<select name="allMoviesToAdd" multiple size="6"> 
		<c:forEach items="${requestScope.allMovies}" var="currentMovie">
		<option value="${currentMovie.id }">
			${currentMovie.title} - ${currentMovie.director}
		</option>
		</c:forEach>
		</select> <br /> <input type="submit" value="Add movies and create list">
	</form>
	<a href="index.html">Go add new movies instead.</a>

</body>
</html>