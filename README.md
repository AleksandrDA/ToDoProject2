# ToDoProject1
добавил весь проект 6.03.2020 для того, чтобы показать ошибку (NullPointerException) в MainPresenter при передаче List<Tasks> tasks в МainActivity. 
а именно в этом методе:
@Override
    public void onPassTaskMainView(final List<Tasks> tasks) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {               
                receiveDataRoomInterface.onDataReceive(tasks);
            }
        });
        Log.d(TAG,"onPassTaskMainView in class MainPresenter " + tasks + Thread.currentThread().getName());
    }
    строка receiveDataRoomInterface.onDataReceive(tasks); выдает NullPointerException
