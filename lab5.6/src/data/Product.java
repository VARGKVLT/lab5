package data;

import java.time.LocalDateTime;

public class Product {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    public static Integer counter = 0;
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long price; //Значение поля должно быть больше 0
    private UnitOfMeasure unitOfMeasure; //Поле не может быть null
    private Organization manufacturer; //Поле не может быть null
    /**
     * создаем функцию продукта
     */
    public Product(String name, Coordinates coordinates, long price, UnitOfMeasure unitOfMeasure, Organization manufacturer){
        id = counter++;
        this.name=name;
        this.coordinates=coordinates;
        this.creationDate= LocalDateTime.now();
        this.price=price;
        this.unitOfMeasure=unitOfMeasure;
        this.manufacturer=manufacturer;
    }
    /**
     *
     * @return id продукта
     */
    public int getId(){return id;}

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return name продукта
     */
    public String getName(){return name;}

    public void setName(String name){this.name = name;}
    /**
     *
     * @return coordinates продукта
     */
    public Coordinates getCoordinates() {return coordinates;}
    public void setCoordinates(Coordinates coordinates){this.coordinates = coordinates;}
    /**
     *
     * @return дата создания
     */
    public LocalDateTime getCreationDate() {return creationDate;}
    /**
     *
     * @return стоимость
     */
    public long getPrice() {return price;}
    public void setPrice(long price){this.price = price;}
    /**
     *
     * @return способ счисления
     */
    public UnitOfMeasure getUnitOfMeasure() {return unitOfMeasure;}
    public void setUnitOfMeasure(UnitOfMeasure unitOfMeasure){this.unitOfMeasure = unitOfMeasure;}
    /**
     *
     * @return производитель
     */
    public Organization getManufacturer() {return manufacturer;}
    public void setManufacturer(Organization manufacturer){this.manufacturer = manufacturer;}

    /**
     * создаем карту продукта
     */
    @Override
    public String toString(){
        String info = "";
        info += "Продукт №" + id;
        info += "\n Имя: " + name;
        info += "\n Местоположение: " + coordinates;
        info += " (добавлен " + creationDate.toLocalDate() + " " + creationDate.toLocalTime() + ")";
        info += "\n Стоимость: " + price;
        info += "\n : в чем измеряется" + unitOfMeasure;
        info += "\n Производитель: " + manufacturer;
        return info;
    }

    @Override
    public int hashCode(){
        return name.hashCode() + coordinates.hashCode() + unitOfMeasure.hashCode() + manufacturer.hashCode();
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj) return true;
        if (obj instanceof Product){
            Product prodObj = (Product) obj;
            return name.equals(prodObj.getName()) && coordinates.equals(prodObj.getCoordinates()) && (price == prodObj.getPrice()) && unitOfMeasure.equals(prodObj.getUnitOfMeasure()) && manufacturer.equals(prodObj.getManufacturer());
        }
        return false;
    }
}