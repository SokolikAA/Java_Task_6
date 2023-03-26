import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

// 1. Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// 2. Создать множество ноутбуков (ArrayList).
// 3. Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
// Например, спросить у пользователя минимальный размер оперативной памяти или конкретный цвет.
// Выводить только те ноутбуки, что соответствуют условию
public class Task {
    public static void main(String[] args) {
        Laptop lp1 = new Laptop("Asus", "15 D543MA-DM1368", 4, 1000, "Windows 10", "черный");
        Laptop lp2 = new Laptop("Honor", "MagicBook 16", 16, 512, "без ОС", "серый");
        Laptop lp3 = new Laptop("Apple", "MacBook Air 13", 8, 256, "MacOs", "серый");
        Laptop lp4 = new Laptop("Acer", "Aspire 3 A315-23-R0HR", 4, 256, "Linux", "черный");
        Laptop lp5 = new Laptop("MSI", "Modern 15 B11-002RU", 8, 256, "Windows 11", "черный");
        Laptop lp6 = new Laptop("Huawei", "MateBook D16 RLEF-X", 16, 512, "Windows 10", "серый");
        Laptop lp7 = new Laptop("HP", "250 G7", 4, 1024, "без ОС", "черный");
        Laptop lp8 = new Laptop("Xiaomi", "RedmiBook 15", 8, 256, "Windows 11", "серый");
        Laptop lp9 = new Laptop("Asus", "ROG Zephyrus G14 GA402RJ-L4045", 8, 1000, "Без ОС", "серый");

        HashSet<Laptop> laptops = new HashSet<>(Arrays.asList(lp1, lp2, lp3, lp4, lp5, lp6, lp7, lp8, lp9));
        Scanner scan = new Scanner(System.in);
        boolean command = true;
        while (command) {
            System.out.println("""
                    Введите соответствующий пункт меню, по которому хотите сделать выбор:\s
                    Производитель - 1
                    ОЗУ - 2
                    Объем жесткого диска - 3
                    Операционноая система - 4
                    Цвет - 5
                    Посмотреть все модели - 6
                    Выход из меню - 0""");

            String operation = scan.nextLine();

            switch (operation) {
                case "1" -> filterBrand(laptops, scan);
                case "2" -> filterRAM(laptops, scan);
                case "3" -> filterHardDisk(laptops, scan);
                case "4" -> filterOS(laptops, scan);
                case "5" -> filterColor(laptops, scan);
                case "6" -> showCatalog(laptops);
                case "0" -> {
                    System.out.println("До новых встреч!");
                    command = false;
                }
                default -> {
                    System.out.println("Введена неправильная операция");
                    System.out.println();
                }
            }
        }
    }


    // Фильтрация по производителю
    private static void filterBrand(HashSet<Laptop> laptops, Scanner scan) {
        TreeSet<String> brands = new TreeSet<>();
        for (Laptop lap : laptops) {
            brands.add(lap.getBrand());
        }
        System.out.println();
        System.out.println("Есть ноутбуки следующих производителей: "
                + brands + "\n" +
                "Введите интересующего производителя: ");

        String variable = scan.nextLine().toUpperCase();
        if (brands.contains(variable)) {
            System.out.println();
            System.out.println("Есть следующие модели по вашему запросу: ");
            System.out.println();
            for (Laptop note : laptops) {
                if (note.getBrand().equals(variable)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такого производителя. Попробуйте снова");
            filterBrand(laptops, scan);
        }
    }

    // Фильтрация по объему ОЗУ
    private static void filterRAM(HashSet<Laptop> laptops, Scanner scan) {
        TreeSet<Integer> ram = new TreeSet<>();
        for (Laptop note : laptops) {
            ram.add(note.getRam());
        }
        System.out.println();
        System.out.println("Есть ноутбуки c оперативной паматью: "
                + ram.toString().replaceAll("^\\[|$", "") + "\n" +
                "Введите интересующую оперативную память: ");

        String variable = scan.nextLine();
        int filter = Integer.parseInt(variable);
        if (ram.contains(filter)) {
            System.out.println();
            System.out.println("Есть следующие модели по вашему запросу: ");
            System.out.println();
            for (Laptop note : laptops) {
                if (note.getRam() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такой оперативной памяти. Попробуйте снова");
            filterRAM(laptops, scan);
        }
    }

    // Фильтрация по объему жесткого диска
    private static void filterHardDisk(HashSet<Laptop> laptops, Scanner scan) {
        TreeSet<Integer> hardDisk = new TreeSet<>();
        for (Laptop note : laptops) {
            hardDisk.add(note.getHardDisk());
        }
        System.out.println();
        System.out.println("Есть ноутбуки c объемом жесткого диска: "
                + hardDisk.toString().replaceAll("^\\[|$", "") + "\n" +
                "Введите интересующий объем жесткого диска: ");

        String variable = scan.nextLine();
        int filter = Integer.parseInt(variable);
        if (hardDisk.contains(filter)) {
            System.out.println();
            System.out.println("Есть следующие модели по вашему запросу: ");
            System.out.println();
            for (Laptop note : laptops) {
                if (note.getHardDisk() == filter) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет жесткого диска такого объема. Попробуйте снова");
            filterHardDisk(laptops, scan);
        }
    }

    // Фильтрация по операционной системе
    private static void filterOS(HashSet<Laptop> laptops, Scanner scan) {
        TreeSet<String> os = new TreeSet<>();
        for (Laptop note : laptops) {
            os.add(note.getOs());
        }
        System.out.println();
        System.out.println("Есть ноутбуки со следующей операционной системой: "
                + os.toString().replaceAll("^\\[|$", "") + "\n" +
                "Введите интересующую операционную систему: ");

        String variable = scan.nextLine().toUpperCase();
        if (os.contains(variable)) {
            System.out.println();
            System.out.println("Есть следующие модели по вашему запросу: ");
            System.out.println();
            for (Laptop note : laptops) {
                if (note.getOs().equals(variable)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такой операционной системы. Попробуйте снова");
            filterOS(laptops, scan);
        }
    }

    // Фильтрация по цвету
    private static void filterColor(HashSet<Laptop> laptops, Scanner scan) {
        TreeSet<String> color = new TreeSet<>();
        for (Laptop note : laptops) {
            color.add(note.getColor());
        }
        System.out.println();
        System.out.println("Есть ноутбуки следующего цвета: "
                + color.toString().replaceAll("^\\[|$", "") + "\n" +
                "Введите интересующий цвет: ");

        String variable = scan.nextLine().toLowerCase();
        if (color.contains(variable)) {
            System.out.println();
            System.out.println("Есть следующие модели по вашему запросу: ");
            System.out.println();
            for (Laptop note : laptops) {
                if (note.getColor().equals(variable)) {
                    note.showInfo();
                }
            }
        } else {
            System.out.println("Нет такого цвета. Попробуйте снова");
            filterColor(laptops, scan);
        }
    }

    private static void showCatalog(HashSet<Laptop> laptops) {
        System.out.println();
        System.out.println("Полный каталог ноутбуков: ");
        System.out.println();
        for (Laptop note : laptops) {
            note.showInfo();
        }
    }
}
