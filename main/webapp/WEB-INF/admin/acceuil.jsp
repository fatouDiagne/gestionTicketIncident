<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<% String APP_ROOT=request.getContextPath(); %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
 <div id="corps">
 <h1 id="titre-principal">Liste des UTILISATEURS</h1>
<a href="<%= APP_ROOT  %>/adduser">Créer Utilisateur</a>

<a href="<%= APP_ROOT  %>/logout">Deconnexion</a>
<c:choose>
	<c:when test="${empty users }">
		<p>La liste des utilisateurs est vide</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>email</th>
		    <th>role</th>
		    <th colspan="4">Actions</th>
		    
		  </tr>
		  	<c:forEach var="user" items="${users }">
		  		<tr>
		    	  <td><c:out value="${user.email }" /></td>
		    	  <td><c:out value="${user.role }" /></td>
		    	   <td> <a href="updateuser?id=${user.iduser }">Modifier</a></td>
		    	  <td><a href="deleteuser?id=${user.iduser }">Supprimer</a></td>
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>

</body>
</html>