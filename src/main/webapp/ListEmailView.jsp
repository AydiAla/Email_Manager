<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Email</title>
  
</head>
<body>
    <h1>Members:</h1>
    <ul>
        <c:forEach var="address" items="${addresses}">
            <li>${address}</li>
        </c:forEach>

        <hr>

        <h2>Emails from Database:</h2>
        <ul>
            <c:forEach var="dbEmail" items="${dbEmails}">
                <li><a href='listemail'>${dbEmail}</a></li>
            </c:forEach>
        </ul>

        <hr>

        <form action='ListEmailServlet' method='post'>
 <p>Entrez votre adresse email :
<input type="text" pattern="[^@\s]+@[^@\s]+\.[^@\s]+" title="Invalid email address"  onekeydown="valider()"/>     
    <input type='submit' name='subscribe' value='Add'>
            <input type='submit' name='unsubscribe' value='Remove'>
        </form>
    </ul>

 <script type="text/javascript">

function valider() {
	var email = document.getElementById("email") ; 
	var pattern = [^@\s]+@[^@\s]+\.[^@\s]+ ; 
	
  // si la valeur du champ prenom est non vide
  if(email.match(pattern)) {
    // alors on envoie le formulaire
 	form.classList.add("valid") ; 
    form.classList("invalide ") ; 
  }
  else {
    // sinon on affiche un message
	form.classList.remove("valid") ; 
    form.classList.add("invalide")
  
  }
}

</script>
    </body>
</html>
