<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/board/boardCheck.css'/>" />
</head>
<body>
	<div class="bs-callout-info">
		<p>��й�ȣ�� �Է��ϼ���.</p>
	</div>
	<div id="checkDiv">
		<form id="inputForm">
			<input type="hidden" id="BID" name="BID" value="${target.BID }"/>
			<input type="hidden" id="EMAIL" name="EMAIL" value="${target.EMAIL }" />
			<table id="checkTable">
				<tr>
					<th>�̸���</th>
					<td>${target.EMAIL }</td>
				</tr>
				<tr>
					<th>��й�ȣ</th>
					<td><input type="password" id="PASSWORD" name="PASSWORD" class="form-control" placeholder="Password" /></td>
				</tr>
				<tr>
					<th></th>
					<td>
						<input type="button" value="Ȯ��" id="btnSubmit" class="btn btn-primary" />
						<input type="button" value="���" id="btnCancel" class="btn btn-default"/>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<%@ include file="/WEB-INF/include/include-body.jsp" %>
	<script>
		$(document).ready(function(){
			$("#btnSubmit").on("click", function(e){ //Ȯ�� ��ư
				e.preventDefault();
				f_InputCheck($(this));
			});	
			
			$("#btnCancel").on("click", function(e){ //��� ��ư
				e.preventDefault();
				history.back();
			});
		});
		
		
		function f_InputCheck(obj){
			var comSubmit = new ComSubmit("inputForm");
			comSubmit.setUrl("<c:url value='/board/boardEditCheck.do' />");
			comSubmit.submit();
		}
		
	</script>
</body>
</html>