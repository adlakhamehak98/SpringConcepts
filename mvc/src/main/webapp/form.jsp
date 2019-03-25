<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
${heading}
<form method="post" action="/newStudent"><%--change to "/form" for question 8--%>
    <label>firstname</label>
    <input name="firstname" type="text"/>
    <label>lastname</label>
    <input name="lastname" type="text"/>
    <input type="submit">
</form>
</body>
</html>