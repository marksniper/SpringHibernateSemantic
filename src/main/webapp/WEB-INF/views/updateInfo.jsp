<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta charset="UTF-8">
    <script type="text/javascript" src="res/jquery-3.3.1.min.js" ></script>
    <script type="text/javascript" src="res/semantic/semantic.js"></script>
    <script type="text/javascript" src="res/js/database.js">      </script>
    <script type="text/javascript" src="res/js/ui.js">            </script>
    <script type="text/javascript" src="res/js/alert.js" >        </script>
    <link href="res/semantic/semantic.min.css" rel="stylesheet" type="text/css"/>
    <link href="res/semantic/components/icon.min.css" rel="stylesheet" type="text/css"/>
    <title>Update Personale Info</title>
</head>
<body>
<nav>
    <%@include file="static/menu.jsp" %>
</nav>
<div class="ui one column stackable center aligned page grid">
<div class="column">
    <div class="ui seven row">
        <div class="row">
            <h2 class="ui violet header">Update your info</h2> <br>
        </div>
        <div class="column">
            <div class="ui left icon input">
                <input type="password" placeholder="" id="newpassword" name="password" class="form-control"  required autocomplete="password"/>
                <i class="lock icon"></i>
            </div> <div class="row"><br></div>

            <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert username..." id="newusername" name="username" class="form-control" placeholder="Username" required autofocus />
                <i class="user icon"></i>
            </div> <div class="row"><br></div>

            <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert firstname..." id="firstname" name="username" class="form-control" placeholder="Username" required autofocus />
                <i class="address book icon"></i>
            </div>  <div class="row"><br></div>

            <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert lastname..." id="lastname" name="username" class="form-control" placeholder="Username" required autofocus />
                <i class="address book icon"></i>
            </div> <div class="row"><br></div>
        <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert email..." id="email" name="username" class="form-control" placeholder="Username" required autofocus email />
                <i class="envelope icon"></i>
            </div> <div class="row"><br></div>

        <div class="row">
            <button class="ui button" onclick="Database.updateUserInfo()" >
                Update
            </button>
        </div>
    </div>
</div>
</div>
</body>
</html>
