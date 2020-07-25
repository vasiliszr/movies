var userID=null;

function redirection(){
	userID=sessionStorage.getItem("ID")
	if(userID>0){
		window.location.replace('http://localhost:8080/home');
	}
}

function mainFunction () {
	$('#Page').empty();

	console.log( userID=sessionStorage.getItem("ID"))
	var movie = document.getElementById("myText").value;
	document.getElementById("demo").innerHTML = movie;
	var pageNumber = 1;

	apiCall(movie,pageNumber);
}

function apiCall(movie,pageNumber) {
	$('#demo').empty();
	$('#Page').empty();
	$('#img').empty();
	$('#details').empty();
	$('#intro').empty();
    userID=sessionStorage.getItem("ID");
	$.getJSON('https://www.omdbapi.com/?&apikey=c5d43602&s=' + encodeURI(movie)+ '&page='+encodeURI(pageNumber)).then(function(response) {
		console.log(response);
		let i;
		for (i=0; i < response.Search.length; i++) {
			$('#demo').append('<p><strong>' + response.Search[i].Title + ' (' + response.Search[i].Year + ')</strong></p>');
			if(response.Search[i].Poster == "N/A"){
				$('#demo').append('<img src="images/pic1.jpg"><br>');
			}else {
				$('#demo').append('<img src="' + response.Search[i].Poster + '"><br>');
			}
			let ID = response.Search[i].imdbID;
			let Title = response.Search[i].Title;
			$('#demo').append(('<button onclick="moreInformation(\'' + ID + '\',\'' + pageNumber + '\',\'' + 1 + '\')">More Information</button>'));
			$('#demo').append(('<button onclick="savemovie( userID,\'' + ID + '\',\'' + Title +'\')">Add to MyBookmarks</button>'));
		}

		if (pageNumber>1) {
			$('#Page').append(('<button id =button1 onclick="previousPage(\'' + pageNumber +'\')">Previous Page</button>'));
		}

		if (response.Search.length==10) {
			$('#Page').append(('<button id =button2 onclick="nextPage(\'' + pageNumber +'\')">Next Page</button>'));
		}
	});
}

function moreInformation(ID,pageNumber,session) {
	$('#demo').empty();
	$('#Page').empty();
	$('#img').empty();
	$('#details').empty();
	$('#intro').empty();

	console.log(ID);

	$.getJSON('https://www.omdbapi.com/?&apikey=c5d43602&i=' + encodeURI(ID)).then(function(response) {
		console.log(response);
		if(response.Poster == "N/A"){
			$('#img').append('<img src="images/pic1.jpg"><br>');
		}else {
			$('#img').append('<img src="' + response.Poster + '">');
		}
		$('#details').append('<p> <strong> Movie Title: </strong>'+ response.Title + '</p>');
		$('#details').append('<p> <strong> Released in: </strong>' + response.Released + '</p>');
		$('#details').append('<p> <strong> Actors: </strong>' + response.Actors + '</p>');
		$('#details').append('<p> <strong> Writers: </strong>' + response.Writer + '</p>');
		$('#details').append('<p> <strong> Director: </strong>'+ response.Director + '</p>');
		$('#details').append('<p> <strong> Genre: </strong>'+ response.Genre + '</p>');
		$('#details').append('<p> <strong> Plot: </strong>' + response.Plot + '</p>');
		$('#details').append('<p> <strong> Runtime: </strong>' + response.Runtime + '</p>');
		$('#details').append('<p> <strong> Awards: </strong>'+ response.Awards + '</p>');
		$('#details').append('<p> <strong> IMDB Rating: </strong>' + response.imdbRating + '</p>');
		$('#details').append('<p> <strong> Metascore: </strong>'+ response.Metascore + '</p>');

		var movie = document.getElementById("myText").value;
		console.log(movie);
		console.log(pageNumber);
		if (session == 1) {
			$('#Page').append(('<button onclick="apiCall(\'' + movie + '\',\'' + pageNumber + '\')">Go Back</button>'));
		} else if (session == 2) {
			$('#Page').append(('<button onclick="bookmarks()">Go Back</button>'));
		}

	});
}

function nextPage(pageNumber) {
	pageNumber++;
	let movie = document.getElementById("myText").value;
	apiCall(movie, pageNumber);
}

function previousPage(pageNumber) {
	pageNumber--;
	let movie = document.getElementById("myText").value;
	apiCall(movie, pageNumber);
}

function register() {
	let email = document.getElementById("email_reg").value;
	let password = document.getElementById("psw_reg").value;
	let password2 = document.getElementById("psw-repeat").value;
	let credentials = {"email": email, "password": password};
	if(email!="" && password!="" && password2===password) {
		let xhr = new XMLHttpRequest();
		xhr.open('POST', 'http://localhost:8080/register', false);
		xhr.setRequestHeader("Content-Type", "application/json");
		xhr.send(JSON.stringify(credentials));
	}else if(password2!==password){
		$("#exp").append("<p> Please try again! Passwords do no match.</p>")
	}else{
		$("#exp").append("<p> Please try again! Something went wrong</p>")
	}
}

function login() {
	let email = document.getElementById("email_log").value;
	let password = document.getElementById("psw_log").value;
	let credentials = {email: email, password: password};
	let id;
	let xhr = new XMLHttpRequest();
	let url = "http://localhost:8080/login";
	xhr.open("POST", url, false);
	xhr.setRequestHeader("Content-Type", "application/json");
	xhr.onreadystatechange = function() {
		document.getElementById("exp").innerHTML = "hello";
		if (xhr.readyState === 4 && xhr.status === 200) {
			id = JSON.parse(this.responseText);
			userID = id.id;
            sessionStorage.setItem("ID",userID);
		}
	};
	let data = JSON.stringify(credentials);
	xhr.send(data);
}

function logout() {
	userID = null;
    sessionStorage.setItem("ID",userID);
}

function bookmarks() {
	$('#demo').empty();
	$('#Page').empty();
	$('#img').empty();
	$('#details').empty();
	
	$.getJSON('http://localhost:8080/bookmarks/' + encodeURI( sessionStorage.getItem("ID"))).then(function(response) {
		console.log(response);
		let i;
		for (i = 0; i < response.length; i++) {
			let obj = response[i];
			let value = obj["movie_id"];
			$.getJSON('https://www.omdbapi.com/?&apikey=c5d43602&i=' + encodeURI(value)).then(function(data) {
				$('#demo').append('<p><strong>' + data.Title + ' (' + data.Year + ')</strong></p>');
				if(data.Poster == "N/A"){
					$('#demo').append('<img src="images/pic1.jpg"><br>');
				}else {
					$('#demo').append('<img src="' + data.Poster + '"><br>');
				}

				$('#demo').append(('<button onclick="moreInformation(\'' + value + '\',\'' + 1 + '\',\'' + 2 + '\')">More Information</button>'));
			});
		}
	});
}

function savemovie(userID,movieID,movie){
	if(userID>0) {
		let mybookmark = {userID: userID, movieID: movieID};
		let xhr = new XMLHttpRequest();
		let url = "http://localhost:8080/home/" + encodeURI(userID) + "/" + encodeURI(movieID);
		xhr.open("POST", url, true);
		xhr.setRequestHeader("Content-Type", "application/json");
		let data = JSON.stringify(mybookmark);
		xhr.send(data);
		alert(movie + " has been added to 'MyBookmarks'");
	}else{
		alert("Please login if you want to save your movies!");
		location.replace("http://localhost:8080/login");
	}
}