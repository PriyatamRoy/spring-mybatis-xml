<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<spring:url value="/resources/css/bootstrap.min.css"
                var="bootstrapCss" />
<spring:url value="/resources/js/jquery.1.10.2.min.js"
                var="jqueryJs" />

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>


