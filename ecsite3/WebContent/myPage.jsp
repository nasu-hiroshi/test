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
	<link rel="stylesheet" type="text/css" href="./css/style_myPage.css">
	<title>MyPage画面</title>
</head>
<body>
	<div id="header">
		<div id="pr">
		</div>
	</div>
	<div id="main">
		<div id="top">
			<p>MyPage</p>
		</div>
		<div>
			<s:if test="myPageList == null">
				<h3>ご購入情報はありません。</h3>
			</s:if>
			<s:elseif test="message == null">
				<h3>ご購入情報は以下になります。</h3>
				<table border ="1">
					<tr>
						<th>商品名</th>
						<th>値段</th>
						<th>購入個数</th>
						<th>支払い方法</th>
						<th>購入日</th>
					</tr>
					<s:iterator value="myPageList">
						<tr>
							<td><s:property value="itemName	" /></td>
							<td><s:property value="totalPrice" /><span>円</span></td>
							<td><s:property value="totalCount" /><span>個</span></td>
							<td><s:property value="payment" /></td>
							<td><s:property value="insert_date" /></td>
					</tr>
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
			<div id="text-right">
				<br>
					<p>Homeへ戻る場合<a href='<s:url action="HomeAction" />'>こちら</a></p>
				<br>
					<a href='<s:url action="LoginAction" />'>購入画面へ</a>

			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>