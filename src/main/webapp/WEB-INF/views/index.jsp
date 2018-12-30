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
    <title>Home</title>
</head>
<body>
<nav>
    <%@include file="static/menu.jsp" %>
</nav>
<div class="ui two column doubling stackable grid container">
    <div class="column">
        <div class="ui card">
            <div class="content">
                <div class="header" id="name"></div>
            </div>
            <div class="content">
                <h4 class="ui sub header">Information</h4>
                <div class="ui small feed">
                    <div class="event">
                        <div class="content">
                            <div class="summary" id="email">

                            </div>
                        </div>
                    </div>
                     <div class="extra content">
                         <a class="btn" href="<c:url value="/updateInfo"/>"><button class="ui button">Change your personal information</button></a>
                     </div>
                </div>
            </div>
        </div>
    </div>
<div class="column" id="buytable">
    <table class="ui celled padded table">
        <thead>
        <tr><th>Name</th>
            <th>Date</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Remove</th>
        </tr>
        </thead>
            <tbody id ="bodytable">
        </tbody>
    </table>
</div>
</div>
</body>
</html>