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
	<title>cartItem画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>BuyItem</p>
		</div>
		<div>
			<s:if test="cartList == null">
				<h3>カート情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>カート情報は以下になります。</h3>
				<table border ="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>購入個数</th>
					</tr>
					<s:iterator value="cartList">
						<td><s:property value="buyItem_name" /></td>
						<td><s:property value="total_price" /><span>円</span></td>
						<td><s:property value="total_count" /><span>個</span></td>
					</s:iterator>
				</table>
				<s:form>
					<input type="hidden" name="deleteFlg" value="1">
					<s:submit value="削除" method="delete"/>
				</s:form>
			</s:elseif>
			<s:if test="session.message != null" >
				<h3><s:property value="message" /></h3>
			</s:if>
			<span>前画面に戻る場合</span>
			<a href='<s:url action="HomeAction" />'>こちら</a>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>