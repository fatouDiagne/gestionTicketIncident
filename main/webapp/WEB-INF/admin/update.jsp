<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin</title>
</head>
<body>
<h1>Mise à jour Utilisateur</h1>
 <form action="updateuser" method="post">
	   <input type="hidden" name="id" value="${user.iduser }"/>
     
       <div class="formItem">
    		<label>email</label>
    		<input type="text" name="email" value="${user.email }">
      </div>
      
      <div class="formItem">
    		<label>	Mot de passe</label>
    		<input type="password" name="motdepasse" value="${ user.password }">
      </div>
      
      <div class="formItem">
    		<label>Role</label>
    		<input type="text" name="role" value="${user.role }">
      </div>
      
 
      <div class="formItem">
        <label></label>
    	<input type="submit" >
      </div>
  
  </form>
</body>
</html>