# ToDoListAndroidApp
data -
   managers - класс DataManger имеет статический метод getInstance() он предоставляет объект самого себя и метод getPreferenceManager() 
   который предоставляет объект PreferenceManager который с помощью своих методов позволяет хранить переменные
   и их значения(к примеру токены)
   network -
      interceptors- здесь будет храниться interceptor который служит чтобы в будущем подставлять токены в запрос на сервер автоматически
      requests- класс RetrofitService с помощью метода createService(класс отвечающий за запросы(на данный момент ApiRequests))
      может инициализировать класс отвечающий за запросы (на данный момент ApiRequests)
        services- ApiRequest класс содержащий методы делающие запросы
model- модели для запросов
ui- все activity здесь
utils- класс App предоставляет нам контекст и SharedPreferences(служит для хранения переменных) в единственном числе
