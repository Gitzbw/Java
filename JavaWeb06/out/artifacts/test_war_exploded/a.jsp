<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.Person" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2022/7/25
  Time: 10:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%
    Person person = new Person();
    person.setName("国哥好帅！");
    person.setPhones(new String[]{"18610541354","18688886666","18699998888"});
    List<String> cities = new ArrayList<String>();
    cities.add("北京"); cities.add("上海"); cities.add("深圳");
    person.setCities(cities);
    Map<String,Object> map = new HashMap<>();
    map.put("key1","value1");
    map.put("key2","value2");
    map.put("key3","value3");
    person.setMap(map);
    pageContext.setAttribute("p", person);
%>

${p.map.key1}
${p.map.get("key1")}
${p.test}



</body>
</html>
