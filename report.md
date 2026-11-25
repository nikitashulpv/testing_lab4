Задача 1. На сайте https://old.vyatsu.ru выполните следующие
сценарии.

Сценарий 1. Откройте меню Сведения об образовательной
организации, выберите пункт Образовательные стандарты. Перейдите на эту страницу. Убедитесь, что отображается верная страница.
![S1_1_Открыт_сайт.png](screenshots/S1_1_%D0%9E%D1%82%D0%BA%D1%80%D1%8B%D1%82_%D1%81%D0%B0%D0%B9%D1%82.png)
![S1_2_Меню_раскрыто.png](screenshots/S1_2_%D0%9C%D0%B5%D0%BD%D1%8E_%D1%80%D0%B0%D1%81%D0%BA%D1%80%D1%8B%D1%82%D0%BE.png)
![S1_3_Страница_стандартов.png](screenshots/S1_3_%D0%A1%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0_%D1%81%D1%82%D0%B0%D0%BD%D0%B4%D0%B0%D1%80%D1%82%D0%BE%D0%B2.png)
![FAILED_scenario1_getEducationalStandart.png](screenshots/FAILED_scenario1_getEducationalStandart.png)
org.openqa.selenium.TimeoutException: Expected condition failed: waiting for element found by By.xpath: //*[@id='jsddm']/li[1]/ul/a[contains(text(), 'Образовательные стандарты')] to be clickable, but the element was not found: org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element: {"method":"xpath","selector":"//*[@id='jsddm']/li[1]/ul/a[contains(text(), 'Образовательные стандарты')]"}.
(tried for 10 seconds with 500 milliseconds interval)

Сценарий 2. Получите результаты поиска по слову отпуск со
страницы. Убедитесь, что результат поиска не пустой.
![S2_1_Открыт_сайт.png](screenshots/S2_1_%D0%9E%D1%82%D0%BA%D1%80%D1%8B%D1%82_%D1%81%D0%B0%D0%B9%D1%82.png)
![S2_2_Введен_запрос.png](screenshots/S2_2_%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD_%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81.png)
![S2_3_Результаты_поиска.png](screenshots/S2_3_%D0%A0%D0%B5%D0%B7%D1%83%D0%BB%D1%8C%D1%82%D0%B0%D1%82%D1%8B_%D0%BF%D0%BE%D0%B8%D1%81%D0%BA%D0%B0.png)

Сценарий 3. Перейдите на страницу Студенту. Выполните подписку
на новости. Определите результат подписки в случае корректного и
некорректного e-mail.
![S3_1_Страница_Студенту.png](screenshots/S3_1_%D0%A1%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0_%D0%A1%D1%82%D1%83%D0%B4%D0%B5%D0%BD%D1%82%D1%83.png)
![S3_2_Введен_неверный_email.png](screenshots/S3_2_%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD_%D0%BD%D0%B5%D0%B2%D0%B5%D1%80%D0%BD%D1%8B%D0%B9_email.png)
![S3_3_После_ошибки_email.png](screenshots/S3_3_%D0%9F%D0%BE%D1%81%D0%BB%D0%B5_%D0%BE%D1%88%D0%B8%D0%B1%D0%BA%D0%B8_email.png)
![S3_4_Введен_верный_email.png](screenshots/S3_4_%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD_%D0%B2%D0%B5%D1%80%D0%BD%D1%8B%D0%B9_email.png)
![scenario3_НеуспешныйAlert.jpg](screenshots/scenario3_%D0%9D%D0%B5%D1%83%D1%81%D0%BF%D0%B5%D1%88%D0%BD%D1%8B%D0%B9Alert.jpg)
![scenario3_УспешныйAlert.jpg](screenshots/scenario3_%D0%A3%D1%81%D0%BF%D0%B5%D1%88%D0%BD%D1%8B%D0%B9Alert.jpg)
![FAILED_scenario3_subscribeToNews.png](screenshots/FAILED_scenario3_subscribeToNews.png)
org.openqa.selenium.ElementClickInterceptedException: element click intercepted: Element <input type="submit" value="Найти" class="submit"> is not clickable at point (1170, 117). Other element would receive the click: <input type="text" name="query" value="" class="text">
(Session info: chrome=158.0.8127.88)
Ошибка:       WebElement subscribeButton = driver.findElement(By.cssSelector("input[type='submit']"));
Испрвлено:    WebElement subscribeButton = driver.findElement(By.xpath("//input[@value='Подписаться на новости']"));

Задача 2.
На сайте https://otzovik.com выполните следующие сценарии.

