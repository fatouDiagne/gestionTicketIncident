<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<% String APP_ROOT=request.getContextPath(); %>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User</title>
</head>
<body>
 <div id="corps">
 <h1 id="titre-principal">Liste des TICKETS</h1>
 
<a href="<%= APP_ROOT  %>/logout">Deconnexion</a>
<c:choose>
	<c:when test="${empty tickets }">
		<p>La liste des tickets est vide</p>
	</c:when>
	<c:otherwise>
		<table border="1" cellspacing="0" cellpadding="10" id="mytable">
		  <tr> 
		    <th>titre</th>
		    <th>description</th>
		    <th>departement</th>
		    <th>Etat</th>
		    
		    <th colspan="5">Actions</th>
		  </tr>
		  	<c:forEach var="ticket" items="${tickets }">
		  		<tr>
		    	  <td><c:out value="${ticket.titre }" /></td>
		    	  <td><c:out value="${ticket.description }" /></td>
		    	  <td><c:out value="${ticket.departement }" /></td>
		    	  <td><c:out value="${ticket.etat }" /></td>
		    	  <td> <a href="encours?id=${ticket.idticket }">En cours</a></td>
		    	  <td><a href="enattente?id=${ticket.idticket }">En attente</a></td>
		    	  <td><a href="nepastraiter?id=${ticket.idticket }">Ne Pas Traiter</a></td>
		    	  <td><a href="terminer?id=${ticket.idticket }">Termin�</a></td>
		    	  <td><a href="cloture?id=${ticket.idticket }">Cloture</a></td>
		  		</tr>
		  	</c:forEach>
		</table>		
	</c:otherwise>
</c:choose>

 </div>

</body>
</html>