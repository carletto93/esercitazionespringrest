function listaContatti() {
	generaTabella();
	mostraContatti();
}

function mostraContatti() {

	$.ajax({
		type : "GET",
		url : '${pageContext.request.contextPath}/contatti',
		data : "{}",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		cache : false,
		success : function(data) {

			riempiTabella(data);

		},

		error : function() {

			alert("Spiacenti, si è verificato un errore");
		}
	});
}

function eliminaContatto(id) {

	var id = id;

	$.ajax({
		type : "DELETE",
		url : "${pageContext.request.contextPath}/elimina/" + id,
		data : "{}",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		cache : false,
		success : function(data) {

			riempiTabella(data);

		},
		error : function() {

			alert("Spiacenti, si è verificato un errore");
		}
	})
}

function ordinaContatti() {
	$.ajax({
		type : "GET",
		url : "${pageContext.request.contextPath}/contattiordinati",
		data : "{}",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		cache : false,
		success : function(data) {

			riempiTabella(data);

		},
		error : function() {

			alert("Spiacenti, si è verificato un errore");
		}
	})
}

function creaContattoGet() {
	$.ajax({
		type : "GET",
		url : "${pageContext.request.contextPath}/creaContatto",
		data : "{}",
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		cache : false,
		success : function(contatto) {
			generaFormTable();
		}
	})
}

function generaFormTable() {

	var fthtml = '';

	fthtml += '<form:form id="creaContattoForm" action="${pageContext.request.contextPath}/creaContatto" modelAttribute="contatto">'
			+ '<table>'
			+ '<tbody>'
			+ '<tr>'
			+ '<td>nome:</td>'
			+ '<td> '
			+ '<form:input path="nome"></form:input></td>'
			+ '</td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>cognome:</td>'
			+ '<td><form:input path="cognome"></form:input></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>email:</td>'
			+ '<td><form:input path="email"></form:input></td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>data di nascita:</td>'
			+ '<td> '
			+ '<form:input path="dataDiNascita"></form:input></td>'
			+ '</td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><input value="Salva" type="submit"></td>'
			+ '<td></td>' + '</tr>' + '</tbody>' + '</table>' + '</form:form>';

	$('#contattoForm').html(fthtml);
}

function generaTabella() {

	var thtml = '';

	thtml += '<h1>Lista dei contatti</h1>'
			+ ' <h3><input type="button" , onClick="creaContattoGet()", value="Nuovo contatto"/> </h3>'
			+ ' <table id="tabellaContatti" border="1">'
			+ '<th>id</th>'
			+ '<th>Nome</th>'
			+ '<th>Cognome</th>'
			+ '<th>Email</th> '
			+ '<th>Data di nascita</th>'
			+ '<th>Action</th> </tr> </table>'
			+ '<h4> '
			+ '<input type="button" , onClick="ordinaContatti()", value="Ordina i contatti"/>';

	$('#tableDiv').html(thtml);
}

function riempiTabella(data) {
	var thtml = '';

	$
			.each(
					data,
					function(i, contatto) {
						thtml += '<tr><td>'
								+ contatto.id
								+ '</td><td>'
								+ contatto.nome
								+ '</td><td>'
								+ contatto.cognome
								+ '</td><td>'
								+ contatto.email
								+ '</td><td>'
								+ contatto.dataDiNascita
								+ '</td><td><input type="button", onClick="eliminaContatto('
								+ contatto.id
								+ ')",'
								+ ' value="Elimina" /> &nbsp;&nbsp;&nbsp;&nbsp;<input type="button", onClick="editContatto('
								+ contatto.id
								+ ')",'
								+ ' value="Modifica" />'; 
					});

	$('#tabellaContatti').html(thtml);
}


$(document).ready(function() {
    
    $('#creaContattoForm').submit(function(event) {
  	  
  	  var nome = $('#nome').val();
  	  var cognome = $('#cognome').val();
  	  var email = $('#email').val();
  	  var dataDiNascita = $('#dataDiNascita').val();
  	  var json = {"nome" : nome, "cognome" : cognome, "email": email, "dataDiNascita": dataDiNascita};
  	  console.log(json);
  	  
      $.ajax({
      	url: $("#creaContattoForm").attr("action"),
      	data: JSON.stringify(json),
      	type: "POST",
      	success: function() {
      		listaContatti();
      	},
      	error: function(jqXHR, textStatus, errorThrown) {
      		
      	}
      });
       
      event.preventDefault();
    });
     
  });   