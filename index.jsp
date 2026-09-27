<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chuyển đổi USD sang VNĐ</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background: #f8fafc;
        }
        .converter-container {
            background: white;
            padding: 40px;
            border-radius: 14px;
            box-shadow: 0 8px 28px rgba(0,0,0,.12);
            text-align: center;
            width: 380px;
        }
        h2 { color: #1b2a7a; margin-top: 0; }
        label {
            display: block;
            text-align: left;
            font-weight: bold;
            color: #333;
            margin: 14px 0 7px;
        }
        input {
            padding: 11px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 8px;
            box-sizing: border-box;
            font-size: 15px;
        }
        button {
            background: #1b2a7a;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 8px;
            cursor: pointer;
            width: 100%;
            font-weight: bold;
            margin-top: 20px;
            font-size: 16px;
        }
        button:hover { background: #121c54; }
    </style>
</head>
<body>
<div class="converter-container">
    <h2>Chuyển đổi USD sang VNĐ</h2>
    <form action="${pageContext.request.contextPath}/convert" method="POST">
        <label for="rate">Tỉ giá (VND/USD):</label>
        <input id="rate" type="number" name="rate" placeholder="Ví dụ: 25000" value="25000" required step="any" min="0" />

        <label for="usd">Lượng USD cần đổi:</label>
        <input id="usd" type="number" name="usd" placeholder="Nhập số USD" required step="any" min="0" />

        <button type="submit">Chuyển đổi</button>
    </form>
</div>
</body>
</html>
