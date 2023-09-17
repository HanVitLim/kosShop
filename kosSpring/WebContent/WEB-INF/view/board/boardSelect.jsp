<%@page import="a.b.c.com.kos.board.vo.KosBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	Object obj = request.getAttribute("selectlist");
	List<KosBoardVO> list = (List<KosBoardVO>)obj;

	KosBoardVO kbvo = list.get(0);
	
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		
		$(document).ready(function(){
			
			$("#pwbtn").click(function(){
				
				let pwUrl = "kosBoardPwCheck.ihv";
				let pwType = "POST";
				let pwValue = { bnum : $("#bnum").val(),
								bpw : $("#bpw").val(),
				};
				
				$.ajax({
					url: pwUrl,
					type : pwType,
					data : pwValue,
					success : whenSuceess,
					error : whenError
				});
			
				function whenSuceess(resData){
					
					if("PW_OK" == resData){
						alert("비밀번호가 같습니다.");
						$("#U").css('background-color','yellow');
						$("#U").val("2");
					}else if("PW_NO" == resData){
						alert("비밀번호가 틀립니다.");
						return;
					}
				};
				
				function whenError(e){
					console.log("e >>> : " + e.responseText);
				};
					
			});
			
			$("#U").click(function(){
				
				
				if($("#U").val() == "2"){
				
				$("#boardUpdateForm").attr({
					"action":"boardUpdat.ihv",
					"method":"GET",
					'enctype':'application/x-www-form-urlencoded'
				}).submit();
				}else{
					
					alert("비밀번호를 확인해주세요");
				}
			});
			
			$("#D").click(function(){
				
			});
			
		});
		
		</script>
		
		<style type="text/css">
			div {		 
				margin: 0 auto; 		
				border:1px solid #6d82f3;
				display:table;
			}			
		
			table, h3 {		
				border: 1px;
			}
			
			table {
			   width: 100%;
			   border: 1px solid #444;
			   border-collapse: collapse;
		  	}
			
			th, td {
			   border: 1px solid #444;
			   padding: 10px;
			}	
			.mem{ text-align: center;}
				
		</style>
	</head>
	<body>
		<h3 style="text-align:center;">게시글 내용</h3>
		<hr>
		<div>
			<form name="boardUpdateForm" id="boardUpdateForm">
				<table>
					<tr>
						<td colspan="2" align="center">게시판 글 수정하기</td>
					</tr>
					<tr>
						<td class="mem">글번호</td>
						<td><input type="text" name="bnum" id="bnum" value="<%= kbvo.getBnum() %>" readonly></td>
					</tr>
					<tr>
						<td class="mem">제목</td>
						<td><input type="text" name="bsubject" id="bsubject" value="<%= kbvo.getBsubject() %>" style="width:100px" readonly></td>
					</tr>
					<tr>
						<td class="meme">이름</td>
						<td><input type="text" name="bname" id="bname" value="<%= kbvo.getBname() %>" readonly></td>
					</tr>
					<tr>
						<td class="mem">내용</td>
						<td><textarea name="bcontent" id="bcontent" rows="5" cols="50"><%= kbvo.getBcontent() %></textarea></td>
					</tr>
					<tr>
						<td class="mem">사진</td>
						<td><img src="/kosSpring/fileupload/board/<%= kbvo.getBfile() %>" border="1" width="40" height="50" alt="image"></td>
					</tr>
					<tr>
						<td class="mem">등록일</td>
						<td><input type="text" name="sbinsertdate" id="sbinsertdate" value="<%= kbvo.getInsertdate() %>" readonly></td>
					</tr>
					<tr>
						<td class="mem">수정일</td>
						<td><input type="text" name="sbupdatedate" id="sbupdatedate" value="<%= kbvo.getUpdatedate() %>" readonly></td>
					</tr>
					<tr>
						<td class="mem">패스워드</td>
						<td><input type="text" name="bpw" id="bpw">
							<button type="button" id="pwbtn">비밀번호</button>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<button id="U" value="1">수정</button>
							<button id="D">삭제</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>