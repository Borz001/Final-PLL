import java.util.ArrayList;

import model.*;

public class Main {
    static ArrayList<Music> musics = new ArrayList<>();
    static ArrayList<customer> customers = new ArrayList<>();
    static ArrayList<Spotify> employees = new ArrayList<>();
    static ArrayList<OrderMusic> orders = new ArrayList<>();

    public static void main(String[] args) {
           initData();

           String musicinfo=
                   String.format("Общее кол-во проданных песен %d на сумму %f",GetCountOfSoldMusics(),getAllPriceOfSoldMusics());
           System.out.println(musicinfo);
    }






    public static double getAllPriceOfSoldMusics(){
        double price = 0;
        for(OrderMusic order : orders){
            price+=GetPriceOfSoldMusicsInOrder(order);

        }
        return price;
    }




    public static double GetPriceOfSoldMusicsInOrder(OrderMusic order) {
        double price = 0;

        for(long musicid : order.getMusics()){
            Music music = getMusicById(musicid);
            if (music != null) {
                price += music.getPrice();
            }

        }
        return price;
    }

    public static int GetCountOfSoldMusics() {
        int count = 0;
        for (OrderMusic ordermusic : orders) {
            count += ordermusic.getMusics().length;
        }
        return count;
    }



    public static Music getMusicById(long id) {
        Music current = null;
        for(Music music: musics) {
            if(music.getId() == id) {
                current = music;
                break;
            }
        }

        return current;

    }








    public static void initData() {
        // Продавцы
        employees.add(new Spotify(1, "Иванов Иван", 32));
        employees.add(new Spotify(2, "Петров Петр", 30));
        employees.add(new Spotify(3, "Васильева Алиса", 26));

        // Покупатели
        customers.add(new customer(1, "Сидоров Алексей", 25));
        customers.add(new customer(2, "Романов Дмитрий", 32));
        customers.add(new customer(3, "Смирнов Кирилл", 19));
        customers.add(new customer(4, "Кириленко Данил", 45));
        customers.add(new customer(5, "Воротинцева Элина", 23));

        // Музыка
        musics.add(new Music(1, "Symphony No.5", "Beethoven", 1600, MusicGenre.Rap));
        musics.add(new Music(2, "Bohemian Rhapsody", "Queen", 600, MusicGenre.Rock));
        musics.add(new Music(3, "Thriller", "Michael Jackson", 750, MusicGenre.Pop));
        musics.add(new Music(4, "Shape of You", "Ed Sheeran", 500, MusicGenre.Pop));

        musics.add(new Music(5, "Lose Yourself", "Eminem", 1050, MusicGenre.Pop));
        musics.add(new Music(6, "Sicko Mode", "Travis Scott", 550, MusicGenre.Rap));
        musics.add(new Music(7, "In the End", "Linkin Park", 1000, MusicGenre.Rock));

        musics.add(new Music(8, "Sandstorm", "Darude", 900, MusicGenre.Pop));
        musics.add(new Music(9, "Animals", "Martin Garrix", 1200, MusicGenre.Rock));
        musics.add(new Music(10, "Clair de Lune", "Debussy", 850, MusicGenre.Pop));
        musics.add(new Music(11, "Rhapsody in Blue", "Gershwin", 450, MusicGenre.Rap));

        // Заказы
        orders.add(new OrderMusic(1, 1, 1, new long[]{8, 9, 10, 11}));
        orders.add(new OrderMusic(2, 1, 2, new long[]{1}));

        orders.add(new OrderMusic(3, 2, 3, new long[]{5, 6, 7}));
        orders.add(new OrderMusic(4, 2, 4, new long[]{1, 2, 3, 4}));

        orders.add(new OrderMusic(5, 3, 5, new long[]{2, 5, 9}));
    }
}


