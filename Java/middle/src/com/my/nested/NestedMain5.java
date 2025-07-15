package com.my.nested;

class Button {
    public interface ClickListener{
        public void onClick();              //추상 메서드
    }

    public interface OffClickListener{
        void offClick();
    }

    private ClickListener clickListener;

    public void setClickListener(ClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void click() {
        this.clickListener.onClick();
    }

}
public class NestedMain5 {
    public static void main(String[] args) {
        Button ok = new Button();
        Button off = new Button();
        class OffListener implements Button.ClickListener{
            @Override
            public void onClick() {
                System.out.println("Off Clicked");
            }
        }
        class OkListener implements Button.ClickListener{
            @Override
            public void onClick() {
                System.out.println("OK Clicked");
            }
        }
        ok.setClickListener(new OkListener());
        off.setClickListener(new OffListener());
        ok.click();
        off.click();

    }
}
