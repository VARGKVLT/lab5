package data;

public class Coordinates {
    private long x;
    private double y; //Поле не может быть null

    /**
     * Создаем функцию получения коардинат
     */
    public Coordinates(long x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return x показывает значение
     */
    public long getX(){return x;}

    /**
     * @return y показывает значение
     */
    public double getY(){return y;}

    /**
     * Выводит переменные с которрыми мы работаем
     * ToString метод для возврата строки, представляющей экземпляр объекта
     */
    @Override
    public String toString(){return "X:" + x + "Y:" + y;}

    /**
     * пеевод x и y в целочисленный вид
     * hashCode - для генерации целочисленного кода объекта
     * не работает с числами в виде Double но работает с обычными double
     */
    @Override
    public int hashCode() {
        return (int)y +  (int)x;
    }

    /**
     * сравнием x и y межщду x и y другого объекта
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Coordinates) {
            Coordinates coordinatesObj = (Coordinates) obj;
            return (x == coordinatesObj.getX()) && (y == coordinatesObj.getY());
        }
        return false;
    }
    public boolean isBigger(Object obj){
        if (this == obj) return true;
        if (obj instanceof Coordinates){
            Coordinates cordinatesObj = (Coordinates) obj;
            return (x < cordinatesObj.getX()) && (y < cordinatesObj.getY());
        }
        return false;
    }
}
