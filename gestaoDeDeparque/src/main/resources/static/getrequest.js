GET: $(document).ready(
		function() {

			// GET REQUEST
			$("#getAllCars").click(function(event) {
				event.preventDefault();
				ajaxGet();
			});

			// DO GET
			function ajaxGet() {
				$.ajax({
					type : "GET",
					url : "getCars",
					success : function(result) {
						if (result.status == "success") {
							$('#getResultDiv ul').empty();
							var custList = "";
							$.each(result.data,
									function(i, car) {
										var carro = "Carro fabricante  "
												+ carro.modelo
												+ ", carro  = " + carro.pesoBruto
												+ "<br>";
										$('#getResultDiv .list-group').append(
												car)
									});
							console.log("Success: ", result);
						} else {
							$("#getResultDiv").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				});
			}
		})