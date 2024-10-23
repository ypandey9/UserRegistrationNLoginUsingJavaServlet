<!-- login.jsp -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form action="login" method="post">
        <label for="emailOrUsername">Email or Username:</label>
        <input type="text" id="emailOrUsername" name="emailOrUsername" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>
        
        <input type="submit" value="Login">
    </form>
    <br>
        <span style="color:red">${errorMessage}</span> <!-- To display error message if login fails -->
</body>
</html>
