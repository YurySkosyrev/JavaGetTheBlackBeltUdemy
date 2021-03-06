package com.javacourse.multithreading;

public class ObjectLockingEx {

    static final Object lock = new Object();

   void mobileCall(){
       synchronized (lock) {
           System.out.println("Mobile call starts");
           try {
               Thread.sleep(3000);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           System.out.println("Mobile call ends");
       }
    }

    void skypeCall(){
        synchronized (lock) {
            System.out.println("Skype call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Skype call ends");
        }
    }

    void whatsappCall(){
        synchronized (lock) {
            System.out.println("WhatsApp call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("WhatsApp call ends");
        }
    }

    public static void main(String[] args) {

        Thread thread1 = new Thread(new RunnableImpMobile());
        Thread thread2 = new Thread(new RunnableImpSkype());
        Thread thread3 = new Thread(new RunnableImpWhatsApp());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableImpMobile implements Runnable{
    @Override
    public void run() {
        new ObjectLockingEx().mobileCall();
    }
}

class RunnableImpSkype implements Runnable{
    @Override
    public void run() {
        new ObjectLockingEx().skypeCall();
    }
}

class RunnableImpWhatsApp implements Runnable{
    @Override
    public void run() {
        new ObjectLockingEx().whatsappCall();
    }
}
