# wriketests

для запуска тестов не забудьте убедиться, что используете Firefox v.46 (более поздние версии не работают нормально с Селениум, который я использую - 2.53.0).

используйте maven (3.1.1 or above) - для генерации allure отчетов.

## Технологии и особенности их использования в проекте:

## JUnit
- тесты разделены на Suites, по одному на Retrofit, Chrome и Firefox. Через property “runSuite” можно указать какой из Suite запустить. Если не указать, запустятся все
- используется @Rule TestWatcher - для отлавливания свалившихся UI тестов, для таких случаев делается скриншот, который будет доступен в Allure-отчете

## Guice
- через DI задается текущий браузер. Таким образом код тестов не привязан к браузеру
- где возможно, заменены конструкторы и инициализация полей на @Inject

## Retrofit
- реализован инструмент для создания, удаления, поиска задач и папок
- accessToken добавляется в каждый request с помощью interceptor’а. Таким образом описание сервиса (WrikeService.class) содержит только функциональную информацию
- параметры для @POST передаются с помощью @FieldMap. Для создания мапы используются кастомные классы с композицией Map и паттерном Builder(), который уменьшает вероятность ошибки при написании кода.
- используется логирование HttpLoggingInterceptor

## Html Elements, PageObject pattern, бизнес логика / описание пейджей
- пейдж WorkSpace описан с использованием блоков для лучшей читаемости кода
- бизнес логика / описание пейджей: отдельно описаны пейджы с элементами -> над ними, в отдельных классах описаны возможные степы - *PageSteps -> над степами сами тесты с бизнес логикой - *PageStepsTest

## Allure
- mvn test site генерит Allure-отчет, который, по дефолту, может быть найден в target/site
- используются @Step - для описания степа в *PageSteps, @Description - для описания сути теста, @Parameter - для указания на каком браузере был запущен тест, @Attachment - для сохранения скриншота свалившегося UI теста
- mvn test site запустит все сьюты, таким образом в Allure-отчете будут по паре одних и тех же UI тестов для каждого из браузеров, но в каждом конкретном тесте сверху будет указано с каким именно браузером был запущен UI тест

Проект на https://github.com/vasidzius/wriketests 
Для запуска - mvn clean test site
