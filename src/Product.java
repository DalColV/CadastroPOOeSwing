class Product implements Comparable<Product>{
private final String name;
private final String description;

private final double price;

public Product(String name, String description, double price)
        {
        this.name = name;
        this.description = description;
        this.price = price;
        }

public String getName()
        {
        return name;
        }

public String getDescription()
        {
        return description;
        }

public double getPrice()
        {
        return price;
        }

@Override
public String toString()
        {
        return "Name:  " + name +  "  | Price: " + price;
        }

@Override
public int compareTo(Product outroProduct)
        {
        return Double.compare(this.price, outroProduct.price);
        }
        }

