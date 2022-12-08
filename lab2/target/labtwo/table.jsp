<%@ page import="utils.TableRow" %><%--
  <%--
  Created by IntelliJ IDEA.
  User: artemiy
  Date: 19.11.2022
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>History</title>
  <link rel="stylesheet" href="css/table.css" type="text/css">
</head>
<body>
<header style="font-family: monospace">
  Соловьев Артемий Александрович, P32151,<br>№124421
</header>
<main>
  <div class="table mt-75">
    <div class="row">
      <div class="cell header c15 mc15 sc20">X</div>
      <div class="cell header c15 mc15 sc20">Y</div>
      <div class="cell header c15 mc15 sc20">R</div>
      <div class="cell header c15 mc20 sc40">Status</div>
      <div class="cell header c40 mc35 sc0">Time</div>
    </div>
    <jsp:useBean id="table" type="utils.TableBean" scope="session" >
    </jsp:useBean>

    <% if (table != null) { for (TableRow row : table.asList()) { %>
    <div class="row">
      <div class="cell c15 mc15 sc20"><%=row.getX()%></div>
      <div class="cell c15 mc15 sc20"><%=row.getY()%></div>
      <div class="cell c15 mc15 sc20"><%=row.getR()%></div>
      <div class="cell c15 mc20 sc40"><%=row.getStatus()%></div>
      <div class="cell c40 mc35 sc0"><%=row.getTime()%></div>
    </div>
    <% }} %>


    <div class="row">
      <a class="btn secondary" style="margin-top: 20px" href="main.jsp">Добавить</a>
    </div>

  </div>
</main>
</body>
</html>