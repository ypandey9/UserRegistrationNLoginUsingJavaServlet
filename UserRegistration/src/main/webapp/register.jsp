<!-- WebContent/register.jsp -->
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration Form</h2>
    <form action="register" method="post">
        Full Name: <input type="text" name="fullname" required /><br/>
        Username: <input type="text" name="username" required /><br/>
        Password: <input type="password" name="password" required /><br/>
        Email: <input type="email" name="email" required /><br/>
        <input type="submit" value="Register" />
    </form>
    <br>
    <a href="/UserRegistration/login.jsp">Login</a>
</body>
</html>
