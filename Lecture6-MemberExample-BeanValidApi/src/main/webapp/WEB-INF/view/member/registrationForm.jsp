<%@ page contentType="text/html; charset=utf-8" %>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<title>회원 가입</title>
</head>
<body>
	<spring:hasBindErrors name="regReq" />
	<form method="post">
		<label for="email">이메일</label>: 
		<input type="text" name="email" id="email" value="${regReq.email}"/>
		<form:errors path="regReq.email"/> <br/>
		
		<label for="name">이름</label>: 
		<input type="text" name="name" id="name" value="${regReq.name}" />
		<form:errors path="regReq.name"/> <br/>
		
		<label for="password">암호</label>: 
		<input type="password" name="password" id="password" value="${regReq.password}"/>
		<form:errors path="regReq.password"/> <br/>
		
		<label for="password">확인</label>: 
		<input type="password" name="confirmPassword" id="confirmPassword" value="${regReq.confirmPassword}"/>
		<form:errors path="regReq.confirmPassword"/>		
		<form:errors path="regReq.samePasswordConfirmPassword" /> <!-- MemberRestrationController 내의 @AssertTrue에 의한 검증 오류 출력 -->
		<br/>
		
		<label>주소</label><br/>
		- 주소1: 
		<input type="text" name="address.address1" value="${regReq.address.address1}" />
		<form:errors path="regReq.address.address1"/> <br/>
		- 주소2:
		<input type="text" name="address.address2" value="${regReq.address.address2}" />
		<form:errors path="regReq.address.address2"/> <br/>
		- 우편번호:
		<input type="text" name="address.zipcode" value="${regReq.address.zipcode}" />
		<form:errors path="regReq.address.zipcode"/> <br/>
		
		<label>
			<input type="checkbox" name="allowNoti" value="true" ${regReq.allowNoti ? 'checked' : '' }/>
			이메일을 수신합니다.
		</label>
		<br/>
		
		<label for="birthday">생일</label>: 형식: YYYYMMDD, 예: 20180401
		<input type="text" name="birthday" id="birthday" value='<fmt:formatDate value="${regReq.birthday}" pattern="yyyyMMdd" />'/>
		<form:errors path="regReq.birthday"/> <br/>
	
		<input type="submit" value="가입" />
	
	</form>
</body>
</html>