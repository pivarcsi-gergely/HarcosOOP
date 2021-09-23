package hu.petrik;

public class Harcos {
    private String nev;
    private int szint;
    private int tapasztalat;
    private int eletero;
    private int alapEletero;
    private int alapSebzes;



    public Harcos(String nev, int statuszSablon){
        this.nev = nev;
        this.szint = 1;
        this.tapasztalat = 0;
        switch (statuszSablon){
            case 1: this.alapEletero = 15; this.alapSebzes = 3; break;
            case 2: this.alapEletero = 12; this.alapSebzes = 4; break;
            case 3: this.alapEletero = 8; this.alapSebzes = 5; break;
            default:
        }
    }



    public String getNev() {
        return this.nev;
    }
    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getSzint() {
        return szint;
    }
    public void setSzint(int szint) {
        if (tapasztalat >= getSzintLepeshez()){
            szint += 1;
        }
        this.szint = szint;
    }

    public int getTapasztalat() {
        return this.tapasztalat;
    }
    public void setTapasztalat(int tapasztalat) {
        if (tapasztalat>=getSzintLepeshez()){
            tapasztalat -= getSzintLepeshez();
        }
        this.tapasztalat = tapasztalat;
    }

    public int getAlapEletero() {
        return this.alapEletero;
    }

    public int getAlapSebzes() {
        return this.alapSebzes;
    }

    public int getEletero() {
        return this.eletero;
    }
    public void setEletero(int eletero) {

        if (eletero == 0){
            setTapasztalat(tapasztalat = 0);
        }
        else if (eletero > MaxEletero()){
            eletero = MaxEletero();
        }
        this.eletero = eletero;
    }

    public int getSebzes(){
        return alapSebzes + szint;
    }

    public int getSzintLepeshez(){
        return 10 + szint*5;
    }

    public int MaxEletero(){
        return alapEletero + szint*3;
    }


    public void megkuzd(Harcos masikHarcos){
        boolean harcosEgyezes = (this == masikHarcos);
        boolean elesettAzEgyikHarcos = this.eletero == 0  || masikHarcos.eletero == 0;
        boolean aSajatHarcosEsettEl = this.eletero == 0;
        boolean masikHarcosEsettEl = masikHarcos.eletero == 0;
        if (harcosEgyezes){
            System.out.println("Nem tudsz saját magaddal harcolni!");
        }
        if (elesettAzEgyikHarcos){
            if (aSajatHarcosEsettEl){
                masikHarcos.setTapasztalat(masikHarcos.tapasztalat+10);
            }
            if (masikHarcosEsettEl){
                this.setTapasztalat(this.tapasztalat+10);
            }
            System.out.println("Nem tudsz egy halott ellenfél ellen harcolni!");
        }
        if (!elesettAzEgyikHarcos  || !harcosEgyezes){
            masikHarcos.setEletero(masikHarcos.eletero-this.getSebzes());
        }
        if (!elesettAzEgyikHarcos || !harcosEgyezes){
            this.setEletero(this.eletero-masikHarcos.getSebzes());
        }
        if (!aSajatHarcosEsettEl){
            this.setTapasztalat(tapasztalat+5);
        }
        if (!masikHarcosEsettEl){
            masikHarcos.setTapasztalat(tapasztalat+5);
        }
    }

    public void gyogyul(){
        if (eletero == 0){
            eletero = MaxEletero();
        }
        else {
            setEletero(eletero += 3 + getSzint());
        }
    }

    @Override
    public String toString() {
        return this.nev + " - " + "LVL: " + this.szint +
                " EXP: " + this.tapasztalat + "/" + this.getSzintLepeshez() +
                " - HP: " + eletero + "/" + MaxEletero() + " - DMG: " +
                getSebzes();
    }
}
