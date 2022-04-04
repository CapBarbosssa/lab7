<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    </head>
    <body>
        
        
        <div class="container">
            <div class="row">
                <div class="col">
                    <h1>User Management System</h1>
                    
                    <table class="table">
                        <thead>
                            <tr>
                                <th>E-mail</th>
                                <th>First name</th>
                                <th>Last name</th>
                                <th>Active</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>${user.email}</td>
                                    <td>${user.firstName}</td>
                                    <td>${user.lastName}</td>
                                    <td>${user.active ? "Y" : "N"}</td>
                                    <td>
                                        <a href="user?action=update&email=${user.email}">Edit</a>
                                        <a href="user?action=delete&email=${user.email}">Delete</a>
                                        
                                    </td>
                                </tr>
                            </c:forEach>
                      
                                <form action="user" method="post">
                                    <table>
                                        <tr>
                                            <td><input type="text" name="newEmail" placeholder="Email"></td>
                                            <td><input type="text" name="newfName" placeholder="Fisrt name"></td>
                                            <td><input type="text" name="newlName" placeholder="Last name"></td>
                                            <td><input type="text" name="newrole" placeholder="Role"></td>
                                            <td><input type="text" name="newactive" placeholder="Active"></td>
                                            <td>
                                                <input type="hidden" name="action" value="add">
                                                 <button type="submit">Submit</button>
                                            </td>
                                        </tr>
                                    </table>
                                </form>
                           
                        </tbody>
                    </table>
                   
          
            <form action="user" method="post">
                 <table>
                    <tr>
               
                        <td><input type="text" name="updateemail" value="${updateUser.email}" readonly>Email</td>                        
                        <td><input type="text" name="updatefName" value="${updateUser.firstName}">First name</td>
                        <td><input type="text" name="updatelName" value="${updateUser.lastName}">Last name</td>
                        <td><input type="text" name="updaterole" value="${updateUser.role.roleId}">Role</td>
                        <td><input type="text" name="updateactive" value="${updateUser.active}">Active</td>
                        <td>
                            <input type="hidden" name="action" value="update">
                            <button type="submit">Submit</button>

                        </td>
                    </tr>
                </table>
            </form>
                </div>
            </div>
        </div>

    </body>
</html>
