<%@page import="a.b.c.com.common.NumUtill"%>
<%@page import="org.apache.log4j.LogManager"%>
<%@page import="org.apache.log4j.Logger"%>
<%@page import="java.util.List"%>
<%@page import="a.b.c.com.kos.product.vo.KosProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
		<script type="text/javascript">
		
		</script>
		
		<style type="text/css">

			th {
				text-align: center;
			}
		</style>
	</head>
	
	<%  
		Logger log = LogManager.getLogger(this.getClass());
	
		int pageSize = 0;
		int groupSize = 0;
		int curPage = 0;
		int totalCount = 0;
	
	
		Object obj = request.getAttribute("listpro");
		Object objPaging = request.getAttribute("_kpvo");
		
		List<KosProductVO> listpro = (List<KosProductVO>)obj;
		
		
		KosProductVO pagingKpvo = (KosProductVO)objPaging;
		
	
	%>
	<body>
		<h3 align="center">상품목록</h3>
		<hr>
		<form name="productList" id="productList">
			<table border="1" align="center">
				<thead>
					<tr>
						<th>사진</th>
						<th>내용</th>
						<th>가격</th>
					</tr>
				</thead>
				<tbody>
				<%
					
					for (int i = 0; i< listpro.size(); i++){
						KosProductVO kpvo = listpro.get(i);
						
						String price = NumUtill.comma(String.valueOf(kpvo.getKpprice()));
						
						log.info(price);
						
						pageSize = Integer.parseInt(pagingKpvo.getPageSize());
						groupSize = Integer.parseInt(pagingKpvo.getGroupSize());
						curPage = Integer.parseInt(pagingKpvo.getCurPage());
						totalCount = Integer.parseInt(kpvo.getTotalCount());
						log.info(">>>> : " + pageSize);
						log.info(">>>> : " + groupSize);
						log.info(">>>> : " + curPage);
						log.info(">>>> : " + totalCount);
				%>
					<tr>
						<td rowspan="4" align="center" style="width:100px;">
							<img src="/kosSpring/fileupload/product/<%= kpvo.getKpfile() %>" width="50" height="50" alt="image"><br>
							<%= kpvo.getKpid() %>
						</td>
						<td align="left" style="width:300px;">상품번호 : <%= kpvo.getKpnum() %></td>
						<td rowspan="4" align="center" vertical-align="middle" style="width:150px;">
							<%= price %> 원 &nbsp;&nbsp;
							<a href="kosProductSelect.ihv?kpnum=<%= kpvo.getKpnum()%>">
								<img src="/kosSpring/img/img_mandu/ase.gif" width="25" height="25" alt="image">
							</a>
						</td>
					</tr>
					<tr><td><%= kpvo.getKpdesc() %></td></tr>
					<tr><td><%= kpvo.getKpcompany() %></td></tr>
					<tr><td>상품 등록일 : <%= kpvo.getInsertdate() %></td></tr>
					<% } %>
					
					
				</tbody>
				<tfoot>
					<td colspan = "3">
						<jsp:include page="ProductPaging.jsp" flush="true">
							<jsp:param value="kosProductSelectAll.ihv" name="url"/>
							<jsp:param value="" name="str"/>
							<jsp:param value="<%= pageSize %>" name="pageSize"/>
							<jsp:param value="<%= groupSize %>" name="groupSize"/>
							<jsp:param value="<%= curPage %>" name="curPage"/>
							<jsp:param value="<%= totalCount %>" name="totalCount"/>
						</jsp:include>
					</td>
				</tfoot>
			</table>
		</form>
	</body>
</html>