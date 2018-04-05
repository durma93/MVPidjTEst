package com.example.durma.sqlitenewbostontutorijal;


public class Products  {

    private int _id;
    private String _productname;
    private String _autor;
    private int _duzina;

    public Products() {
    }

    public Products(String productname, String autor, int duzina) {
        _productname = productname;
        _autor = autor;
        _duzina = duzina;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    public int get_id() {
        return _id;
    }

    public String get_productname() {
        return _productname;
    }

    public String get_autor() {
        return _autor;
    }

    public void set_autor(String _autor) {
        this._autor = _autor;
    }

    public int get_duzina() {
        return _duzina;
    }

    public void set_duzina(int _duzina) {
        this._duzina = _duzina;
    }
}
