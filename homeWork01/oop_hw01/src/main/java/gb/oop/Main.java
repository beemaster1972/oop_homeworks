/*
Урок 1. Принципы ООП: Инкапсуляция, наследование, полиморфизм
Домашнее задание на закрепление:

1)Создать класс Товар, имеющий переменные имя, цена, рейтинг.
2)Создать класс Категория, имеющий переменные имя и массив товаров. Создать несколько объектов класса Категория.
3)Создать класс Basket, содержащий массив купленных товаров.
4)Создать класс User, содержащий логин, пароль и объект класса Basket. Создать несколько объектов класса User.
5)Вывести на консоль каталог продуктов. (все продукты магазина)
6)Вывести на консоль покупки посетителей магазина. (После покупки у пользователя добавляется товар, а из магазина - удаляется)

Всё вышеуказанное создать согласно принципам ООП, пройденным на семинаре

Формат сдачи:
Ссылка на гитхаб проект
Подписать фамилию и номер группы
 */
package gb.oop;

public class Main {
    public static void main(String[] args) {
        String separator = "===================================================";
        Store store = new Store("Шестерочка");
        Product bottledWater = new BottledWater("Borjome",300,10.1,1.0);
        Product frozenStuff = new FrozenStuff();
        Product bottledWater2 = new BottledWater();
        Product frozenChicken = new FrozenStuff("Циплёнок жареный");
        Product borjome = new BottledWater("Borjome", 120, 0.5);
        ProductCategory frozenStuffCat = new ProductCategory("Полуфабрикаты");
        ProductCategory bottledWaterCat = new ProductCategory("Вода");
        frozenStuffCat.addProduct(frozenStuff);
        frozenStuffCat.addProduct(frozenChicken);
        bottledWaterCat.addProduct(borjome);
        bottledWaterCat.addProduct(bottledWater2);
        bottledWaterCat.addProduct(bottledWater);
        store.addProductToStore(bottledWaterCat,10);
        store.addProductToStore(frozenStuffCat,20);
        User ivanov = new User("Ivan Ivanov", "ivan", "pass");
        User petrov = new User("Petr Petrov","petr","12345");
        System.out.println(separator);
        System.out.println(ivanov);
        System.out.println(separator);
        System.out.println(petrov);
        System.out.println(separator);
        System.out.printf("В магазине '%s' есть товары:%n",store.getName());
        store.showStore();
        System.out.println(separator);
        store.sell(ivanov,borjome,5);
        store.sell(ivanov,borjome,5);
        store.sell(ivanov,frozenStuff,14);
        store.sell(petrov,frozenStuffCat,20);
        store.sell(petrov,borjome,5);
        store.sell(petrov,frozenChicken,13);
        System.out.printf("У покупателя %s в корзине находятся товары: %n", ivanov.getName());
        ivanov.showUserBasket();
        System.out.println(separator);
        System.out.printf("У покупателя %s в корзине находятся товары: %n", petrov.getName());
        petrov.showUserBasket();
        System.out.println(separator);
        System.out.printf("В магазине '%s' есть товары:%n",store.getName());
        store.showStore();
        System.out.println(separator);
    }
}