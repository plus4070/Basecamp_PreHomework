<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>

</head>
<body>
	<div style="width:1000px; margin:40px auto 0 auto;">
		<table class="table" style="width:1000px;">
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
						<input type="hidden" id="BID" value="${row.BID}"/>
							<td>${row.BID}</td>
							<td>${row.EMAIL}</td>
							<td>${row.BCONTENT }</td>
							<td>${row.BDATE }</td>
							<td>${row.BEDITDATE}</td>
							<td id="editBtnCol"><input type="button" id="edit" value="수정"/></td>
							<td id="delBtnCol"><input type="button" id="delete" value="삭제"/></td>
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
	</div>
	
	<%@ include file="/WEB-INF/include/include-body.jsp" %>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#write").on("click", function(e){ //글쓰기 버튼
				e.preventDefault();
				f_boardWrite();
			});	
			
			$("#edit").on("click", function(e){ //제목 
				e.preventDefault();
				f_boardEdit($(this));
			});
			
			$("#delete").on("click", function(e){ //제목 
				e.preventDefault();
				f_boardDelete($(this));
			});
		});
		
		
		function f_boardWrite(){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/boardWrite' />");
			comSubmit.submit();
		}
		
		function f_boardEdit(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/boardCheck' />");
			comSubmit.addParam("BID", obj.parent().parent().find("#BID").val());
			comSubmit.submit();
		}
		
		function f_boardDelete(obj){
			var comSubmit = new ComSubmit();
			comSubmit.setUrl("<c:url value='/boardDelete' />");
			comSubmit.addParam("BID", obj.parent().parent().find("#BID").val());
			comSubmit.submit();
		}
	</script>
</body>
</html>