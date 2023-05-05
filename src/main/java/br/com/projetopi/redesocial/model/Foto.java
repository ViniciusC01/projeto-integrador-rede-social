package br.com.projetopi.redesocial.model;

public class Foto {
    private int id;
    private byte[] cd_foto;

    public Foto(int id, byte[] cd_fotos) {
    }

    public Foto(byte[] dados) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getCd_foto() {
        return cd_foto;
    }

    public void setCd_foto(byte[] cd_foto) {
        this.cd_foto = cd_foto;
    }
}
