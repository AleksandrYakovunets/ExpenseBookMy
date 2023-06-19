package de.ait.models;

public enum Category {
    NUTRITION("Питание"),
    HOUSEHOLD("Домашние расходы"),
    HEALTH("Здоровье"),
    CLOTH("Одежда"),
    PUBLICUTILITES("Коммунальные услуги"),
    AUTOMOBILE("Автомобиль");
    public String nameCategory;



    Category(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return nameCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}
