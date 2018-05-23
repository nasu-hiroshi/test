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
	<title>buyItem画面</title>
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
			<s:form>
				<table>
					<s:iterator value="buyItemDTOList">
						<tr>
							<td>
								<span>商品名</span>
							</td>
							<td>
								<s:property value="itemName" />
							</td>
						</tr>
						<tr>
							<td>
								<span>値段</span>
							</td>
							<td>
								<s:property value="itemPrice" />
								<span>円</span>
							</td>
						</tr>
						<tr>
							<td>
								<span>在庫</span>
							</td>
							<td>
								<select name="count">
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
								</select>
							</td>
						</tr>
						<tr>
							<td>
								<s:form action="CartItemAction">
									<input type="hidden" name="cartInsert" value="1">
									<s:submit value="カートへ入れる" method="insertCart"/>
								</s:form>
							</td>
						</tr>
					</s:iterator>
				</table>
			</s:form>
			<div>
				<span>前画面に戻る場合</span>
				<a href='<s:url action="HomeAction" />'>こちら</a>
			</div>
			<div>
				<span>マイページは</span>
				<a href='<s:url action="MyPageAction" />'>こちら</a>
			</div>

		</div>
	</div>
	<div id="footer">
		<div id="pr">
		</div>
	</div>
</body>
</html>