import java.security.Guard;

public interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Guitar is begin played.");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Piano is begin played.");
    }
}

class Main3 {
    public static void main(String[] args) {
        Guitar g = new Guitar();
        Piano p = new Piano();
        p.play();
        g.play();
    }
}