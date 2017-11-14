const https = require('https');
var parser = require('json-parser');
var mysql = require('mysql');
 
/*https.get('https://api.thingspeak.com/channels/354885/feeds.json?api_key=NMB2VV1N49VBA6RG&results=2', (resp) => {
  //let data = '';
 //console.log(resp.data);
  // A chunk of data has been recieved.
  resp.on('data', (chunk) => {
    data += chunk;
  });
 
  // The whole response has been received. Print out the result.
  resp.on('end', () => {
    console.log(JSON.parse(data).explanation);
  });

  resp.on('data', (d) => {
    var data = process.stdout.write(d);

    
    console.log(data);

    var JSONdata1 = parser.parse(data);

    console.log(JSONdata1);

   /* var f1 = JSONdata1["feeds"];
    console.log(f1);*/
    /*var f2 = data["feeds"][0]["field2"];
    console.log(f2);

    //console.log();
  });
 
}).on("error", (err) => {
  console.log("Error: " + err.message);
});
*/

var url = 'https://api.thingspeak.com/channels/354885/feeds.json?api_key=NMB2VV1N49VBA6RG&results=2';

https.get(url, function(res){
    var body = '';

    res.on('data', function(chunk){
        body += chunk;
    });

    res.on('end', function(){
        var fbResponse = JSON.parse(body);
        console.log(fbResponse);
		var datafield1 = fbResponse.feeds[0].field1;
		var datafield2 = fbResponse.feeds[0].field2;
		var dataid = fbResponse.channel.id;
        console.log("Got a response: ", fbResponse.feeds[0].field1);
		console.log("Got a response: ", fbResponse.feeds[0].field2);
		console.log("Got a response: ", fbResponse.channel.id);
		//console.log("ID: ", fbResponse.feeds[0].id);
    });
}).on('error', function(e){
      console.log("Got an error: ", e);
});



var mysql = require('mysql');

var con = mysql.createConnection({
  host: "localhost",
  user: "id3411588_data_text",
  password: "priyameet",
  database: "id3411588_data"
});

/*con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
  //var sql = "INSERT INTO customers (name, address) VALUES ('Company Inc', 'Highway 37')";
  //con.query(sql, function (err, result) {
  //  if (err) throw err;
  //  console.log("1 record inserted");
  //});
});*/


con.connect(function(err) {
  if (err) throw err;
  console.log("Connected!");
});


