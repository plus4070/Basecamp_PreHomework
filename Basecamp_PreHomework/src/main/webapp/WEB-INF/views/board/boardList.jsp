<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
<style>
table, tr, td, th{
	border : 1px solid black;
	border-collapse : collapse;
	width : 1000px;
}
</style>
</head>
<body>
	<h1>This is index page</h1>
	<div style="height:30px;"></div>
	
	<table>
		<thead>
			<tr>
				<th>글 번호</th>
				<th>이메일</th>
				<th>본문</th>
				<th>글 등록시간</th>
				<th>글 수정시간</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
			<c:when test="${f:length(list) > 0}">
				<c:forEach items="${list}" var="row">
					<tr>
						<td>${row.BID}</td>
						<td class="title">
							<a href="#this" name="email">${row.EMAIL}</a>
							<input type="hidden" id="IDX" value="${row.BID}"/>
						</td>
						<td>${row.BCONTENT }</td>
						<td>${row.BDATE }</td>
						<td>${row.BEDITDATE}</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		</tbody>
	</table>
	<a href="#this" class="btn" id="write">방명록 작성</a>
	
	<%@ include file="/WEB-INF/include/include-body.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#write").on("click", function(e){ //글쓰기 버튼
				e.preventDefault();
				f_boardWrite();
			});	
			
			$("a[name='email']").on("click", function(e){ //제목 
				e.preventDefault();
				<!--f_boardView($(this));-->
			});
		});
		
		
		function f_boardWrite(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/boardWrite' />");
			comSubmit.submit();
		}
		
		function f_boardView(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/boardView' />");
			comSubmit.addParam("BID", obj.parent().find("#BID").val());
			comSubmit.submit();
		}
	</script>
</body>
</html>