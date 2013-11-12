<%@page import="java.net.URL"%>
<%@page
	import="com.mongodb.*, java.util.*, org.springframework.web.context.WebApplicationContext, org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="application.css" />
<title>Samurai Swap!!</title>
</head>
<body>
	<h1>Test Page</h1>
	<br /> MongoDB "test" Database:
	<ul>
		<%
			WebApplicationContext ctx = WebApplicationContextUtils
					.getWebApplicationContext(application);

			DB db = ctx.getBean("db", com.mongodb.DB.class);
			Set<String> colls = db.getCollectionNames();
			for (String s : colls) {
		%>
		<li>Collection: <%=s%></li>
		<%
			}
			DBCursor cursor = db.getCollection("test").find();
			while (cursor.hasNext()) {
				DBObject o = cursor.next();
		%>
		<li>Collection "test", record: <%=o%></li>
		<%
			}
		%>
	</ul>
</body>
</html>