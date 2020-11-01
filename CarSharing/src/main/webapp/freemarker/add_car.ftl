<#ftl encoding="utf-8">

<#import "../headers/admin_header.ftl" as header>

<@header.main>
<body class="bg-info">
    <form method="post" action="/add_car" id="add_car_form" enctype="multipart/form-data">
    <div class="container bg-light rounded mt-5 pt-2">
        <div class="form-group">
            <label for="mark">Марка:</label>
            <input type="text" class="form-control" id="mark" name="mark" value="Nissan">
        </div>
        <div class="form-group">
            <label for="model">Модель:</label>
            <input type="text" class="form-control" id="model" name="model" value="GT-R">
        </div>
        <div class="form-group">
            <label for="price">Цена:</label>
            <input type="text" class="form-control" id="price" name="price" value="10000">
        </div>
        <div class="form-group">
            <label for="powers">Мощность:</label>
            <input type="text" class="form-control" id="powers" name="powers" value="600">
        </div>
        <div class="form-group">
            <label for="engine">Двигатель:</label>
            <input type="text" class="form-control" id="engine" name="engine" value="1.6">
        </div>
        <div class="form-group">
            <label for="transmission">Коробка передач:</label>
            <input type="text" class="form-control" id="transmission" name="transmission" value="Механика">
        </div>
        <div class="form-group">
            <label for="max_speed">Максимальная скорость:</label>
            <input type="text" class="form-control" id="max_speed" name="max_speed" value="315">
        </div>
        <div class="form-group">
            <label for="racing">Разгон до 100 км/ч:</label>
            <input type="text" class="form-control" id="racing" name="racing" value="2.8">
        </div>
        <div class="form-group">
            <label for="description">Описание:</label>
            <input type="text" class="form-control" id="description" name="description"
            value="Nissan GT-R — суперкар, выпускаемый компанией Nissan Motor.
            Представлен в качестве серийной модели на Токийском автосалоне 24 октября 2007 года,
            продажи начались в 2008 году в Японии, затем в США и Европе. В отличие от предшественников,
            выпускавшихся только для JDM и ограниченным тиражом поставлявшихся в Великобританию,
            имеется вариант с левым рулём. И этот автомобиль может оказаться под вашем управлением всего в
            пару кликов.">
        </div>

        Загрузите первую картинку
        <input type="file" name="file1" form="add_car_form">
        Загрузите вторую картинку
        <input type="file" name="file2" form="add_car_form">
        Загрузите третью картинку
        <input type="file" name="file3" form="add_car_form">

        <button type="submit">Сохранить машину</button>

        <#if suchCar??><h3>${suchCar}</h3></#if>
    </div>
    </form>

</body>
</@header.main>