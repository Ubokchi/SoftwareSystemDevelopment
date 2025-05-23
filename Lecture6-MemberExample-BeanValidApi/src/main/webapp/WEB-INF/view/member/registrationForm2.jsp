<%@ page contentType="text/html; charset=utf-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> --%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<title>회원 가입2</title>
</head>
<body>
	<form:form modelAttribute="regReq" method="post">
		<label for="email">이메일</label>: 
		<form:input path="email" />
		<form:errors path="email" />
		<br/>

		<label for="name">이름</label>: 
		<form:input path="name" />
		<form:errors path="name" />
		<br/>

		<label for="password">암호</label>: 
		<form:password path="password" showPassword="true" />  <!-- 기존 password 입력값 출력 -->
		<form:errors path="password" />
		<br/>

		<label for="confirmPassword">확인</label>: 
		<form:password path="confirmPassword" showPassword="true"/> 
		<form:errors path="confirmPassword" />
		<form:errors path="samePasswordConfirmPassword" /> 
			<!-- MemberRestrationController 내의 @AssertTrue에 의한 검증 오류 출력:
			 	MemberRestrationController에 samePasswordConfirmPassword에 대한 
			 	getter method인 isSamePasswordConfirmPassword()가 정의있기 때문에  
			 	위 path 속성에 samePasswordConfirmPassword를 지정 가능함 -->
		<br/>

		<label>주소</label><br/>
		- 주소1: 
		<form:input path="address.address1" />
		<form:errors path="address.address1" />
		<br/>
		- 주소2:
		<form:input path="address.address2" />
		<form:errors path="address.address2" />
		<br/>
		- 우편번호:
		<form:input path="address.zipcode" size="5"/>
		<form:errors path="address.zipcode" />
		<br/>

		<label for="allowNoti"> 
			<form:checkbox path="allowNoti" />이메일을 수신합니다.
		</label>
		<br/>
		
		<label for="birthday">생일</label>: 형식: YYYYMMDD, 예: 20180401
		<form:input path="birthday" />
		<form:errors path="birthday" />
		<br/>
		<%-- 
			<input name="birthday" value='<fmt:formatDate value="${regReq.birthday}" pattern="yyyyMMdd" />'/>
		--%>
		
		<input type="submit" value="가입" />

	</form:form>
</body>
</html>