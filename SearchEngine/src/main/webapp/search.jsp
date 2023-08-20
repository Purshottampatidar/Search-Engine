<%@page import= "java.util.ArrayList"%>
<%@page import= "com.Engine.SearchResults"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

    <div class="form-div">
            <div class="button-container1"></div>
            <form action="Search">
              <input type="text" style="font-size: 1.1rem;" placeholder="search you favourite topic" name="keyword">
              <button type="submit" class="search">Search</button>
            </form>
    </div>

    <table border=2  class="table-result">
         <tr>
              <th>Title</th>
              <th>Link</th>
         </tr>
         <%
             ArrayList<SearchResults> results= (ArrayList<SearchResults>)request.getAttribute("results");
             for(SearchResults result:results){
         %>
         <tr>
            <td><%out.println(result.getTitle());%></td>
            <td><a href="<%out.println(result.getLink());%>"><%out.println(result.getLink());%></a></td>
         </tr>
         <%
            }
         %>
    </table>

</body>
</html>