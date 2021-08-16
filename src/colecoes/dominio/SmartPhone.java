package colecoes.dominio;

public class SmartPhone implements  Comparable {

    private String serialNumber;
    private String marca;

    public SmartPhone(String serialNumber, String marca) {
        this.serialNumber = serialNumber;
        this.marca = marca;
    }

    //Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null
    //Simétrico: para x e y diferente de null, se x.equals(y) == true logo, y.equals(x) == true
    //Transitividade: para x y z, diferente de null, se x.equals(y) == true, e x.equals(z) == true, logo x.equals(z) == true
    //Consistente: x.equals(x) sempre retorna true se x for diferente de null
    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false;
        if(this == obj) return true;
        if(this.getClass() != obj.getClass()) return false;
        SmartPhone smartPhone = (SmartPhone) obj;
        return serialNumber != null && serialNumber.equals(smartPhone.serialNumber);
    }


    // se x.equals(y) == true, x.hashCode() == y.hashCode()
    // y.hashCode() == x.hashCode() não necessariamente o equals y.equals(x) tem que ser true
    // x.equals(y) == false
    // y.hashCode() == x.hashCode() x.equals(y) deverá ser false
    @Override
    public int hashCode() {
        return serialNumber == null ? 0: this.serialNumber.hashCode();
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "serialNumber='" + serialNumber + '\'' +
                ", marca='" + marca + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
