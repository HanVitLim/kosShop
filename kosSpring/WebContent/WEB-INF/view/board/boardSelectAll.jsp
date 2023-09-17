<%@page import="org.apache.log4j.LogManager"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.com.kos.board.vo.KosBoardVO" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>

<% Logger log = LogManager.getLogger(this.getClass());%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
		<script type="text/javascript" src="/kosmoSpring/js/common.js"></script>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		
			alert("자바스크립트 시작 >>> : ");
			$(document).ready(function(){
				
				alert("제이쿼리 시작 >>> : ");
				
				$("#insertBtn").click(function(){
					
					location.href="kosBoardInsertForm.ihv";
					
				});
				
				$("#contentsBtn").click(function(){
					
					$("#boardList").attr({
						"action":"kosBoardContents.ihv",
						"method":"GET",
						'enctype':'application/x-www-form-urlencoded'
					}).submit();
					
				});
				
				$(document).on("click","#bnum",function(){
					
					alert("체크박스");
					
					if($(this).prop("checked", true)){
						$(".bnum").prop("checked",false);
						$(this).prop("checked", true);
						
					}
					
				});
				
				$("#selectBtn").click(function(){
					
					$("#boardList").attr({
						"action" : "kosBoardSelect.ihv",
						"method" : "GET",
						'enctype':'application/x-www-form-urlencoded'	
					}).submit();
					
				});
				
			});
		</script>
		<style type="text/css">
		
			td, th {
				text-align: center;
			}
			h3{
				text-align: center;
			}
			
		</style>
	</head>
	<body>
		<h3>게시판 글 목록</h3>
		<hr>
		<div class = "container">
		<form name = "boardList" id="boardList">
			<table class = "table table-bordered table-sm">
				<thead>
					<tr >
						<td colspan = "7" style="text-align:center;">
							<h3>게시판</h3>
						</td>
					</tr>
					<tr>
						<th>
							<input type="checkbox" class="chkAll" name="chkAll" id="chkAll">
						</th>
						<th>글번호</th>
						<th>글제목</th>
						<th>이름</th>
						<th>사진</th>
						<th>날짜</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
				
				
				<% 

	Object obj = request.getAttribute("selectAllList");
	Object pagingObj = request.getAttribute("pagingKbvo");
	
	int pageSize = 0;
	int groupSize = 0;
	int curPage = 0;
	int totalCount = 0;
	
	List<KosBoardVO> list = (List<KosBoardVO>)obj;
	KosBoardVO paging = (KosBoardVO)pagingObj;
	

		log.info("list " + list.size());
		
		for (int i = 0; i<list.size(); i++){
			
			KosBoardVO kbvo = list.get(i);
					
			pageSize = Integer.parseInt(paging.getPageSize());
			groupSize = Integer.parseInt(paging.getGroupSize());
			curPage = Integer.parseInt(paging.getCurPage());
			totalCount = Integer.parseInt(kbvo.getTotalCount());
			
			
	%>
					<tr>
						<td style="width:5%;">
							<input type="checkbox" id="bnum" name="bnum" class="bnum" value=<%= kbvo.getBnum() %>>
						</td>
						<td style="width:10%;"><%=kbvo.getBnum() %></td>
						<td style="text-align:left;"><%=kbvo.getBsubject() %></td>
						<td style="width:10%;"><%= kbvo.getBname() %></td>
						<td style="width:10%;"><img src="/kosSpring/fileupload/board/<%= kbvo.getBfile() %>" border="1" width="50" height="50" alt="image"></td>
						<td style="width:10%"><%= kbvo.getUpdatedate() %></td>
						<td style="width:8%"><%= kbvo.getBhit() %></td>
				<% } %>
					</tr>
					<tr>
						<td colspan="7">
							<jsp:include page="boardPaging.jsp" flush="true">
								<jsp:param value="kosBoardSelectAll.ihv" name="url"/>
								<jsp:param value="" name="str"/>
								<jsp:param value="<%=pageSize %>" name="pageSize"/>
								<jsp:param value="<%=groupSize %>" name="groupSize"/>
								<jsp:param value="<%=curPage %>" name="curPage"/>
								<jsp:param value="<%=totalCount %>" name="totalCount"/>
							</jsp:include>
						</td>
					</tr>
					<tr>
						<td colspan="7" style="text-align:right;">
							<button type="button" class="btn btn-danger" id="insertBtn">글쓰기</button>
							<button type="button" class="btn btn-primary" id="selectAllBtn">글목록</button>
							<button type="button" class="btn btn-success btn-sm" id="contentsBtn">글내용보기</button>
							<button type="button" class="btn btn-warning btn-sm" id="selectBtn">글수정</button>
							<button type="button" class="btn btn-dark" id="deleteBtn">글삭제</button>
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		</div>
	</body>
</html>