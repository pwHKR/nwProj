<%@ page import="Hibernate.Manage.ManageNews" %><%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-17
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<% ManageNews manageNews = new ManageNews();

out.print(manageNews.getRecentNews());
%>
