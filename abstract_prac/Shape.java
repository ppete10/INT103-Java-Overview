public abstract class Shape {
    public abstract double calculateArea();
    public double add(double num1,double num2) {
        return num1 + num2;
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return 3.14 * radius * radius;
    }
}

class Rectangle extends Shape {
    private double base;
    private double height;

    public Rectangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return base * height;
    }
}

class Main {
    public static void main(String[] args) {
        Circle c = new Circle(5) ;
        Rectangle r = new Rectangle(5,5) ;
        System.out.println(c.calculateArea());
        System.out.println(r.calculateArea());
        System.out.println(c.add(1,1));
    }
}
