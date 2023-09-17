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
					url : "http://localhost:5001/change/yen",
					dataType : "JSON",
					success : function(res){
						console.log(res)
						
     					 google.charts.load('current', {'packages':['corechart']});
						google.charts.setOnLoadCallback( function() { drawChart_y(res) });
						
					},
					error : function(e){
						console.log(e.responseText);
					}
					
				});
				
				function drawChart_y(a) {
					
					var res_y = Object.keys(a);
					
				      var data_y = new google.visualization.DataTable();
				      data_y.addColumn('string', 'Date');
				      data_y.addColumn('number', 'USAJP');
				      data_y.addRows([			          
				          [ res_y[6],  parseInt(comma_replace(a[res_y[6]]))],
				          [ res_y[5],  parseInt(comma_replace(a[res_y[5]]))],
				          [ res_y[4],  parseInt(comma_replace(a[res_y[4]]))],
				          [ res_y[3],  parseInt(comma_replace(a[res_y[3]]))],
				          [ res_y[2],  parseInt(comma_replace(a[res_y[2]]))],
				          [ res_y[1],  parseInt(comma_replace(a[res_y[1]]))],
				    	  [ res_y[0],  parseInt(comma_replace(a[res_y[0]]))]
				    	  ]);

			        var options_y = {
					        hAxis: {
					          title: '날짜'
					        },
					        vAxis: {
					          title: '금액'
					        }
					      };

				      var chart_y = new google.visualization.AreaChart(document.getElementById('chart_div_y'));

				      chart_y.draw(data_y, options_y);
			      }
				
			});

		</script>
	</head>
	<body>
	    <div id="chart_div_y" style="width: 900px; height: 500px"></div>
	
	</body>
</html>