package concorrencia.dominio;

public class Discount {
    public enum Code{
        NONE(0),
        SUPER_SAYAJIN(5),
        SUPER_SAYAJIN2(10),
        SUPER_SAYAJIN3(15);
        private final int percent;

        Code(int percent) {
            this.percent = percent;
        }

        public int getPercent() {
            return percent;
        }
    }
}

