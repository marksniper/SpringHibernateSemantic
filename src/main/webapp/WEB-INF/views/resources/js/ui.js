$(document).ready(function () {
    var nomePagina = window.location.pathname.split("/")[2];
    // console.log("Sei nella pagina: "+nomePagina);
    var database = Database;
    if (nomePagina == "" || nomePagina == "index" ) {
              $('#3').attr('class', 'active item');

              database.getUserInfo(function (data) {
                  $('#name').text("Name: "+data['firstname']+" "+data['lastname']);
                  $('#email').text("Email: "+data['email']);
              }, function (error) {
                  $('#name').text("error");
              });
              database.getTest("","","",
                  function (data) {
                      console.log("data"+JSON.stringify(data));

                  }, function (err) {
                      console.log("err: "+JSON.stringify(err));
                  });
              database.getAllPurchases(function (data) {
                  console.log("data"+JSON.stringify(data));
                  var dataJSON = JSON.parse(JSON.stringify(data));
                  var dataJSON =   dataJSON['buysDataList'];
                  console.log("dataJSON"+dataJSON);
                  if(dataJSON.length == 0){
                      $('#buytable')[0].children[0].remove();
                      $('#buytable')[0].append("Nothing to Show");
                  }else{
                      var row ="";
                      for(i=0; i <dataJSON.length ; i++){
                          console.log("data: "+dataJSON[i]['name']);
                          row += " <tr>";

                          row += "<th>";
                          row +=dataJSON[i]['name'] ;
                          row += "</th>";
                          row += "<th>";
                          row +=dataJSON[i]['date'] ;
                          row += "</th>";
                          row += "<th>";
                          row +=dataJSON[i]['price'] ;
                          row += "</th>";
                          row += "<th>";
                          row +=dataJSON[i]['quantity'] ;
                          row += "</th>";
                          row += "<th>";
                          row +=  "<div onclick='Database.deleteBuy(\""+dataJSON[i]['date']+"\")'> <i class=\"red close icon\"></i></div> " ;
                          row += "</th>";
                          row += " </tr>";
                      }
                      $('#bodytable').html(row);
                  }

              }, function (err) {
                  console.log("err"+ JSON.stringify(err));
              });
    }
    if (nomePagina == "updateInfo"  ){
        $('#2').attr('class', 'active item');
        database.getUserInfo(function (data) {
            $('#firstname').val(""+data['firstname']);
            $('#lastname').val(""+data['lastname']);
            $('#newusername').val(""+data['username']);
            $('#email').val(""+data['email']);
            $('#newpassword').val(""+data['password']);
        }, function (error) {
            $('#name').text("error");
        });
    }
    if (nomePagina == "buyProduct"  ) {
        $('#1').attr('class', 'active item');
        database.getAllProduct(function (data) {
            console.log("data" + JSON.stringify(data));
            var dataJSON = JSON.parse(JSON.stringify(data));
            console.log("dataJSON" + dataJSON);
            if (dataJSON.length == 0) {
                $('#producttable')[0].children[0].remove();
                $('#producttable')[0].append("Nothing to Show");
            } else {
                var row = "";
                for (i = 0; i < dataJSON.length; i++) {
                    console.log("data: " + dataJSON[i]['name'])
                    row += " <tr>";

                    row += "<th>";
                    row += dataJSON[i]['name'];
                    row += "</th>";
                    row += "<th>";
                    row += dataJSON[i]['price'];
                    row += "</th>";
                    row += "<th>";
                    row += dataJSON[i]['quantity'];
                    row += "</th>";
                    row += "<th>";
                    row += "<div onclick='Database.buyProduct(\"" + dataJSON[i]['idProduct'] + "\")'> <i class=\"blue shopping cart icon\"></i></div> ";
                    row += "</th>";
                    row += " </tr>";
                }
                $('#bodytable').html(row);
            }
        }, function (err) {
            console.log("err" + JSON.stringify(err));
        });
    }
});
