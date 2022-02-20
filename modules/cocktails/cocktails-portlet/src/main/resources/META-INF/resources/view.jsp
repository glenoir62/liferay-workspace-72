<%@ include file="/init.jsp" %>

<p>
	<b><liferay-ui:message key="cocktails.caption"/></b>
</p>

<c:forEach var="pageCocktail"  items="${pageCocktails}">
	${pageCocktail}
</c:forEach>