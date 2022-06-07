package data;

public class Organization {
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private long annualTurnover; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле может быть null

    /**
     * создаем функцию организации
     */
    public Organization(long id,String name, long annualTurnover,OrganizationType type){
        this.id=id;
        this.name=name;
        this.annualTurnover=annualTurnover;
        this.type=type;
    }

    /**
     * @return номер организации
     */
    public long getId(){return id;}
    /**
     * @return название организации
     */
    public String getName(){return name;}
    /**
     * @return деньги в году
     */
    public long getAnnualTurnover(){return annualTurnover;}
    /**
     * @return тип организации
     */
    public OrganizationType getType(){return type;}

    /**
     * Выводит переменные с которрыми мы работаем
     * ToString метод для возврата строки, представляющей экземпляр объекта
     */
    @Override
    public String toString(){
        return id + " (" + name + " " + annualTurnover + " " + type + ")";
    }

    /**
     * пеевод переменные в целочисленный вид
     * hashCode - для генерации целочисленного кода объекта
     * не работает с числами в виде Double но работает с обычными double
     */
    @Override
    public int hashCode() {return (int) (id +  name.hashCode() + annualTurnover + type.hashCode());}

    /**
     * сравнием переменные между переменными другого объекта
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Organization) {
            Organization OrganizationObj = (Organization) obj;
            return id == (OrganizationObj.getId()) && (name.equals(OrganizationObj.getName())) && (annualTurnover == (OrganizationObj.getAnnualTurnover())) && (type.equals(OrganizationObj.getType()));
        }
        return false;
    }
}