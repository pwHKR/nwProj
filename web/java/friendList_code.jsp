<%@ page import="Hibernate.Entity.Person" %>
<%@ page import="Hibernate.Manage.ManageFriend" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: woojen
  Date: 2019-01-19
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%


    Cookie[] cookies;
    cookies = request.getCookies();

    String d = "";

    for(Cookie c : cookies){

        System.out.println("name: "+c.getName());

        if(c.getName().equalsIgnoreCase("name")){
          d =  c.getValue();}

        System.out.println("value: "+c.getValue());
    }
    ManageFriend manageFriend = new ManageFriend();
    try{
    ArrayList<Person> friends;
    friends = manageFriend.tempGetFriendList(d);

    for(Person p: friends){

        out.print(p.getFirstName() + " "+p.getLastName());

        %><br /><%
    }

}catch(NullPointerException e){e.printStackTrace();}


%>
