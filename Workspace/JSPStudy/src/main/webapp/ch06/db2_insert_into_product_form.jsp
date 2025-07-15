<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT 테이블에 데이터를 추가하기 위한 폼</title>
</head>
<body>
	<h2>상품 정보 입력</h2>
	<form action="db3_insert_into_product_form.jsp" method="post">
		<table border="1" cellpadding="5">
			<tr>
				<td>PRODUCT ID</td>
				<td><input type="text" size="20" name="product_id"></td>
			</tr>
			<tr>
				<td>PRODUCT NAME</td>
				<td><input type="text" size="20" name="product_name"></td>
			</tr>
			<tr>
				<td>MANUFACTURER</td>
				<td><input type="text" size="20" name="manufacturer"></td>
			</tr>
			<tr>
				<td>EXPIRATION DATE</td>
				<td>
					<input type="date" name="expiration_date" required>
					<!-- YYYY-MM-DD 형식으로 전송됨 -->
				</td>
			</tr>
			<tr>
				<td>IS ADULT ONLY</td>
				<td>
					<select name="is_adult_only">
						<option value="N">N (아님)</option>
						<option value="Y">Y (19금)</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>PRICE</td>
				<td><input type="text" size="20" name="price"></td>
			</tr>
			<tr>
				<td>QUANTITY</td>
				<td><input type="text" size="20" name="quantity"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="전송">
					<input type="reset" value="취소">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
