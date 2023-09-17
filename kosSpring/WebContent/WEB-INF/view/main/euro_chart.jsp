<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 		<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
 		<script type="text/javascript" src="/kosSpring/js/common.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function(){
				
				
				$.ajax({
					url : "http://localhost:5001/change/euro",
					dataType : "JSON",
					success : function(res){
						console.log(res)
						
     					 google.charts.load('current', {'packages':['corechart']});
						google.charts.setOnLoadCallback( function() { drawChart_e(res) });
						
					},
					error : function(e){
						console.log(e.responseText);
					}
					
				});
				
				function drawChart_e(a) {
					
					var res_e = Object.keys(a);
					
				      var data_e = new google.visualization.DataTable();
				      data_e.addColumn('string', 'Date');
				      data_e.addColumn('number', 'EURKRW');
				      data_e.addRows([			          
				          [ res_e[6],  parseInt(comma_replace(a[res_e[6]]))],
				          [ res_e[5],  parseInt(comma_replace(a[res_e[5]]))],
				          [ res_e[4],  parseInt(comma_replace(a[res_e[4]]))],
				          [ res_e[3],  parseInt(comma_replace(a[res_e[3]]))],
				          [ res_e[2],  parseInt(comma_replace(a[res_e[2]]))],
				          [ res_e[1],  parseInt(comma_replace(a[res_e[1]]))],
				    	  [ res_e[0],  parseInt(comma_replace(a[res_e[0]]))]
				    	  ]);

			        var options_e = {
					        hAxis: {
					          title: '날짜'
					        },
					        vAxis: {
					          title: '금액'
					        },
					        colors:['green','#00E396']
					      };

				      var chart_e = new google.visualization.AreaChart(document.getElementById('chart_div_e'));

				      chart_e.draw(data_e, options_e);
			      }
				
			});

		</script>
	</head>
	<body>
	    <div id="chart_div_e" style="width: 900px; height: 500px"></div>
	
	</body>
</html>