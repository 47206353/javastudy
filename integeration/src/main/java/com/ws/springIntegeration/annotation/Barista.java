package com.ws.springIntegeration.annotation;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hp on 2015/3/9.
 */
public class Barista {
    private long hotDrinkDelay = 1000;

                        private long coldDrinkDelay = 700;

                         private AtomicInteger hotDrinkCounter = new AtomicInteger();

                         private AtomicInteger coldDrinkCounter = new AtomicInteger();


                        public void setHotDrinkDelay(long hotDrinkDelay) {
                       this.hotDrinkDelay = hotDrinkDelay;
                    }

                         public void setColdDrinkDelay(long coldDrinkDelay) {
                         this.coldDrinkDelay = coldDrinkDelay;
                    }

                        public void prepareHotDrink(Drink drink) {
                        try {
                                 Thread.sleep(this.hotDrinkDelay);
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                             }
                         System.out.println("prepared hot drink #" + hotDrinkCounter.incrementAndGet() + ": " + drink);
                    }

                        public void prepareColdDrink(Drink drink) {
                         try {
                                 Thread.sleep(this.coldDrinkDelay);
                             } catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                         System.out.println("prepared cold drink #" + coldDrinkCounter.incrementAndGet() + ": " + drink);
                     }

}
