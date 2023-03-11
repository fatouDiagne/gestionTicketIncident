<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
 <div id="corps">
 <h1 id="titre-principal">Ajouter Utilisateur</h1>
   <p class="erreur">${statusMessage}</p>

   <form action="adduser" method="post">
	    <div class="formItem">
		    <label>Email</label>
		    <input type="text" name="email" >
		 </div>
		 
		 <div class="formItem">
		    <label>Mot de passe</label>
		    <input type="password" name="motdepasse">
		 </div>
		 
		 <div class="formItem">
		    <label>Role</label>
		    <input type="text" name="role">
		 </div>
		     
		 <div class="formItem">
		    <label></label>
		    <input type="submit" >
		 </div>

  </form>  
  </div>
</body>
</html>