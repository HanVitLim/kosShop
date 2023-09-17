<%@page import="org.apache.log4j.LogManager"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="a.b.c.com.kos.mem.vo.KosMemberVO" %>
<%@ page import="a.b.c.com.common.CodeUtil" %>

<%@ page import="java.util.ArrayList" %>


<!DOCTYPE html>
<% 			Logger log = LogManager.getLogger(this.getClass());
 %>
 		<% 
			Object objs = request.getAttribute("search");
			
			KosMemberVO _kvo = (KosMemberVO)objs;
		
			log.info(_kvo.getKeyword());
			log.info(_kvo.getSearchFilter());
			log.info(_kvo.getStartDate());
			log.info(_kvo.getEndDate());
			
			
			String str = "&searchFilter=" + _kvo.getSearchFilter() + "&keyword=" + _kvo.getKeyword()
							+ "&startDate=" + _kvo.getStartDate() + "&endDate" + _kvo.getEndDate();
		%>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 		<script  src="http://code.jquery.com/jquery-latest.min.js"></script> 
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script type="text/javascript">
			alert("자바스크립트 블럭 시작 >>> : ");
			$(document).ready(function(){
				alert("jquery 시작 >>>> : ");
				
				var keyword = "";
				var searchfilter = "";
				var startdate = "";
				var enddate = "";
				
				keyword = "<%= _kvo.getKeyword()%>";
				searchfilter = "<%= _kvo.getSearchFilter()%>";
				startdate = "<%= _kvo.getStartDate()%>";
				enddate = "<%= _kvo.getEndDate()%>";
				
				if(searchfilter == null || searchfilter == "" || searchfilter == "null"){
					$("#searchfilter").val("")

				}else{
					$("#searchfilter").val("<%= _kvo.getSearchFilter()%>").prop("selected",true);
					
				}
				
				if(keyword == null || keyword == "" || keyword == "null"){
					$("#keyword").val("")

				}else{
					$("#keyword").val("<%=_kvo.getKeyword()%>")
				}
				
				if(startdate == null || startdate == "" || startdate == "null"){
					$("#startdate").val("")

				}else{
					$("#startdate").val("<%=_kvo.getStartDate()%>")
				}
				
				if(enddate == null || enddate =="" || enddate == "null"){
					$("#enddate").val("")

				}else {
					$("#enddate").val("<%=_kvo.getEndDate()%>")
				}
				
				
				$("#searchBtn").click(function(){
					
					$("#memFormAll").attr({
						'action':'kosMemberSelectAll.ihv',
						'method':"GET",
						'enctype':'application/x-www-form-urlencoded'
					}).submit();
					
				});
				
				
				$(document).on("click","#mnum",function(){
					
					alert("체크박스 클릭 >>> : ");				
					
					if($(this).prop('checked')){
						
						$(".mnum").prop("checked",false);
						$(this).prop("checked",true);
					}
					
					});
				
				
				$("#startDate").datepicker({
					showOn:"button",
					buttonImage: "/kosSpring/common/img/cal_0.gif",
					buttonImageOnly: true,
					buttonText: "날짜선택",
					dateFormat: "yy-mm-dd",
					chageMonth: true,
					onClose: function(selectDate){
						$("#enddate").datepicker("option","minDate",selectedDate);
					}
					
				});
				
				$("#endDate").datepicker({
					showOn:"button",
					buttonImage: "/kosSpring/common/img/cal_0.gif",
					buttonImageOnly: true,
					buttonText: "날짜선택",
					dateFormat: "yy-mm-dd",
					chageMonth: true,
					onClose: function(selectDate){
						$("#startDate").datepicker("option","minDate",selectedDate);
					}
					
				});
				
				$("#U").click(function(){
					
					$("#memFormAll").attr({
						"action":"kosMemberSelect.ihv",
						"method":"GET",
						'enctype':'application/x-www-form-urlencoded'
					}).submit();
					
					});
				
				});
				
			
		
		</script>
		
		<style type="text/css">
			div {
				margin: 0 auto;
				border: 1px solid #6d82f3;
				display:table;
			}
			
			td, th{
				padding: 5px;
			}
			
			h3{
				text-align: center;
			}
			
			table, th, td{
				border: 1px solid black;
				text-align: center;
			}
		
		</style>
	</head>
	<body>
		<h3>MEMBER SELECTALL</h3>
		<hr>
		<div>
			<form name="memFormAll" id="memFormAll">
				<table>
					<thead>
						<tr >
							<td colspan="19" align="center">
								<h3>회원정보</h3>
							</td>
						</tr>
						<tr>
							<td colspan="19" style="text-align:text;">
								<select id="searchFilter" name="searchFilter">
									<option value = "key1" selected> 전체 </option>
									<option value = "key2">회원번호</option>
									<option value = "key3">이름</option>
									<option value = "key4">아이디</option>
								</select>
								<label for="keyword">검색어</label>
								<input type="text" id="keyword" name="keyword" size="15" placeholder="검색어 입력"><br>
								<input type="text" id="startDate" name="startDate" size="12" placeholder="시작일"> ~ 
								<input type="text" id="endDate" name="endDate" size="12" placeholder="종료일">
								&nbsp;&nbsp;
								<button type="button" id="searchBtn">검색</button>
								<button type="reset" id="resetBtn">다시</button>
							</td>
						</tr>
						<tr>
							<th><input type="checkbox" name="chkAll" id="chkAll"></th>
							<th>회원번호</th>
							<th>이름</th>
							<th>아이디</th>
							<th>비밀번호</th>
							<th>성별</th>
							<th>생일</th>
							<th>이메일</th>
							<th>핸드폰번호</th>
							<th>전화번호</th>
							<th>우편번호</th>
							<th>주소(도로명)</th>
							<th>주소(지번)</th>
							<th>취미</th>
							<th>소개글</th>
							<th>수정일</th>
							<th>사진</th>
						</tr>
					</thead>
					<%   

	int pageSize = 0;
	int groupSize = 0;
	int curPage=0;
	int totalCount = 0;

	Object obj = request.getAttribute("selectAll");
		if(obj==null)return;
	Object objPaging = request.getAttribute("paging");
	KosMemberVO pagingVO = (KosMemberVO)objPaging;
	
	ArrayList<KosMemberVO> list = (ArrayList<KosMemberVO>)obj;
	
	if (list.size() > 0){
		for (int i = 0; i<list.size(); i++){
			KosMemberVO kvo = list.get(i);
			
			pageSize = Integer.parseInt(pagingVO.getPageSize());
			groupSize = Integer.parseInt(pagingVO.getGroupSize());
			curPage = Integer.parseInt(pagingVO.getCurPage());
			totalCount = Integer.parseInt(kvo.getTotalCount());
			
			log.info(">>> " + kvo.getKeyword());
			log.info(">>> " + kvo.getSearchFilter());
			log.info(">>> " + kvo.getStartDate());
			log.info(">>> " + kvo.getEndDate());
			log.info(">>>" + pageSize);
			log.info(">>>" + groupSize);
			log.info(">>>" + curPage);
			log.info(">>>" + totalCount);

%>
					<tbody>
						<tr>
						<td><input type="checkbox" class="mnum" name="mnum" id="mnum" value="<%= kvo.getMnum()%>"></td>
						<td><%=kvo.getMnum()%></td>
						<td><%=kvo.getMname()%></td>
						<td><%=kvo.getMid()%></td>
						<td><%=kvo.getMpw()%></td>
						<td><%=CodeUtil.gender(kvo.getMgender())%></td>
						<td><%=kvo.getMbirth()%></td>
						<td><%=kvo.getMemail()%></td>
						<td><%=CodeUtil.hp(kvo.getMhp())%></td>
						<td><%=CodeUtil.tel(kvo.getMtel())%></td>
						<td><%=kvo.getMzonecode()%></td>
						<td style="text-align:left;"><%=kvo.getMroadaddr().concat(" ").concat(kvo.getMroaddetail())%></td>
						<td><%=kvo.getMjibunaddr()%></td>
						<td><%=CodeUtil.hobbys(kvo.getMhobby())%></td>
						<td><%=kvo.getMinfo() %></td>
						<td><%=kvo.getUpdatedate() %></td>
						<td><img src="/kosSpring/fileupload/mem/<%= kvo.getMphoto() %>" border="1" width="50" height="50" alt="image"></td>
						</tr>
								<%
		} // end of for
%>
						<tr>
							<td colspan="19">
							<jsp:include page="Paging.jsp" flush="true">
								<jsp:param value="kosMemberSelectAll.ihv" name="url"/>
								<jsp:param value="<%=str %>" name="str"/>
								<jsp:param value="<%= pageSize %>" name="pageSize"/>
								<jsp:param value="<%= groupSize %>" name="groupSize"/>
								<jsp:param value="<%= curPage %>" name="curPage"/>
								<jsp:param value="<%= totalCount %>" name="totalCount"/>
							</jsp:include>
							</td>
						</tr>
						<%	} // end of if
 %>
						<tr>
							<td colspan="19" style="text-align:right;">
								<input type="button" value="글쓰기" id="I">
								<input type="button" value="글목록" id="SALL">
								<input type="button" value="글수정" id="U">
								<input type="button" value="글삭제" id="D">
							</td>
						</tr>
					</tbody>
				</table>
			</form>
		</div>

	</body>
</html>