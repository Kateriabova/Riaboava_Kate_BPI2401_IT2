package seventhlab;

import java.util.*;
import java.util.concurrent.locks.*;

public class Warehouse {

    static final double MAX = 150;

    static Lock lock = new ReentrantLock();
    static Condition loadPhase = lock.newCondition();
    static Condition deliverPhase = lock.newCondition();

    static List<Double> items;
    static int index = 0;

    static double total = 0;
    static boolean loading = true;
    static boolean finished = false;

    static int activeLoaders = 0;
    static int delivered = 0;
    static int turn = 1;

    static class Loader implements Runnable {
        String name;
        int myTurn;
        double load = 0;

        Loader(String name, int turn) {
            this.name = name;
            this.myTurn = turn;
        }

        @Override
        public void run() {
            try {
                while (!finished) {
                    while (loading && !finished) {
                        // если фаза ожидания или груз кончился
                        lock.lock();
                        try {
                            while (turn != myTurn && !finished) {
                                loadPhase.await();
                                if (!loading || finished) break;
                                // если не его очередь и не завершилось то поток спит, если изменилась фаза или выполнение закончилось мы выходим из этого цикла
                            }

                            if (!loading || finished) break;
                            // и из этого тоже

                            if (index >= items.size()) {
                                System.out.println(name + ": товары кончились");
                                if (total > 0) {
                                    // есть что доставить (после этой фазы идем доставлять)
                                    loading = false;
                                    loadPhase.signalAll();
                                    deliverPhase.signalAll();
                                } else {
                                    // работа завершилась
                                    finished = true;
                                    loadPhase.signalAll();
                                    deliverPhase.signalAll();
                                    return;
                                }
                                // в любом случае выходим из фазы
                                break;
                            } 
                            // иначе грузим товары

                            double w = items.get(index);
                            if (total + w <= MAX) {
                                total += w;
                                if (load == 0) {
                                    // грузчики, которые что-то взяли
                                    activeLoaders++;
                                }
                                load += w;
                                index++;
                                System.out.println(name + " взял " + w + " кг. Всего: " + total);

                                if (total == MAX) {
                                    // больше взять не можем, заканчиваем фазу
                                    loading = false;
                                    loadPhase.signalAll();
                                    deliverPhase.signalAll();
                                    break;
                                } else if (index < items.size()) {
                                    // сразу прорверим, влезит ли следующий
                                    double nextW = items.get(index);
                                    if (total + nextW > MAX) {
                                        // если не влезет то продолжать бесполезно и сразу заканчиваем фазу
                                        loading = false;
                                        loadPhase.signalAll();
                                        deliverPhase.signalAll();
                                        break;
                                    } else {
                                        // иначе передаем эстафету следующему грузчику. 
                                        turn = (turn % 3) + 1;
                                        loadPhase.signalAll();
                                    }
                                } else {
                                    // если это был последний груз то передадим эстафету чтобы быстро и безболезненно обработать это в в блоке, который выше
                                    turn = (turn % 3) + 1;
                                    loadPhase.signalAll();
                                }
                            } else {
                                // если положить ничего больше не можем тоже заканчиваем фазу
                                loading = false;
                                loadPhase.signalAll();
                                deliverPhase.signalAll();
                                break;
                            }

                        } finally {
                            // былли-не были искоючения, ресурсы нужно разблокировать. 
                            lock.unlock();
                        }
                    }

                    if (finished) break;
                    // если мы закончили то выходим из цикла !finished

                    lock.lock();
                    // захватываем ресурс
                    try {
                        while (loading && !finished) {
                            // если не все погрузили не рыпаемся
                            deliverPhase.await();
                        }
                        if (finished) break;
                        // если все кончено, то все кончено
                    } finally {
                        lock.unlock();
                        // разблокируем чтобы все могли доставить
                    }

                    if (load > 0) { // доставочка
                        System.out.println(name + " везет " + load + " кг");
                        Thread.sleep(300);
                        System.out.println(name + " вернулся");
                    }
                    // снова захватываем ресурс кем-то одним
                    lock.lock();
                    try {
                        if (finished) break;
                        
                        if (load > 0) {
                            // считаем кол-во тех, кому есть что доставить (и они доставили)
                            delivered++;
                        }
                        
                        boolean iAmLast = (delivered >= activeLoaders && activeLoaders > 0); // проверка на последнего
                        
                        if (iAmLast) {
                            // последний, значит все сбрасываем и топаем опять на погрузку, если товаров больше нет, обрабатываем это в погрузке
                            delivered = 0;
                            activeLoaders = 0;
                            total = 0;
                            loading = true;
                            turn = 1; // снова первый грузчик
                            deliverPhase.signalAll();
                            loadPhase.signalAll();
                            // всех будим чтобы шли работать
                        } else {
                            // спим пока ждем пока последний нас разбудит
                            deliverPhase.await();
                        }
                        // после этого всем обнуляем вес груза
                        load = 0;
                        
                    } finally {
                        lock.unlock();
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        items = new ArrayList<>();

        for (String p : s.nextLine().split(",")) {
            items.add(Double.parseDouble(p.trim()));
        }

        Collections.sort(items);
        System.out.println("Товары: " + items);

        Thread t1 = new Thread(new Loader("Грузчик 1", 1));
        Thread t2 = new Thread(new Loader("Грузчик 2", 2));
        Thread t3 = new Thread(new Loader("Грузчик 3", 3));

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Все перевезено");
    }
}