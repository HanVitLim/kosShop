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
					url : "http://192.168.0.54:5001/change/dollar",
					dataType : "JSON",
					success : function(res){
						console.log(res)
						
     					 google.charts.load('current', {'packages':['corechart']});
						google.charts.setOnLoadCallback( function() { drawChart(res) });
						
					},
					error : function(e){
						console.log(e.responseText);
					}
					
				});
				
				function drawChart(a) {
					
					var b = Object.keys(a);
					
				      var data = new google.visualization.DataTable();
				      data.addColumn('string', 'Date');
				      data.addColumn('number', 'USDKRW');
				      data.addRows([			          
				    	  [ b[0],  parseInt(comma_replace(a[b[0]]))],
				          [ b[1],  parseInt(comma_replace(a[b[1]]))],
				          [ b[2],  parseInt(comma_replace(a[b[2]]))],
				          [ b[3],  parseInt(comma_replace(a[b[3]]))],
				          [ b[4],  parseInt(comma_replace(a[b[4]]))],
				          [ b[5],  parseInt(comma_replace(a[b[5]]))],
				          [ b[6],  parseInt(comma_replace(a[b[6]]))]
				    	  ]);

			        var options = {
					        hAxis: {
					          title: '날짜'
					        },
					        vAxis: {
					          title: '금액'
					        },
					        colors:['red','#004411']
					      };

				      var chart = new google.visualization.AreaChart(document.getElementById('chart_div'));

				      chart.draw(data, options);
			      }
				
			});

		</script>
	</head>
	<body>
	    <div id="chart_div" style="width: 900px; height: 500px"></div>
	
	</body>
</html>