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
    <title>Buy Product</title>
</head>
<body>
<nav>
    <%@include file="static/menu.jsp" %>
</nav>
<div class="ui two column doubling stackable grid container">
    <div class="column">
        <div class="row">
            <h2 class="ui orange header">Create new product</h2>
        </div>
        <div class="row"><br></div>
        <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert name..." id="productname" name="name" class="form-control" placeholder="name" required autofocus />
                <i class="info icon"></i>
            </div>
        <div class="row"><br></div> </div>
        <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert price..." id="productprice" name="price" class="form-control" placeholder="price" required autofocus />
                <i class="info icon"></i>
            </div>
            <div class="row"><br></div> </div>
        <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert quantity ..." id="productquantity" name="quantity" class="form-control" placeholder="quantity" required autofocus />
                <i class="info icon"></i>
            </div>
            <div class="row"><br></div> </div>
        <div class="row">
            <button class="ui button" onclick="Database.addProduct()" >
                Add product
            </button>
        </div>
    </div>
    <div class="column">
        <div class="column" id="producttable">
            <table class="ui celled padded table">
                <thead>
                <tr><th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Buy</th>
                </tr>
                </thead>
                <tbody id ="bodytable">
                </tbody>
            </table>
        </div>

    </div>
</div>

</body>
</html>
