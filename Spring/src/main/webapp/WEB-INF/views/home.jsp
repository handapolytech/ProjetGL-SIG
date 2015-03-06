<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<P>  insert test:<br>new id: ${insert} </P>
<P>  selectById test:<br>${selectById} </P>
<P>  update test:<br>lignes modifiés: ${update} <br>
ligne après update: ${resultatUpdate}</P>
<P>  selectAll test:<br>nombre de lignes: ${selectAll} <br>
permiere ligne selectionnée: ${ligne1} </P>
<P>  selectWhere avec ${condition}  test:<br>nombre de lignes: ${selectWhere} <br>
permiere ligne selectionnée: ${ligne11} </P>
<P>  deleteById ${insert} test:<br>lignes supprimés: ${deleteById}</P>


</body>
</html>
