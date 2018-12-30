<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Access</title>
    <script type="text/javascript" src="res/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="res/semantic/semantic.js"></script>
    <script type="text/javascript" src="res/js/database.js">      </script>
    <script src="res/js/ui.js" type="text/javascript">            </script>
    <script src="res/js/alert.js" type="text/javascript">            </script>
    <link href="res/semantic/semantic.min.css" rel="stylesheet" type="text/css"/>
    <link href="res/semantic/components/icon.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="ui two column doubling stackable grid container">
    <div class="column">
    <form class="ui form" action="<c:url value="/acces"/>" method="post" >
        <h2 class="ui orange header">Access</h2>
        <c:if test="${param.error != null}">
            <div class="ui red header">
                Username e password is invalid.
            </div>
        </c:if>
        <c:if test="${param.logout != null}">
            <div class="ui green header">
               You are log out.
            </div>
        </c:if>
        <p>
        <div class="ui left icon input">
            <input type="text" placeholder="Insert username..." id="username" name="username" class="form-control" placeholder="Username" required autofocus />
            <i class="user icon"></i>
        </div>
        </p>
        <p>
        <div class="ui left icon input">
            <input type="password" placeholder="" id="password" name="password" class="form-control"  required autocomplete="password"/>
            <i class="lock icon"></i>
        </div>
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        </p>
        <button class="ui secondary button" type="submit">
            Okay
        </button>
    </form>
    </div>
    <div class="column">
        <div class="ui twelve row">
            <div class="row">
        <h2 class="ui violet header">Register new user</h2> <br>
            </div>
            <div class="column">
            <div class="ui left icon input">
                <input type="password" placeholder="" id="newpassword" name="password" class="form-control"  required autocomplete="password"/>
                <i class="lock icon"></i>
            </div>   <div class="row"><br></div> </div>

                <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert username..." id="newusername" name="username" class="form-control" placeholder="Username" required autofocus />
                <i class="user icon"></i>
            </div> <div class="row"><br></div> </div>

                    <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert firstname..." id="firstname" name="username" class="form-control" placeholder="Username" required autofocus />
                <i class="address book icon"></i>
            </div>  <div class="row"><br></div> </div>

                        <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert lastname..." id="lastname" name="username" class="form-control" placeholder="Username" required autofocus />
                <i class="address book icon"></i>
            </div> <div class="row"><br></div> </div>

                            <div class="row">
            <div class="ui left icon input">
                <input type="text" placeholder="Insert email..." id="email" name="username" class="form-control" placeholder="Username" required autofocus email />
                <i class="envelope icon"></i>
            </div> <div class="row"><br></div> </div>

                                <div class="row">
            <button class="ui button" onclick="Database.saveUser()" >
                Register
            </button> <div class="column"><br></div>
                                </div><div class="column"><br></div>
    </div>
    </div>
</div>
</body>
</html>