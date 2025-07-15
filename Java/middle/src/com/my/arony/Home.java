package com.my.arony;

public class Home {
    private RemoteControl rc = new RemoteControl() {
        @Override
        public void turnOn() {
            System.out.println("TV ON");
        }

        @Override
        public void turnOff() {
            System.out.println("TV OFF");
        }
    };
    public void use() {
        rc.turnOn();
        rc.turnOff();
    }



    public void use2() {
        RemoteControl rc = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("A/C ON");
            }

            @Override
            public void turnOff() {
                System.out.println("A/C ON");
            }
        };
        rc.turnOn();
        rc.turnOff();

    }
    public void use3(RemoteControl rc) {
        rc.turnOn();
        rc.turnOff();
    }
}
