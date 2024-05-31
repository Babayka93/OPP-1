interface ТорговыйАвтомат {
    ГорячийНапиток getProduct(int name, int volume, int temperature);
}

class ГорячийНапиток {
    private int name;
    private int volume;

    public ГорячийНапиток(int name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public int getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }
}

class ГорячийНапитокСТемпературой extends ГорячийНапиток {
    private int temperature;

    public ГорячийНапитокСТемпературой(int name, int volume, int temperature) {
        super(name, volume);
        this.temperature = temperature;
    }

    public int getTemperature() {
        return temperature;
    }
}

class ГорячиеНапиткиАвтомат implements ТорговыйАвтомат {
    @Override
    public ГорячийНапиток getProduct(int name, int volume, int temperature) {
        return new ГорячийНапитокСТемпературой(name, volume, temperature);
    }
}

public class Main {
    public static void main(String[] args) {
        ТорговыйАвтомат автомат = new ГорячиеНапиткиАвтомат();
        ГорячийНапиток напиток1 = автомат.getProduct(1, 250, 60);
        ГорячийНапиток напиток2 = автомат.getProduct(2, 300, 70);

        System.out.println("Напиток 1: Имя - " + напиток1.getName() + ", Объем - " + напиток1.getVolume() + ", Температура - " + ((ГорячийНапитокСТемпературой) напиток1).getTemperature());
        System.out.println("Напиток 2: Имя - " + напиток2.getName() + ", Объем - " + напиток2.getVolume() + ", Температура - " + ((ГорячийНапитокСТемпературой) напиток2).getTemperature());
    }
}