<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>miniAmbari</title>
<link rel="stylesheet" href="./css/bootstrap.min.css">
<script src="./js/jquery.min.js"></script>
<script src="./js/bootstrap.min.js"></script>
<link rel="stylesheet" href="./css/main.css" media="all" type="text/css">
</head>
<body>
	<div class=" main-container">
		<h2>Cluster Name : ${clustername}</h2>
		<c:forEach var="servicesinfo" items="${servicesinfolist}">
			<div class="panel panel-default">
				<div class="panel-heading"><b>${servicesinfo.serviceName}</b></div>
				<table width=100%>
					<tr>

						<div class="panel-body">

							<c:forEach var="servicecomponentinfo"
								items="${servicesinfo.serviceComponentInfo}">
								<td>
									<div id="comp-table">
										<table width=100%>
											<tr>
												<td colspan=3><b>${servicecomponentinfo.componentName}</b></td>
											</tr>
											<tr>
												<td>${servicecomponentinfo.total_count}</td>
												<td>${servicecomponentinfo.started_count}</td>
												<c:choose>
													<c:when test="${servicecomponentinfo.unknown_count > 0}">
														<td class="bg-red">${servicecomponentinfo.unknown_count}</td>
													</c:when>
													<c:otherwise>
														<td>${servicecomponentinfo.unknown_count}</td>
													</c:otherwise>
												</c:choose>


											</tr>
										</table>
									</div>
								</td>
							</c:forEach>

						</div>

					</tr>
				</table>
			</div>
		</c:forEach>

	</div>
</body>
</html>

