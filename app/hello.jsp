<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// http://stackoverflow.com/a/6099438/1031898
// Scriptlets and the expression language in ${ } (see the use of <c:out />
// below) don't share the same variable scope. So if you can use <%= with
// this `name` variable, but trying to use it in c:out doesn't work.
String name = request.getParameter("name") != null ? request.getParameter("name") : "You";
%>
<!DOCTYPE html>
<html>
    <head>
        <% /* Proper way to get a reqest param in only EL */ %>
        <title>Hello, <c:out value="${param.name}" default="You" /></title>
    </head>
    <body>
        <h1>Hello, <%= name %></h1>
        <p>"<%= name %>" is raw output -- vulnerable</p>

        <h1>Hello, <c:out value="${param.name}" default="You" /></h1>
        <p>"<c:out value="${param.name}" default="You" />" is escaped</p>

        <hr />

        <p>You can set variables with JSTL as well.</p>
        <pre>
        &lt;c:set var="name" value="\${param.name}" /&gt;
        </pre>

        <p>That in action</p>

        <c:set var="name" value="${param.name}" />

        <h1>Hello, <c:out value="${name}" default="You" /></h1>
        <p>"<c:out value="${name}" default="You" />" was a variable set with <code>&lt;c:set /&gt;</code></p>

    </body>
</html>
