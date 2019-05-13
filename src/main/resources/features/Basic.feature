# language: ru

@FR
@MainFlow
Функциональность: Основные функции системы
  Система должна позволять пользователю вводить новые элементы
  Система должна позволять удалять все элементы из списка
  Система должна поддерживать на экране пользователя актуальное состояние списка
  При двойном вводе система должна выдавать ошибку

    Сценарий: 0. Открытие страницы системы в браузере
      Пусть система установлена и доступна для пользователей в браузере
      Тогда при открытии системы в браузере пользователь видит главный экран системы

    Сценарий: 1. Проверка пустого списка
      Если пользователь заходит на главный экран системы
      Тогда он видит пустой список элементов

    Сценарий: 2. Проверка добавления элементов в список
      Если пользователь заходит на главный экран системы
        И вводит в поле для добавления нового элемента значения и нажимает на кнопку ввода:
        | test1 |
        | test2 |
        | test3 |
      Тогда пользователь видит в списке 3 элемента

    Сценарий: 3. Проверка добавленных элементов
      Если пользователь заходит на главный экран системы
      Тогда он видит в списке элементов:
      | id  | result  |
      | 0   | test1   |
      | 0   | test2   |
      | 0   | test3   |

    Сценарий: 4. Проверка двойного ввода
      Если пользователь заходит на главный экран системы
      И вводит в поле для добавления нового элемента значения и нажимает на кнопку ввода:
        | test3 |
      Тогда пользователь видит окно с ошибкой
      И текст ошибки "Cannot enter existing string: test3"
      И закрывает окно с ошибкой

    Сценарий: 5. Проверка удаления всех элементов
      Если пользователь заходит на главный экран системы
        И он нажимает на кнопку удаления всех элементов
      Тогда он видит пустой список элементов

    Сценарий: 6. Закрытие браузера
      Если пользователь закрывает браузер
      Тогда заканчиваем тестирование