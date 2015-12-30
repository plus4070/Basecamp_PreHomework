<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jsp" %>
<link rel="stylesheet" type="text/css" href="<c:url value='/css/board/boardWrite.css'/>" />
</head>
<body>
	<div class="bs-callout-info">
		<p>������ ������ �Է��ϼ���.</p>
	</div>
	<div id="writeDiv">
		<form id="writeForm" name="writeForm">
			<table id="writeTable">
				<tr>
					<th>�̸��� �Է�</th>
					<td><input type="email" id="EMAIL" name="EMAIL" class="form-control" placeholder="Email" required autocomplete="off"></input></td>
				</tr>
				<tr>
					<th>��й�ȣ �Է�</th>
					<td><input type="password" id="PASSWORD" name="PASSWORD" class="form-control" placeholder="Password" required></input></td>
				</tr>
				<tr>
					<th>���� �Է�</th>
					<td><textarea id="content" rows="15" id="BCONTENT" name="BCONTENT" onkeyup = "f_lengthCheck()" required></textarea></td>
				</tr>
				<tr>
					<th></th>
					<td>
						<a href="#this" class="btn btn-primary" id="btnWrite">�ۼ��ϱ�</a>
						<a href="#this" class="btn btn-default" id="btnList">��Ϻ���</a>
					</td>
				</tr>
			</table>
			
		</form>
	</div>
	<%@ include file="/WEB-INF/include/include-body.jsp" %>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#btnList").on("click", function(e){ //������� ��ư
			e.preventDefault();
			f_openBoardList();
		});
		
		$("#btnWrite").on("click", function(e){ //�ۼ��ϱ� ��ư
			e.preventDefault();
			f_insertBoard();
		});
	});
	
	function f_openBoardList(){
		var comSubmit = new ComSubmit();
		comSubmit.setUrl("<c:url value='/board/boardList.do' />");
		comSubmit.submit();
	}
	
	function f_insertBoard(){
		var comSubmit = new ComSubmit("writeForm");
		comSubmit.setUrl("<c:url value='/board/insertBoard.do' />");
		comSubmit.submit();
	}
	
	function f_lengthCheck(){  
		  var frm = document.writeForm.BCONTENT; 

		  if(frm.value.length > 300){  
		       alert("���ڼ��� 300�ڷ� ���ѵ˴ϴ�.");  
		       frm.value = frm.value.substring(0, 300);  
		       frm.focus();  
		  } 

		} 
	</script>
</body>
</html>