package tools;

import data.Product;
import data.UnitOfMeasure;

import java.io.File;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс, управляющий коллекцией
 */
public class CollectionManager {
    private static HashMap<Integer, Product> productCollection = new HashMap<Integer, Product>();
    private LocalDate lastInitTime;
    private LocalDate lastSaveTime;
    private String readEnv;
    private String writeEnv;
    public CollectionManager(){}
    public CollectionManager(String readEnv, String writeEnv){
        this.readEnv = readEnv;
        this.writeEnv = writeEnv;
        init();
    }


    public final void init() {
        productCollection = JsonManager.readCollection(readEnv);
    }

    public final String show() {
        if(productCollection.size() > 0) {
            String output = productCollection.entrySet().stream()
                    .map(entry -> entry.getValue().toString())
                    .collect(Collectors.joining("\n"));
            return output;
        }
        else return "Коллекция пуста";
    }

    public final String info(){

        try{
            if(lastSaveTime == null || lastInitTime == null) throw new NullPointerException();
            return "Время последней инициализации : " +  lastInitTime + "\n" +
                    "Время последнего сохранения : " + lastSaveTime + "\n" +
                    "Тип : " + productCollection.getClass() + "\n" +
                    "Количество элементов : " + productCollection.size() + "\n";
        }
        catch (NullPointerException e){

            try{
                if(lastSaveTime == null || lastInitTime == null) throw new NullPointerException();
                return "Время последней инициализации : " +  lastInitTime + "\n" +
                        "Время последнего сохранения коллекции не было сохранено\n" +
                        "Тип : " + productCollection.getClass() + "\n" +
                        "Количество элементов : " + productCollection.size() + "\n";
            }
            catch (NullPointerException e1){
                return
                        "Время последней инициализации : коллекция не найдена!\n" +
                                "Время последнего сохранения коллекции не было сохранено\n" +
                                "Тип : " + productCollection.getClass() + "\n" +
                                "Количество элементов : " + productCollection.size() + "\n"
                        ;

            }

        }
    }

    public final String insert() {
        Product product = DataInput.askMusicBand(); //asks user new band
        productCollection.put(product.getId(), product); //puts id + new band element into collection
        lastInitTime = LocalDate.now(); //updates init time
        return "Успешный ввод!";
    }

    public final String removeById(String id) {
        try {
            int newId = Integer.parseInt(id);
            if (productCollection.containsKey(newId)) {
                productCollection.remove(newId);
                return "Удаление прошло успешно!";
            } else
                return "ID не найден!";
        } catch (NumberFormatException e) {
            return "ID должен быть числом!";
        }
    }

    public final String clear() {
        productCollection.clear();
        return "Коллекция очищена";
    }

    public final String updateById(String id) {

        try {
            int newId = Integer.parseInt(id);
            if (productCollection.containsKey(newId)) {
                productCollection.remove(newId);
                productCollection.put(newId, DataInput.askMusicBand());
                return "Успешно обновлено!";
            } else
                return "ID не найден!";

        } catch (NumberFormatException e) {
            return "ID должен быть числом!";
        }
    }

    public String save(){

        File file = new File("fileName");//добавить имя файла
        lastSaveTime = LocalDate.now();
        return JsonManager.writeCollection((LinkedHashMap<Integer, Product>) productCollection, writeEnv);

    }


    public String removeGreater(String element) {

        for (Map.Entry<Integer, Product> map : productCollection.entrySet()) {

            if (map.getValue().getName().compareTo(element) < 0) {
                productCollection.remove(map.getKey());
            }
        }
        return "Элементы удалены";
    }
    public String replaceIfLower(String element){

        int cnt = 0;
        for (Map.Entry<Integer, Product> map : productCollection.entrySet()) {

            if (map.getValue().getName().compareTo(element) > 0) {
                map.getValue().setName(DataInput.askName());
                cnt++;
            }
        }

        if(cnt == 0){
            return "Значений меньше, чем " + element + " не найдено!";
        }
        else if(cnt == 1) {
            return "Значение успешно изменено!";
        }
        else return "Значения успешно изменены!";

    }
    public String replaceIfGreater(String element){

        int cnt = 0;
        for (Map.Entry<Integer, Product> map : productCollection.entrySet()) {

            if (map.getValue().getName().compareTo(element) < 0) {
                map.getValue().setName(DataInput.askName());
                cnt++;
            }
        }

        if(cnt == 0){
            return "Значений меньше, чем " + element + " не найдено!";
        }
        else if(cnt == 1) {
            return "Значение успешно изменено!";
        }
        else return "Значения успешно изменены!";

    }

    public String removeLowerKey(String key){

        try{
            int cnt = 0;
            int newKey = Integer.parseInt(key);
            for(int keys : productCollection.keySet()){

                if(keys > newKey){
                    productCollection.remove(keys);
                    cnt++;
                }
            }
            if(cnt == 0){
                return "Значений больше, чем " + key + " не найдено!";
            }
            else if(cnt == 1) {
                return "Значение успешно удалено!";
            }
            else return "Значения успешно удалены!";
        }
        catch (NumberFormatException e){
            return "Ключ должен являться числом!";
        }
    }

    public String filterLessThanUnitOfMeasure(String genre){
        String outputOrder;
        LinkedList<Product> musicBands = new LinkedList<Product>();
        UnitOfMeasure newGenre = UnitOfMeasure.valueOf(genre.toUpperCase());
        try {
            for (Map.Entry<Integer, Product> map : productCollection.entrySet()) {

                if (map.getValue().getUnitOfMeasure().compareTo(newGenre) > 0) {
                    musicBands.add(map.getValue());
                }
            }
            outputOrder = Arrays.toString(new LinkedList[]{musicBands});
            return outputOrder;
        }
        catch(NumberFormatException e){
            return "Аргумент должен быть названием жанра!";
        }
    }

    //public String countGreaterThanDescription(String description){
    //    try{
    //        String newDescription = description;
    //        int cnt = 0;
    //        for (Map.Entry<Integer, MusicBand> map : data.entrySet()) {
//
   //             if (map.getValue().getDescription().compareTo(description) < 0) {
    //                cnt++;
    //            }
     //       }
    //        return cnt + "";
    //    }
   //     catch (NumberFormatException e){
  //          return "Аргумент должен быть строкой!";
   //     }
   // }
    public String printDescending(){
        String outputOrder = "";
        List<Integer> products = new ArrayList<>();

        for (Map.Entry<Integer, Product> map : productCollection.entrySet()) {
            products.add(map.getValue().getId());
        }
        products.sort(Collections.reverseOrder());

        outputOrder = Arrays.toString(new List[]{products});
        return outputOrder;
    }
    public String printDescendingPrice(){
        String outputOrder = "";
        List<Long> price = new ArrayList<>();

        for (Map.Entry<Integer, Product> map : productCollection.entrySet()) {
                price.add(map.getValue().getPrice());
        }
        price.sort(Collections.reverseOrder());

        outputOrder = Arrays.toString(new List[]{price});
        return outputOrder;
    }
    public String printDescendingUnitOfMeasure(){
        String outputOrder = "";
        List<UnitOfMeasure> unitOfMeasures = new ArrayList<>();

        for (Map.Entry<Integer, Product> map : productCollection.entrySet()) {
            unitOfMeasures.add(map.getValue().getUnitOfMeasure());
        }
        unitOfMeasures.sort(Collections.reverseOrder());

        outputOrder = Arrays.toString(new List[]{unitOfMeasures});
        return outputOrder;
    }

    @Override
    public String toString() {
        return "CollectionManager []";
    }
}
