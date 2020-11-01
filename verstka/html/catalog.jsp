<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>CarSharing</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
          integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
            integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
            integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
            crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
            integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
            crossorigin="anonymous"></script>
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
            background-color: lightgray;
            padding-bottom: 5px;
            padding-top: 5px;
        }
        .letter {
            color: black;
        }
    </style>
</head>
<body class="bg-info">
<div class="">
    <form method="post" action="#">
        <ul class="navbar-nav mr-auto filters rounded">
            <li class="navbar-brand ml-2">Фильтры:</li>
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle letter" id="navbarDropdown1" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Л.С.
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown2">
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck1"
                               name="ls_100_to_250">
                        <label class="form-check-label" for="defaultCheck1">
                            от 100 до 250
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck2"
                               name="ls_250_to_500">
                        <label class="form-check-label" for="defaultCheck2">
                            от 251 до 500
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck3" name="ls_500_plus">
                        <label class="form-check-label" for="defaultCheck3">
                            500+
                        </label>
                    </div>
                </div>
            </li>
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle letter" id="navbarDropdown3" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Цена
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown4">
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck4"
                               name="price_0_to_10000">
                        <label class="form-check-label" for="defaultCheck4">
                            от 0 до 10000
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck5"
                               name="price_10000_to_50000">
                        <label class="form-check-label" for="defaultCheck5">
                            от 10000 до 50000
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck6"
                               name="price_50000_plus">
                        <label class="form-check-label" for="defaultCheck6">
                            50000+
                        </label>
                    </div>
                </div>
            </li>
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle letter" id="navbarDropdown5" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Марка
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown6">
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck7" name="mark_bmw">
                        <label class="form-check-label" for="defaultCheck7">
                            BMW
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck8" name="mark_nissan">
                        <label class="form-check-label" for="defaultCheck8">
                            Nissan
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck9"
                               name="mark_porsche">
                        <label class="form-check-label" for="defaultCheck9">
                            Porsche
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck9"
                               name="mark_other">
                        <label class="form-check-label" for="defaultCheck9">
                            Другое
                        </label>
                    </div>
                </div>
            </li>
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle letter" id="navbarDropdown9" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Объем двигателя
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown9">
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck10" name="engine_before_1">
                        <label class="form-check-label" for="defaultCheck10">
                            до 1.0 л.
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck11" name="engine_1_to_2.5">
                        <label class="form-check-label" for="defaultCheck11">
                            от 1.0 до 2.5 л.
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck12"
                               name="engine_2.5_plus">
                        <label class="form-check-label" for="defaultCheck12">
                            2.5+ л.
                        </label>
                    </div>
                </div>
            </li>
            <li class="nav-item dropdown mr-2">
                <a class="nav-link dropdown-toggle letter" id="navbarDropdown13" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Коробка передач
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown13">
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck14" name="mechanic">
                        <label class="form-check-label" for="defaultCheck14">
                            Механика
                        </label>
                    </div>
                    <div class="form-check dropdown-item">
                        <input class="form-check-input" type="checkbox" id="defaultCheck15" name="automatic">
                        <label class="form-check-label" for="defaultCheck15">
                            Автомат
                        </label>
                    </div>
                </div>
            </li>
            <button type="button" class="btn btn-light">Применить</button>
        </ul>

    </form>
</div>
<div class="catalog-content">
    <div class="catalog-product">
        <%for (int i = 0; i < 50; i++) {%>
        <div class="card catalog-product" style="width: 25%">
            <a href="car_profile.html"><img class="card-img-top" src="../pictures/gtr.jpg"></img></a>
            <div class="card-body text-center">
                Nissan GTR
            </div>
        </div>
        <%}%>
    </div>
</div>
</body>
</html>
