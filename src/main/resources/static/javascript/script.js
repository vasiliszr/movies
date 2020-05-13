	function mainFunction () {
		$('#Page').empty();
		
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
		
		$.getJSON('https://www.omdbapi.com/?&apikey=c5d43602&s=' + encodeURI(movie)+ '&page='+encodeURI(pageNumber)).then(function(response) {
			console.log(response);
		    let i;
			for (i=0; i < response.Search.length; i++) {
				$('#demo').append('<p><strong>' + response.Search[i].Title + ' (' + response.Search[i].Year + ')</strong></p>');
				$('#demo').append('<img src="' + response.Search[i].Poster + '"><br>');
				let ID = response.Search[i].imdbID;
				$('#demo').append(('<button onclick="moreInformation(\'' + ID + '\',\'' + pageNumber + '\')">More Information</button>'));
			}
				
			if (pageNumber>1) {
				$('#Page').append(('<button id =button1 onclick="previousPage(\'' + pageNumber +'\')">Previous Page</button>'));
			}

			if (response.Search.length==10) {
				$('#Page').append(('<button id =button2 onclick="nextPage(\'' + pageNumber +'\')">Next Page</button>'));
			}
		});
	}
	
	function moreInformation(ID,pageNumber) {
		$('#demo').empty();
		$('#Page').empty();
		$('#img').empty();
		$('#details').empty();
		$('#intro').empty();
		
		console.log(ID);
		
		$.getJSON('https://www.omdbapi.com/?&apikey=c5d43602&i=' + encodeURI(ID)).then(function(response) {
			console.log(response);	

			$('#img').append('<img src="' + response.Poster + '">');
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
			$('#Page').append(('<button onclick="apiCall(\'' + movie + '\',\'' + pageNumber + '\')">Go Back</button>'));
		});
	}
	
	function nextPage(pageNumber) {
		pageNumber++;	
		var movie = document.getElementById("myText").value;
		apiCall(movie, pageNumber);
	}
	
	function previousPage(pageNumber) {
		pageNumber--;	
		var movie = document.getElementById("myText").value;
		apiCall(movie, pageNumber);
	}

	function register() {
		var res = $('form').serialize();
		console.log(res);
	}
