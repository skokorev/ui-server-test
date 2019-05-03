# language: ru

@FR
@MainFlow
Функциональность:
  Предыстория:
    Пусть система установлена и доступна для пользователей в браузере
    И при открытии системы в браузере пользователь видит главный экран системы

    Сценарий: 1. Проверка пустого списка
      Если пользователь заходит на главный экран системы
      Тогда он видит пустой список элементов

    Сценарий: 2. Проверка добавления элементов в список
      Если пользователь заходит на главный экран системы
        И вводит в поле для добавления нового элемента значение <text> и нажимает на кнопку ввода
        | text  |
        | test1 |
        | test2 |
        | test3 |
      Тогда пользователь видит в списке 3 элемента

    Сценарий: 3. Проверка добавленных элементов
      Если пользователь заходит на главный экран системы
      Тогда он видит в списке элементов
        | id  | result  |
        | 0   | test1   |
        | 0   | test2   |
        | 0   | test3   |

    Сценарий: 4. Проверка удаления всех элементов
      Если пользователь заходит на главный экран системы
        И он нажимает на кнопку удаления всех элементов
      Тогда он видит пустой список элементов

    Сценарий: 5. Закрытие браузера
      Если пользователь закрывает браузер
      Тогда заказничаем тестирование