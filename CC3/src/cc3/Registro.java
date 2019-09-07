
package cc3;


public class Registro {
    private String musica;
    private String cantor;
    private String compo;
    private String genero;
    
    public Registro(String m, String ca, String co, String g){
        this.setMusica(m);
        this.setCantor(ca);
        this.setCompo(co);
        this.setGenero(g);
    }
    
    public void listar(){
        System.out.println("Dados\n\nMúsica: "+this.getMusica());
        System.out.println("Dados\n\nCantor(a): "+this.getCantor());
        System.out.println("Dados\n\nCompositores: "+this.getCompo());
        System.out.println("Dados\n\nGênero: "+this.getGenero());
        
    }
    
    public String getMusica() {
        return musica;
    }
    public String getCantor() {
        return cantor;
    }
    public String getCompo() {
        return compo;
    }
    public String getGenero() {
        return genero;
    }
  
    
    public void setMusica(String musica) {
        this.musica = musica;
    }
    public void setCantor(String cantor) {
        this.cantor = cantor;
    }
    public void setCompo(String compo) {
        this.compo = compo;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    
}
