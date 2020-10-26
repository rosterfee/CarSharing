<#ftl encoding="utf-8">

<#import "../headers/admin_header.ftl" as header>

<@header.main>
<div class="form__wrapper">
    <form id="register" action="#" method="post">
        <h1>Регистрация</h1>
        <div class="fields">
            <label for="firstName">Ваше имя:</label>
            <input type="text" id="firstName" value="" placeholder="Иван" name="first_name">
            <span class="dot">*</span>
        </div>
        <div class="fields">
            <label for="lastName">Ваша фамилия:</label>
            <input type="text" id="lastName" value="" placeholder="Иванов" name="last_name">
            <span class="dot">*</span>
        </div>
        <div class="fields">
            <label for="login">Ваш логин:</label>
            <input type="text" id="login" value="" placeholder="AmateR" name="login">
            <span class="dot">*</span>
        </div>
        <div class="fields">
            <label for="email">Ваш e-mail:</label>
            <input type="text" id="email" value="" placeholder="youmail@domain.ru" name="email">
            <span class="dot">*</span>
        </div>
        <div class="fields">
            <label for="phone">Номер Вашего телефона:</label>
            <input type="text" id="phone" value="" placeholder="79274286071" name="phone">
            <span class="dot">*</span>
        </div>
        <div class="fields">
            <label for="pass1">Пароль:</label>
            <input type="password" id="pass1" value="" name="password">
            <span class="dot">*</span>
        </div>
        <div class="fields">
            <label for="pass2">Пароль еще раз:</label>
            <input type="password" id="pass2" value="">
            <span class="dot">*</span>
        </div>

        <button type="submit" name="button" id="send">Отправить</button>
    </form>
</div>

<style>
    ::-webkit-input-placeholder {color: #aaaaaa;}
    ::-moz-placeholder          {color: #aaaaaa;} /* Firefox 19+ */
    :-moz-placeholder           {color: #aaaaaa;} /* Firefox 18- */
    :-ms-input-placeholder      {color: #aaaaaa;}

    input::-webkit-input-placeholder       {opacity: 1; transition: opacity 0.3s ease;}
    input::-moz-placeholder                {opacity: 1; transition: opacity 0.3s ease;}
    input:-moz-placeholder                 {opacity: 1; transition: opacity 0.3s ease;}
    input:-ms-input-placeholder            {opacity: 1; transition: opacity 0.3s ease;}
    input:focus::-webkit-input-placeholder {opacity: 0; transition: opacity 0.3s ease;}
    input:focus::-moz-placeholder          {opacity: 0; transition: opacity 0.3s ease;}
    input:focus:-moz-placeholder           {opacity: 0; transition: opacity 0.3s ease;}
    input:focus:-ms-input-placeholder      {opacity: 0; transition: opacity 0.3s ease;}

    /**
     * Основные стили
     */

    body {
        background: url('https://codernote.ru/files/image/fon-1.png');
        font: 14px/20px 'Open Sans', serif;
    }

    h1, h2, h3 {
        text-align: center;
        letter-spacing: -0.6px;
    }

    .form__wrapper {
        width: 40%;
        margin: 20px auto;
    }

    form#register {
        position: relative;
        background: #FFF;

        padding: 10px;
        border: 1px solid #a7a7a7;
        -webkit-border-radius:4px;
        -moz-border-radius:4px;
        border-radius: 4px;
        box-shadow: 1px 3px 10px 0px rgba(0, 0, 0, 0.10);
    }

    form#register div.fields {
        position: relative;
        line-height: 30px;
        margin-bottom: 15px;
    }

    form#register input[type="text"], form#register input[type="password"] {
        width: 95%;
        outline: none;
        padding: 5px;
        border: 1px solid #a7a7a7;
    }

    form#register input[type="text"]:focus, form#register input[type="password"]:focus {
        border: 1px solid #2A900C;
    }

    form#register input[type="text"].error, form#register input[type="password"].error {
        border: 1px solid red;
    }

    form#register span.dot {
        position: absolute;
        color: red;
        line-height: 15px;
        right: 0;
    }

    form#register span.text-error {
        position: absolute;
        top: 0;
        left: 0;
        color: red;
        font-size: 10px;
        line-height: 10px;
    }

    form#register button {
        position: relative;
        margin-top: 15px;
        right: 0;

        text-decoration:none;
        text-align:center;
        padding:11px 32px;
        border:solid 1px #004F72;
        -webkit-border-radius:4px;
        -moz-border-radius:4px;
        border-radius: 4px;
        font-size: 14px;
        font-weight:bold;
        color:#E5FFFF;
        background-color:#3BA4C7;
        background-image: -moz-linear-gradient(top, #3BA4C7 0%, #1982A5 100%);
        background-image: -webkit-linear-gradient(top, #3BA4C7 0%, #1982A5 100%);
        background-image: -o-linear-gradient(top, #3BA4C7 0%, #1982A5 100%);
        background-image: -ms-linear-gradient(top, #3BA4C7 0% ,#1982A5 100%);
        filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#1982A5', endColorstr='#1982A5',GradientType=0 );
        background-image: linear-gradient(top, #3BA4C7 0% ,#1982A5 100%);
        -webkit-box-shadow:0px 0px 2px #bababa, inset 0px 0px 1px #ffffff;
        -moz-box-shadow: 0px 0px 2px #bababa,  inset 0px 0px 1px #ffffff;
        box-shadow:0px 0px 2px #bababa, inset 0px 0px 1px #ffffff;
    }
</style>
</@header.main>