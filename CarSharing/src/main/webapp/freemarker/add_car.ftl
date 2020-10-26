<#ftl encoding="utf-8">

<#import "../headers/admin_header.ftl" as header>

<@header.main>
<body class="bg-info">
<div class="container bg-light rounded mt-5 pt-2">
    <form method="post" action="#">
        <div class="form-group">
            <label for="mark">Марка:</label>
            <input type="text" class="form-control" id="mark">
        </div>
        <div class="form-group">
            <label for="price">Цена:</label>
            <input type="text" class="form-control" id="price">
        </div>
        <div class="form-group">
            <label for="powers">Мощность:</label>
            <input type="text" class="form-control" id="powers">
        </div>
        <div class="form-group">
            <label for="transmission">Коробка передач:</label>
            <input type="text" class="form-control" id="transmission">
        </div>
        <div class="form-group">
            <label for="engine">Двигатель:</label>
            <input type="text" class="form-control" id="engine">
        </div>
        <div class="form-group pb-2">
            <label for="cars_foto">Фото авто:</label>
            <input type="file" class="form-control-file" id="cars_foto">
        </div>
    </form>
</div>
</@header.main>