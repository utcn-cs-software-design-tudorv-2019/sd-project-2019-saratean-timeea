<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="hello.entities.Room" %>


<%@ page import="hello.dataAccess.RoomAccess" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Client page</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="../css/index.css">
<style>
.container{
position: fixed; /* or absolute */
  top: 5%;
  left: 10%;
}
body {
  margin: 200;
  font-family: Calibri, Gadget, sans-serif;
}


</style>
</head>
<div class="card-header" style="background:Plum">
              <h2 class="text-left my-auto font-weight-light">List of rooms</h2>
            </div>
<body>
<div class="hero-image">
	<div class="container">
	
        <div class="row justify-content-center align-items-center" id="central">
          <div class="card" style="width: 35rem;">
            
              <div class="card-body">
                
                <table class="table">
                <thead>
                <tr>
                <th>Number</th>
                <th>Hotel</th>
                <th>Price</th>
                <th>Capacity</th>
                <th>Rent</th>
                </tr>
                </thead>
                <tbody>
                <%
                
                List<Room> rooms=(List<Room>)request.getAttribute("rooms");
                Room room=new Room();
                Iterator<Room> iterator=rooms.iterator();
                int i=0;
                RoomAccess roomAccess=new RoomAccess();
                
                %>
                <tr >
                <% while(iterator.hasNext()){
                	i++;
                	room=iterator.next();
                	System.out.println(room.getNumber());
                	
                %>
                    <td><%=room.getNumber() %></td>
                    <td><%=room.getHotel() %></td>
                    <td><%=room.getPrice() %></td>
                    <td><%=room.getCapacity() %></td>
                     
                    <td> <form:form class="form-signin" method="POST" action="/Hoteluri/deleteRoom2">
                    <input name="id" type="hidden" value="<%=room.getNumber()%>"/>
                    <button class="btn btn-sm btn-default btn-block mt-4" type="submit"  >Rent This!</button>
                              
                  </form:form> 
                    </td>
                </tr>

                <%}%>
                </tbody>
                </table> 
                  
              </div>
          </div>
        </div>
    </div>
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</div>
</body>
</html>