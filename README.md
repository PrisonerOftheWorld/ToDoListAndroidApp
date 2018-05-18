# ToDoListAndroidApp
data -<br>
   managers - класс DataManger имеет статический метод getInstance() он предоставляет объект самого себя и метод getPreferenceManager()<br> 
   который предоставляет объект PreferenceManager который с помощью своих методов позволяет хранить переменные<br>
   и их значения(к примеру токены)<br>
   network -<br>
      interceptors- здесь будет храниться interceptor который служит чтобы в будущем подставлять токены в запрос на сервер автоматически<br>
      requests- класс RetrofitService с помощью метода createService(класс отвечающий за запросы(на данный момент ApiRequests))<br>
      может инициализировать класс отвечающий за запросы (на данный момент ApiRequests)<br>
        services- ApiRequest класс содержащий методы делающие запросы<br>
model- модели для запросов<br>
ui- все activity здесь<br>
utils- класс App предоставляет нам контекст и SharedPreferences(служит для хранения переменных) в единственном числе<br>
