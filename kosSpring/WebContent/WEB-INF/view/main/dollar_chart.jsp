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
					url : "http://localhost:5001/change/dollar",
					dataType : "JSON",
					success : function(res){
						console.log(res)
						
     					 google.charts.load('current', {'packages':['corechart']});
						google.charts.setOnLoadCallback( function() { drawChart_d(res) });
						
					},
					error : function(e){
						console.log(e.responseText);
					}
					
				});
				
				function drawChart_d(a) {
					
					var res_d = Object.keys(a);
					
				      var data_d = new google.visualization.DataTable();
				      data_d.addColumn('string', 'Date');
				      data_d.addColumn('number', 'USDKRW');
				      data_d.addRows([			          
				          [ res_d[6],  parseInt(comma_replace(a[res_d[6]]))],
				          [ res_d[5],  parseInt(comma_replace(a[res_d[5]]))],
				          [ res_d[4],  parseInt(comma_replace(a[res_d[4]]))],
				          [ res_d[3],  parseInt(comma_replace(a[res_d[3]]))],
				          [ res_d[2],  parseInt(comma_replace(a[res_d[2]]))],
				          [ res_d[1],  parseInt(comma_replace(a[res_d[1]]))],
				    	  [ res_d[0],  parseInt(comma_replace(a[res_d[0]]))]
				    	  ]);

			        var options_d = {
					        hAxis: {
					          title: '날짜'
					        },
					        vAxis: {
					          title: '금액'
					        },
					        colors:['red','#004411']
					      };

				      var chart_d = new google.visualization.AreaChart(document.getElementById('chart_div_d'));

				      chart_d.draw(data_d, options_d);
			      }
				
			});

		</script>
	</head>
	<body>
	    <div id="chart_div_d" style="width: 900px; height: 500px"></div>
	
	</body>
</html>