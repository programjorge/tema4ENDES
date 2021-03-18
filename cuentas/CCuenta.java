package cuentas;
public class CCuenta {


    private String nombre;
    private String cuenta;
    private double saldo;
    private double tipoInteres;
    

    public CCuenta()
    {
    }

    public CCuenta(String nom, String cue, double sal, double tipo)
    {
        nombre =nom;
        cuenta=cue;
        saldo=sal;
    }
   /**
    * metodo para editar el nombre
    * @param nombre
    */
    public void setNombre(String nombre) {
    	this.nombre=nombre;
    }
    /**
     * metodo para editar la cuenta
     * @param cuenta
     */
    public void setCuenta(String cuenta) {
    	this.cuenta=cuenta;
    }
    /**
     * metodo para editar el saldo
     * @param saldo
     */
    public void setSaldo(double saldo) {
    	this.saldo=saldo;
    }
    /**
     * metodo para editar el tipo de interes
     * @param tipoInteres
     */
    
    public void setTipoInteres(double tipoInteres) {
    	this.tipoInteres=tipoInteres;
    }
    /**
     * metodo para saber el saldo de nuestra cuenta
     * @return float saldo actual
     */
    public double estado()
    {
        return saldo;
    }
    /**
     * metodo para ingresar el dinero
     * @param cantidad
     * @throws Exception
     */
    public void ingresar(double cantidad) throws Exception
    {
        if (cantidad<0)
            throw new Exception("No se puede ingresar una cantidad negativa");
        saldo = saldo + cantidad;
    }
    /**
     * 	metodo que para retirar el dinero
     * @param cantidad
     * @throws Exception
     */
    public void retirar(double cantidad) throws Exception
    {
        if (cantidad <= 0)
            throw new Exception ("No se puede retirar una cantidad negativa");
        if (estado()< cantidad)
            throw new Exception ("No se hay suficiente saldo");
        saldo = saldo - cantidad;
    }
    /**
     * refactorizacion operativa_cuenta que engloba las funciones ingrear y retirar. 
     * el float cantidad no va hacer nada pero es pedido.
     * @param retiro
     * @param ingreso
     * @param cantidad
     * @return
     */
    public String operativa_cuenta(double retiro, double ingreso, float cantidad) {
    	
    	String resultado;
    	
    	try{
    		
    		this.retirar(retiro);
    		this.ingresar(ingreso);
    		
    		resultado="el saldo actual es: "+this.estado();
    		
    	}catch(Exception e){
    		
    		resultado="algo ha fallado"; 
    		System.out.println(e.toString());
    	}
    	return resultado;
    }
}
