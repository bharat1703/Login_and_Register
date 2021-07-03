<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form    action="register">
Firstname: <input type="text" name="firstName"></br>
Lastname :<input type="text" name="lastName"></br>
Age      :<input type="text" name="age"></br>
Email    : <input type="text" name="email"></br>
Password :<input type="password" name="password"></br>
<input type="submit" value="register"onsubmit="return validateForm()" >
</form>

<script>
function validateForm() {
  var x = document.forms["myForm"]["firstName"].value;
  if (x == "") {
    alert("Name must be filled out");
    return false;
  }
}
</script>
</body>
</html>