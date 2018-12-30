<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="res/js/ui.js" type="text/javascript"></script>
<div class="ui secondary menu">
    <a href="<c:url value="/buyProduct"/>" class="item" id="1">
        Buy Product
    </a>
    <a href="<c:url value="/updateInfo"/>"class="item" id="2">
        Update Personal Info
    </a>
    <a href="<c:url value="/"/>" class="item" id="3">
        Index
    </a>
    <div class="right menu">

        <form class="ui form" action="<c:url value="/logout"/>" method="post">
            <input type="hidden"
                   name="${_csrf.parameterName}"
                   value="${_csrf.token}"
            />
            <button class="ui inverted red button" type="submit">
            <i class="power off icon"></i>
                Logout
            </button>
        </form>

    </div>
</div>