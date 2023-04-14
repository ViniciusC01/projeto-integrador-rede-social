<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
    <h2>Hello <%= request.getAttribute("curso") %> !</h2>
     <form action="/" method="post">
            <button type="submit">Voltar para home</button>
     </form>
</body>
</html>