<#ftl encoding="utf-8">

<#import "../headers/admin_header.ftl" as header>

<@header.main>
<body class="bg-info">
<div class="row ml-1 mt-5 mr-1">
    <div class="col-md-6">
        <div id="carousel" class="carousel slide" data-ride="carousel">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="img-fluid" src="../pictures/gtr.jpg">
                </div>
                <div class="carousel-item">
                    <img class="img-fluid" src="../pictures/gtr_1.jpg">
                </div>
                <div class="carousel-item">
                    <img class="img-fluid" src="../pictures/gtr_2.jpg">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carousel" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Предыдущий</span>
            </a>
            <a class="carousel-control-next" href="#carousel" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Следующий</span>
            </a>
        </div>
    </div>
    <div class="col-md-6 mt-5">
        <p class="text-center  bg-light rounded">
            <big>Nissan GT-R — суперкар, выпускаемый компанией Nissan Motor.
                Представлен в качестве серийной модели на Токийском автосалоне 24 октября 2007 года, продажи начались в
                2008 году в Японии,
                затем в США и Европе. В отличие от предшественников, выпускавшихся только для JDM и ограниченным тиражом
                поставлявшихся
                в Великобританию, имеется вариант с левым рулём. И этот автомобиль может оказаться под вашем управлением
                всего в пару кликов.
            </big>
        </p>
        <ul class="text-left bg-light pl-2 rounded list-unstyled">
            <li><big>Краткая справка:</big></li>
            <ul>
                <li>Мощьность : 600 л.с.</li>
                <li>Максимальная скорость : 315 км/ч</li>
                <li>Разгон до 100 : 2.8 сек</li>
            </ul>
        </ul>
        <button type="button" class="btn btn-outline-light btn-lg btn-block"><a class="nav-link text-light" href="#">Заказать</a>
        </button>
    </div>
</div>
<div class="row ml-1 mr-1">
    <div class="col-md-6">
        <h2 class="bg-light rounded text-center">Nissan GT-R</h2>
    </div>
</div>
</body>
</@header.main>