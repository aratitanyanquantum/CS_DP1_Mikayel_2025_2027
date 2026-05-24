package lesson_2026_05_24.homework;

class Cart{

}



class CartNode {
    private Cart ThisCart;
    private CartNode next;

    public CartNode(Cart Cart1) {
        this.ThisCart = Cart1;
        this.next = null;
    }

    public Cart getCart() {
        return this.ThisCart;
    }
    public CartNode getNext() {
        return this.next;
    }
    public void setNext(CartNode nextNode) {
        this.next = nextNode;
    }
}




class POSLine{
    private String id;
    private boolean active;
    private Cart[] line = new Cart[20];

    public void setId(String id) {
        this.id = id;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setLine(Cart[] line) {
        this.line = line;
    }

    public String getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public Cart getLine(int n){
        return line[n];
    }

    public void joinLine(Cart newCart) {
        int i = 0;
        while (line[i] != null) {
            i++;
        }
        line[i] = newCart;
    }

    public void checkoutCart(){

    }

    public Cart leaveline(int n){
        Cart removeCart = line[n];
        line[n] = null;
        while(line[++n] != null){
            line[n-1] = line[n];
        }
        line[n] = null;
        return removeCart;
    }



}


class POSlist {
    private CartNode list;

    public Cart removeFirst() {
        Cart firstCart = list.getCart();
        list = list.getNext();
        return firstCart;
    }

    public Cart leaveList(int n) {
        if (n == 0) {
            return removeFirst();
        }
        CartNode current = list;
        for (int i = 0; i < n - 1; i++) {
            current = current.getNext();
        }
        CartNode target = current.getNext();
        current.setNext(target.getNext());
        return target.getCart();
    }
}



class POSSystem{
    public POSLine split(POSLine line1) {
        POSLine line2 = new POSLine();

        int count = 0;
        int count2 = 0;
        while (line1.getLine(count) != null) {
            count++;
        }

        for (int i = 1; i < count; i += 2) {
            line2.joinLine(line1.getLine(i));
            count2=i;
        }

        for (int i = count2; i >= 1; i -= 2) {
            line1.leaveline(i);
        }

        return line2;
    }
}



public class POSDemo {
    static void main(String[] args) {
    }
}