Сценарий 1. В поисковой строке введите "яндекс". В выпадающем
списке выберите "Yandex Metro - программа для Android". Убедитесь, что
открылась нужная страница, количество отзывов не пусто.
![T2_S1_1_Открыт_сайт.png](screenshots/T2_S1_1_%D0%9E%D1%82%D0%BA%D1%80%D1%8B%D1%82_%D1%81%D0%B0%D0%B9%D1%82.png)
![T2_S1_2_Введен_запрос.png](screenshots/T2_S1_2_%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD_%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81.png)
![T2_S1_3_Открыт_нужная_страница.png](screenshots/T2_S1_3_%D0%9E%D1%82%D0%BA%D1%80%D1%8B%D1%82_%D0%BD%D1%83%D0%B6%D0%BD%D0%B0%D1%8F_%D1%81%D1%82%D1%80%D0%B0%D0%BD%D0%B8%D1%86%D0%B0.png)

Сценарий 2. Нажмите на кнопку "Написать отзыв". В поле введите
точное название. Выберите ботанический сад в Кирове. Заполните часть
обязательных полей, нажмите предпросмотр. Убедитесь, что открылось
диалоговое окно с ошибками.
![T2_S2_1_Открыт_сайт.png](screenshots/T2_S2_1_%D0%9E%D1%82%D0%BA%D1%80%D1%8B%D1%82_%D1%81%D0%B0%D0%B9%D1%82.png)
![T2_S2_2_Введен_запрос.png](screenshots/T2_S2_2_%D0%92%D0%B2%D0%B5%D0%B4%D0%B5%D0%BD_%D0%B7%D0%B0%D0%BF%D1%80%D0%BE%D1%81.png)
![T2_S2_3_Форма_заполнена.png](screenshots/T2_S2_3_%D0%A4%D0%BE%D1%80%D0%BC%D0%B0_%D0%B7%D0%B0%D0%BF%D0%BE%D0%BB%D0%BD%D0%B5%D0%BD%D0%B0.png)
![T2_S2_4_Окно_с_ошибкой.png](screenshots/T2_S2_4_%D0%9E%D0%BA%D0%BD%D0%BE_%D1%81_%D0%BE%D1%88%D0%B8%D0%B1%D0%BA%D0%BE%D0%B9.png)
java.lang.AssertionError: Ошибка
Ошибка:     Assert.assertTrue("Ошибка", alertText.contains("внимание!"));
Исправлено: Assert.assertTrue("Ошибка", alertText.contains("ВНИМАНИЕ!"));

Задача 3.
На сайте https://m.cdsvyatka.com/ выполните следующие сценарии.

Сценарий 1. Выберите населенный пункт и маршрут. Покажите
выбранный маршрут на карте. Для выбранного маршрута получите
характеристики какого-то автобуса (рис. 1). Убедитесь, что характеристики
автобуса отображаются.
![T3_S1_1_Открыт_сайт.png](screenshots/T3_S1_1_%D0%9E%D1%82%D0%BA%D1%80%D1%8B%D1%82_%D1%81%D0%B0%D0%B9%D1%82.png)
![T3_S1_2_Открыта_карта.png](screenshots/T3_S1_2_%D0%9E%D1%82%D0%BA%D1%80%D1%8B%D1%82%D0%B0_%D0%BA%D0%B0%D1%80%D1%82%D0%B0.png)
![T3_S1_3_Характеристики_автобуса.png](screenshots/T3_S1_3_%D0%A5%D0%B0%D1%80%D0%B0%D0%BA%D1%82%D0%B5%D1%80%D0%B8%D1%81%D1%82%D0%B8%D0%BA%D0%B8_%D0%B0%D0%B2%D1%82%D0%BE%D0%B1%D1%83%D1%81%D0%B0.png)
![FAILED_scenario1_getRoute.png](screenshots/FAILED_scenario1_getRoute.png)
java.lang.AssertionError: Характеристики не содержат нужных данных

Сценарий 2. Выберите населенный пункт, маршрут и остановку.
Получите прогноз. Убедитесь, что открылась нужная страница, на которой
можно определить время ожидания и номер автобуса.
![T3_S2_1_Открыт_сайт.png](screenshots/T3_S2_1_%D0%9E%D1%82%D0%BA%D1%80%D1%8B%D1%82_%D1%81%D0%B0%D0%B9%D1%82.png)
![T3_S2_2_Выбраны_город_маршрут_остановка.png](screenshots/T3_S2_2_%D0%92%D1%8B%D0%B1%D1%80%D0%B0%D0%BD%D1%8B_%D0%B3%D0%BE%D1%80%D0%BE%D0%B4_%D0%BC%D0%B0%D1%80%D1%88%D1%80%D1%83%D1%82_%D0%BE%D1%81%D1%82%D0%B0%D0%BD%D0%BE%D0%B2%D0%BA%D0%B0.png)
![T3_S2_3_Получен_прогноз.png](screenshots/T3_S2_3_%D0%9F%D0%BE%D0%BB%D1%83%D1%87%D0%B5%D0%BD_%D0%BF%D1%80%D0%BE%D0%B3%D0%BD%D0%BE%D0%B7.png)







