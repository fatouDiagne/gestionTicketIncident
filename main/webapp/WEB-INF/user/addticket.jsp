<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Ticket</title>
</head>
<body>
<h1 id="titre-principal">Ajouter ticket</h1>
   <p class="erreur">${statusMessage}</p>

   <form action="addticket" method="post">
	        
		     <div class="formItem">
		    	<label>Titre</label>
		    	<input type="text" name="titre">
		    </div>
		    
		    <div class="formItem">
		    	<label>Descripion</label>
		    	<input type="text" name="description">
		    </div>
		    
		    <div class="formItem">
		    	<label>Departement</label>
		    	<input type="text" name="departement">
		    </div>
		    
		    <div class="formItem">
		    	<label></label> 
		   		<input type="submit">
		    </div>
	
  </form>
</body>
</html>