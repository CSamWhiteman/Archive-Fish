<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Credit Card Payment Calculator</title>
</head>
<body>

<form action="payment" method="post">
	<label>First Name:</label>
	<input name="fname" type="text">
	<br>
	<label>Last Name:</label>
	<input name="lname" type="text">
	<br>
	<label>Account Number:</label>
	<input name="accountnum" type="text">
	<br>
	<label>Balance:</label>
	<input name="balance" type="text">
	<br>
	<label>Percent to Pay:</label>
	<input name="percentToPay" type="text">
	<br>
	<input name="Calculate!" type="submit">
</form>
</body>
</html>