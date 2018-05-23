<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolber" content="no" />
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<link rel="stylesheet" type="text/css" href="./css/style01.css">
	<title>buyItemConfirm画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItemConfirm</p>
		</div>
		<div>
			<s:form action="BuyItemConfirmAction">
				<table border="1">
					<s:iterator value="buyItemDTOList">
						<tr>
							<td>商品名</td>
							<td>
								<s:property value="itemName" />
							</td>
						</tr>
						<tr>
							<td>
								<span>値段</span>
							</td>
							<td>
								<s:property value="totalPrice" />
								<span>円</span>
							</td>
						</tr>
						<tr>
							<td>購入個数</td>
							<td>
								<s:property value="count" />
								<span>個</span>
							</td>
						</tr>
						<tr>
							<td>
								<span>支払い方法</span>
								<td>
								<s:property value="pay" />
							</td>
						</tr>
					</s:iterator>
					<tr>
						<td>
							<s:submit value="完了"/>
						</td>
					</tr>
				</table>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>