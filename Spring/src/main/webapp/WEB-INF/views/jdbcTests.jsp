<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	${tableName} 
</h1>



<P>  INSERT TEST:<BR>NEW ID: ${insert} </P>
<P>  selectById test:<br>${selectById} </P>
<P>  update test:<br>lignes modifiés: ${update} <br>
ligne après update: ${resultatUpdate}</P>
<P>  selectAll test:<br>nombre de lignes: ${selectAll} <br>
permiere ligne selectionnée: ${ligne1} </P>
<P>  selectWhere avec ${condition}  test:<br>nombre de lignes: ${selectWhere} <br>
permiere ligne selectionnée: ${ligne11} </P>
<%-- <P>  deleteById ${insert} test:<br>lignes supprimés: ${deleteById}</P> --%>


<P>  debug line:<BR> ${debugLine} </P>
</body>
</html>
