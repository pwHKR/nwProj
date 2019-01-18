<%@ page import="Hibernate.Entity.Account" %>
<%@ page import="Hibernate.Manage.ManageAccount" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-18
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%


    ManageAccount manageAccount = new ManageAccount();


    ArrayList<Account> accountArrayList;

    accountArrayList = manageAccount.listUserAccount();

    for(Account a : accountArrayList){

        out.println("----------------");
        %><br /><%
        out.println("Username: " + a.getUsername()
                +"\nid: "+a.getId()
                +"\nisBanned? " + a.getIsBan());
        %><br/><%
       out.println("----------------");

    }%>
