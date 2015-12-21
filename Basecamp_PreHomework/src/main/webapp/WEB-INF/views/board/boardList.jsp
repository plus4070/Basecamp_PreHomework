<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>This is index page</h1>
	
	<div>
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
								<a href="#this" name="title">${row.EMAIL}</a>
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
		<
	</div>
</body>
</html>