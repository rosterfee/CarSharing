<#ftl encoding="utf-8">

<#import "../headers/admin_header.ftl" as header>

<@header.main>

<body class="bg-info">
<div class="">
    <form method="post" action="#">
        <ul class="navbar-nav mr-auto filters">
            <li class="navbar-brand ml-2">Фильтры:</li>
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle" id="navbarDropdown1" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Л.С.
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck1"
                               name="hp_100_to_250">
                        <label class="form-check-label" for="defaultCheck1">
                            от 100 до 250
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck2"
                               name="hp_251_to_500">
                        <label class="form-check-label" for="defaultCheck2">
                            от 251 до 500
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck3" name="hp_500_plus">
                        <label class="form-check-label" for="defaultCheck3">
                            500+
                        </label>
                    </div>
                </div>
            </li>
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle" id="navbarDropdown3" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Цена
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown4">
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck4"
                               name="price_0_to_10000">
                        <label class="form-check-label" for="defaultCheck4">
                            от 0 до 10000
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck5"
                               name="price_10000_to_50000">
                        <label class="form-check-label" for="defaultCheck5">
                            от 10000 до 50000
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck6"
                               name="price_50000_plus">
                        <label class="form-check-label" for="defaultCheck6">
                            50000+
                        </label>
                    </div>
                </div>
            </li>
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle" id="navbarDropdown5" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Марка
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown6">
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck7" name="brand_bmw">
                        <label class="form-check-label" for="defaultCheck7">
                            BMW
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck8" name="brand_nissan">
                        <label class="form-check-label" for="defaultCheck8">
                            Nissan
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck9"
                               name="brand_porsche">
                        <label class="form-check-label" for="defaultCheck9">
                            Porsche
                        </label>
                    </div>
                </div>
            </li>
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle" id="navbarDropdown9" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Объем двигателя
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown9">
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck10" name="before_one">
                        <label class="form-check-label" for="defaultCheck10">
                            до 1.0 л.
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck11" name="from_one_to_two_half">
                        <label class="form-check-label" for="defaultCheck11">
                            от 1.0 до 2.5 л.
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck12"
                               name="two_half_plus">
                        <label class="form-check-label" for="defaultCheck12">
                            2.5+ л.
                        </label>
                    </div>
                </div>
            </li>
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle" id="navbarDropdown13" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Коробка передач
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown13">
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck14" name="mechanic">
                        <label class="form-check-label" for="defaultCheck14">
                            Механика
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" value="" id="defaultCheck15" name="automatic">
                        <label class="form-check-label" for="defaultCheck15">
                            Автомат
                        </label>
                    </div>
                </div>
            </li>
        </ul>
        <button type="button" class="btn btn-info">Применить</button>
    </form>
</div>
<div class="catalog-content">
    <#list cars as car>
        <div class="card catalog-product" style="width: 25%">
            <a href="/car_profile"><img class="card-img-top" src="../pictures/gtr.jpg" alt="">
                <input type="hidden" name="id" value="${car_id}">
            </a>
            <div class="card-body text-center">
                Nissan GTR
            </div>
        </div>
    </#list>
</div>

<style>
    .catalog-product {
        display: flex;
        flex-wrap: wrap;
        margin-left: 50px;
        margin-top: 30px;
        margin-bottom: 40px;
    }
    .filters {
        display: flex;
        flex-direction: row;
    }
</style>

</body>
</@header.main>