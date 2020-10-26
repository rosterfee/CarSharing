<#ftl encoding="utf-8">

<#import "../headers/admin_header.ftl" as header>

<@header.main>
<body class="bg-info">
<div class="container bg-light mt-5 rounded">
    <div class="table-responsive pt-3">
        <table class="table table-hover table-bordered">
            <thead>
            <tr>
                <th>Название</th>
                <th>Цена за 4 часа</th>
                <th>Удалить</th>
            </tr>
            </thead>
            <tbody id="cart">
            <tr>
                <td></td>
                <td></td>
                <td colspan="6" class="text-center" width="10%"><a href="#"><img src="../pictures/delete.jpg" alt="" style="width: 50%"></a></td>
            </tr>
            </tbody>
        </table>
    </div>
    <label for="hours">Количество времени:</label>
    <select name="hours" id="hours">
        <option value="four">4</option>
        <option value="eight">8</option>
        <option value="twelve">12</option>
    </select>
    <div>Итого: <span id="total-cart-summa">0</span> руб.</div>
    <br>
    <button id="order" class="btn btn-info mb-3">Оформить заказ</button>
</div>
</body>
</@header.main>