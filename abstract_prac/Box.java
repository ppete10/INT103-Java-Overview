class Box<T> {
    private T contents;
    public void putContents(T contents) {
        this.contents = contents;
    }
    public T getContents() {
        return contents;
    }
}

class Main4 {
    public static void main(String[] args) {
        Box<Integer> intBox = new Box<>();
        intBox.putContents(10);
        System.out.println(intBox.getContents());
    }
}
