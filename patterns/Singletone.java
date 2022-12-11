package patterns;

class DataBase{
    private DataBase(){}

    private static DataBase instance;

    // статический метод может быть вызван без создания эксземпляра класса
    public static DataBase getInstance() {
        if(instance==null) {
            instance = new DataBase();
            return instance;
        } else {
            return instance;
        }
    }
}

public class Singletone {
    public static void main(String[] args) {
        DataBase db1 = DataBase.getInstance();
        DataBase db2 = DataBase.getInstance();
        System.out.println(db1==db2);   
    }
}