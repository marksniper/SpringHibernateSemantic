
    Database  = {
        /*
         * Global Settings and Variables
         * token and header are needed to prevent CRSF
         */
        base_url: "http://localhost:8080/"+location.pathname.split('/')[1],
        //test
        getTest: function (option, option1 , option2, callback, failure)
        {
            //init operation
           /* console.log("ServiceIndex >>> option: "+option);
            console.log("ServiceIndex >>> option1: "+option1);
            for (i = 0; i < option2.length; i++)
            {
                console.log((i+1) + ": " + option2[i]);
            }*/
            /*http://localhost:8080/Database_1_0_SNAPSHOT_war/user/test */
            //create ajax call
            $.ajax({
                url: Database.base_url+"/user/test",
                type: "GET",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                async: true,
                crossDomain: true,
                success: function (data)
                {
                    console.log("data " + (JSON.stringify(data)));
                    callback (data);
                },
                error: function (err)
                {
                   console.log("data " + (JSON.stringify(err)));
                    failure( err);
                }
            });
        },
        getAllPurchases: function(callback, failure)
        {
            $.ajax({
                url: Database.base_url+"/user/purchases",
                type: "GET",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                async: true,
                crossDomain: true,
                success: function (data)
                {
                    console.log("data " + (JSON.stringify(data)));
                    callback( data);
                },
                error: function (err)
                {
                    console.log("data " + (JSON.stringify(err)));
                    failure(err);
                }
            });
        },
        saveUser: function () {
            var obj = new Object();
            obj.firstname =  $('#firstname').val();
            obj.lastname  = $('#lastname').val();
            obj.password = $('#newpassword').val();
            obj.username = $('#newusername').val();
            obj.email = $('#email').val();
            console.log( JSON.stringify(obj));

            $.ajax({
                url: Database.base_url+"/registration/save",
                type: "POST",
                data: JSON.stringify(obj) ,
                headers: {
                    "Content-Type": "application/json",
                    "cache-control": "no-cache"
                },
                async: true,
                processData: false,
                crossDomain: true,
                success: function (data)
                {
                    console.log("data " + (JSON.stringify(data)));
                    $.Alert({
                        textHead: 'Your user registration was successful.',
                        text: 'You may now log-in with the username you have chosen',
                        bgcolor: '#19c3aa',
                        textcolor: '#fff',
                        position: 'top-right',
                        icon: 'checkmark box',
                        time: 3
                    });
                    $('#firstname').val("");
                    $('#lastname').val("");
                    $('#newpassword').val("");
                    $('#newusername').val("");
                    $('#email').val("");
                },
                error: function (err)
                {
                    console.log("data " + (JSON.stringify(err)));
                    $.Alert({
                        textHead: 'Error',
                        text: 'An error is occur when new user is creating',
                        bgcolor: '#ff0000',
                        textcolor: '#000000',
                        position: 'top-center',
                        icon: 'remove circle',
                        time: 3
                    });
                }
            });
        },
        getUserInfo: function(callback, failure)
        {
            $.ajax({
                url: Database.base_url+"/user/info",
                type: "GET",
                headers: {
                    "cache-control": "no-cache"
                },
                async: true,
                crossDomain: true,
                success: function (data)
                {
                    console.log("data " + (JSON.stringify(data)));
                    callback (data);
                },
                error: function (err)
                {
                    console.log("data " + (JSON.stringify(err)));
                    failure (err);
                }
            });
        },
        deleteBuy: function(idBuy){
            console.log("Delete: "+idBuy);
            $.ajax({
                url: Database.base_url+"/user/delete/"+idBuy,
                type: "GET",
                headers: {
                    "cache-control": "no-cache"
                },
                async: true,
                crossDomain: true,
                success: function (data)
                {
                    console.log("data " + (JSON.stringify(data)));
                    $.Alert({
                        textHead: 'Your user registration was successful.',
                        text: 'You may now log-in with the username you have chosen',
                        bgcolor: '#19c3aa',
                        textcolor: '#fff',
                        position: 'top-right',
                        icon: 'checkmark box',
                        time: 3
                    });
                    window.location.reload();
                },
                error: function (err)
                {
                    console.log("data " + (JSON.stringify(err)));
                    $.Alert({
                        textHead: 'Error',
                        text: 'An error is occur when buy is deleting ['+ idBuy+"]",
                        bgcolor: '#ff0000',
                        textcolor: '#000000',
                        position: 'top-center',
                        icon: 'remove circle',
                        time: 3
                    });
                }
            });
        },
        updateUserInfo: function(){
            var obj = new Object();
            obj.firstname =  $('#firstname').val();
            obj.lastname  = $('#lastname').val();
            obj.password = $('#newpassword').val();
            obj.username = $('#newusername').val();
            obj.email = $('#email').val();
            console.log( JSON.stringify(obj));
            console.log("url: "+ Database.base_url+"/user/update");
            $.ajax({
                url: Database.base_url+"/user/update",
                type: "POST",
                data: JSON.stringify(obj) ,
                headers: {
                    "Content-Type": "application/json",
                    "cache-control": "no-cache"
                },
                async: true,
                processData: false,
                crossDomain: true,
                success: function (data)
                {
                    console.log("data " + (JSON.stringify(data)));
                    $.Alert({
                        textHead: 'Your user information was update',
                        text: 'Rember to log in the system with new username and password',
                        bgcolor: '#19c3aa',
                        textcolor: '#fff',
                        position: 'top-right',
                        icon: 'checkmark box',
                        time: 3
                    });
                    window.location.href = Database.base_url+ "/log";
                },
                error: function (err)
                {
                    console.log("data " + (JSON.stringify(err)));
                    $.Alert({
                        textHead: 'Error',
                        text: 'An error is occur when user infromation is updating',
                        bgcolor: '#ff0000',
                        textcolor: '#000000',
                        position: 'top-center',
                        icon: 'remove circle',
                        time: 3
                    });
                }
            });
        },
        addProduct : function () {
            var obj = new Object();
            obj.name =  $('#productname').val();
            obj.quantity  = $('#productprice').val();
            obj.price = $('#productquantity').val();
            console.log( JSON.stringify(obj));
            $.ajax({
                url: Database.base_url+"/user/addproduct",
                type: "POST",
                data: JSON.stringify(obj) ,
                headers: {
                    "Content-Type": "application/json",
                    "cache-control": "no-cache"
                },
                async: true,
                processData: false,
                crossDomain: true,
                success: function (data)
                {
                    console.log("data " + (JSON.stringify(data)));
                    $.Alert({
                        textHead: 'Product add',
                        text: 'The product is adding to list',
                        bgcolor: '#19c3aa',
                        textcolor: '#fff',
                        position: 'top-right',
                        icon: 'checkmark box',
                        time: 3
                    });
                    window.location.reload();
                },
                error: function (err)
                {
                    console.log("data " + (JSON.stringify(err)));
                    $.Alert({
                        textHead: 'Error',
                        text: 'An error is occur when user infromation is updating',
                        bgcolor: '#ff0000',
                        textcolor: '#000000',
                        position: 'top-center',
                        icon: 'remove circle',
                        time: 3
                    });
                }
            });

        },
        getAllProduct : function (callback, failure) {
            $.ajax({
                url: Database.base_url+"/user/getProducts",
                type: "GET",
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                async: true,
                crossDomain: true,
                success: function (data)
                {
                    console.log("data " + (JSON.stringify(data)));
                    callback( data);
                },
                error: function (err)
                {
                    console.log("data " + (JSON.stringify(err)));
                    failure(err);
                }
            });
        },
        buyProduct : function (idProduct) {
            console.log("id Product: "+idProduct);
            $.ajax({
                url: Database.base_url + "/user/buy/" + idProduct,
                type: "GET",
                headers: {
                    "cache-control": "no-cache"
                },
                async: true,
                crossDomain: true,
                success: function (data) {
                    console.log("data " + (JSON.stringify(data)));
                    $.Alert({
                        textHead: 'Your user registration was successful.',
                        text: 'You may now log-in with the username you have chosen',
                        bgcolor: '#19c3aa',
                        textcolor: '#fff',
                        position: 'top-right',
                        icon: 'checkmark box',
                        time: 3
                    });
                    window.location.reload();
                },
                error: function (err) {
                    console.log("data " + (JSON.stringify(err)));
                    $.Alert({
                        textHead: 'Error',
                        text: 'An error is occur when buy is deleting [' + idBuy + "]",
                        bgcolor: '#ff0000',
                        textcolor: '#000000',
                        position: 'top-center',
                        icon: 'remove circle',
                        time: 3
                    });
                }
            });

        }
    };